package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenu {

    @FindBy(how = How.XPATH, using = "//nav[@class='bm-item-list']/a[3]")
    public WebElement btn_logout;

    @FindBy(how = How.XPATH, using = "//nav[@class='bm-item-list']/a[4]")
    public WebElement btn_reset;
}
