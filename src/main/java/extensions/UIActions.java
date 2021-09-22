package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click On Element")
    public static void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    @Step("Insert Key")
    public static void insertKey(WebElement element, Keys value) {
        element.sendKeys(value);
    }

    @Step("Update Dropdown Element")
    public static void updateDropdown(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    @Step("Mouse hover On Element")
    public static void mouseHover(WebElement element) {
        action.moveToElement(element).click().build().perform();
    }



}
