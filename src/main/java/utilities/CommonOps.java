package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.DesktopFlows;
import workflows.ElectronFlows;
import workflows.MobileFlows;
import workflows.WebFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    /*
     * get data from the xml configuration file
     * parameter: nodeName - node from the xml file
     * return: requested data in form of a String
     */
    public static String getData (String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    /*
     * initialize driver according to the browser type, set timeout and open the browser in the desired url
     * parameter: browserType - browser type (chrome, firefox or ie)
     */
    public static void initBrowser(String browserType) {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid browser type");

        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.manage().window().maximize();
        driver.get(getData("URL"));
        ManagePages.initSauce();
        action = new Actions(driver);
    }

    /*
     * initialize chrome driver
     * return: chrome driver
     */
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
         return new ChromeDriver();
    }

    /*
     * initialize firefox driver
     * return: firefox driver
     */
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    /*
     * initialize internet explorer driver
     * return: internet explorer driver
     */
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    /*
     * initialize mobile driver (android), set timeout and set to the desired app
     */
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Cannot connect to appium server, see details: " + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        action = new Actions(mobileDriver);
    }

    /*
     * initialize REST API objects
     */
    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given();
    }

    /*
     * initialize electron driver and set the desired electron app
     */
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    /*
     * initialize desktop driver and set the desired desktop app
     */
    public static void initDesktop() {
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
            System.out.println("Cannot connect to appium server, see details: " + e);
        }

        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
    }

    /*
     * call the appropriate method according to the platform in order to initialize the driver
     * and open the DB connection
     * parameter PlatformName - platform to test (web, mobile etc.)
     */
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        if(platform.equalsIgnoreCase("web"))
            initBrowser(getData(("BrowserName")));
        else if(platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(platform.equalsIgnoreCase("api"))
            initAPI();
        else if(platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name");

        softAssert = new SoftAssert();
        screen = new Screen();

        ManageDB.openConnection(getData("DBURL"), getData("DBUsername"), getData("DBPass"));
    }

    /*
     * call the recording method before every test
     * parameter: method - name of the current tested method
     */
    @BeforeMethod
    public void beforeMethod(Method method) {
        if(!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * call the appropriate method at the end of every test
     */
    @AfterMethod
    public void afterMethod() {
        if(platform.equalsIgnoreCase("web"))
            WebFlows.clearAndLogout();
        else if(platform.equalsIgnoreCase("electron"))
            ElectronFlows.emptyList();
        else if(platform.equalsIgnoreCase("mobile"))
            MobileFlows.removeAll();
        else if(platform.equalsIgnoreCase("desktop"))
            DesktopFlows.clear();
    }

    /*
     * close the DB connection and driver
     */
    @AfterClass
    public void closeSession() {
        ManageDB.closeConnection();
        if(!platform.equalsIgnoreCase("api")) {
            if(!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

}
