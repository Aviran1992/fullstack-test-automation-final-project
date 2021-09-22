package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TopNavbar {

    @FindBy(how = How.ID, using = "react-burger-menu-btn")
    public WebElement btn_hamburgerMenu;

    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    public WebElement link_cart;
}
