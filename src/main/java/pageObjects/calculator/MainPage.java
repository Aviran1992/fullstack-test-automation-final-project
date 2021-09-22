package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    @FindBy(how = How.NAME, using = "Two")
    public WebElement btn_two;

    @FindBy(how = How.NAME, using = "Seven")
    public WebElement btn_seven;

    @FindBy(how = How.NAME, using = "Equals")
    public WebElement btn_equals;

    @FindBy(how = How.NAME, using = "Plus")
    public WebElement btn_plus;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;

    @FindBy(how = How.NAME, using = "Clear entry")
    public WebElement btn_clear;

    @FindBy(how = How.NAME, using = "Minus")
    public WebElement btn_minus;

    @FindBy(how = How.NAME, using = "Multiply by")
    public WebElement btn_multiply;
}
