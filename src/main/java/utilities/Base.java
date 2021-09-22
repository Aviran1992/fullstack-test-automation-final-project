package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    // general
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    protected static String platform;

    // web
    protected static WebDriver driver;

    // mobile
    protected static AppiumDriver mobileDriver;

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // database
    protected static Connection connection;
    protected static Statement stmt;
    protected static ResultSet rs;

    // page objects - web
    protected static pageObjects.saucedemo.LoginPage sauceLogin;
    protected static pageObjects.saucedemo.ProductsPage sauceProducts;
    protected static pageObjects.saucedemo.LeftMenu sauceMenu;
    protected static pageObjects.saucedemo.TopNavbar sauceNav;
    protected static pageObjects.saucedemo.CartPage sauceCart;
    protected static pageObjects.saucedemo.CheckoutPage sauceCheckout;

    // page objects - mobile
    protected  static pageObjects.mortgage.MainPage mortgageMain;
    protected static pageObjects.mortgage.SavedPage mortgageSaved;

    // page objects - electron
    protected static pageObjects.todo.MainPage todoMain;

    // page objects - desktop
    protected static pageObjects.calculator.MainPage calcMain;

}
