package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CartPage {

    @FindBy(how = How.CSS, using = ".cart_item")
    public List<WebElement> cartItems;

    @FindBy(how = How.CSS, using = ".checkout_button")
    public WebElement btn_checkout;
}
