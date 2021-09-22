package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProductsPage {

    @FindBy(how = How.CSS, using = "span[class='title']")
    public WebElement title_products;

    @FindBy(how = How.XPATH, using = "//div[@class='inventory_item_label']/a")
    public List<WebElement> itemsLinks;

    @FindBy(how = How.XPATH, using = "//div[@class='pricebar']/button")
    public List<WebElement> addButtons;

    @FindBy(how = How.CSS, using = "button[class='btn btn_secondary btn_small btn_inventory'")
    public List<WebElement> removeButtons;

    @FindBy(how = How.CLASS_NAME, using = "product_sort_container")
    public WebElement dropdown_sort;

}
