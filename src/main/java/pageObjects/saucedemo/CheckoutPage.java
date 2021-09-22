package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage {

    @FindBy(how = How.ID, using = "first-name")
    public WebElement txt_firstName;

    @FindBy(how = How.ID, using = "last-name")
    public WebElement txt_lastName;

    @FindBy(how = How.ID, using = "postal-code")
    public WebElement txt_postalCode;

    @FindBy(how = How.ID, using = "continue")
    public WebElement btn_continue;

    @FindBy(how = How.ID, using = "finish")
    public WebElement btn_finish;
}
