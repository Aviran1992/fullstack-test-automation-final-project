package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.CSS, using = "input[placeholder='Create a task']")
    public WebElement txt_create;

    @FindBy(how = How.CLASS_NAME, using = "view_2Ow90")
    public List<WebElement> tasks;

    @FindBy(how = How.CLASS_NAME, using = "destroy_19w1q")
    public WebElement btn_delete;

    @FindBy(how = How.CLASS_NAME, using = "allCompletedWrapper_wdM4q")
    public WebElement btn_toggleAllCompleted;

    @FindBy(how = How.CLASS_NAME, using = "toggleVisibilityPanel_hNPyc")
    public WebElement toggleVisibilityPanel;

    @FindBy(how = How.XPATH, using = "//button[@class='filterButton_1-ZkH'][3]")
    public WebElement btn_filterCompleted;

    @FindBy(how = How.CLASS_NAME, using = "dateFormatted_3GjaR")
    public WebElement date;

    @FindBy(how = How.XPATH, using = "//button[@class='wrapper_1SRLB button_3DJvn']")
    public WebElement btn_tomorrow;
}
