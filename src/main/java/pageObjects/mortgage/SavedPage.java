package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class SavedPage {

    private AppiumDriver driver;

    public SavedPage(AppiumDriver driver) {
        this.driver = driver;
       // PageFactory.initElements(new AppiumFieldDecorator(driver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "tvTimestamp")
    public List<AndroidElement> datesList;

    @AndroidFindBy(id = "btnDel")
    public List<AndroidElement> btns_delete;

    @AndroidFindBy(id = "button1")
    public AndroidElement btn_confirm;

}
