package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task To The List")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todoMain.txt_create, taskName);
        UIActions.insertKey(todoMain.txt_create, Keys.RETURN);
    }

    @Step("Count Number Of Tasks")
    public static int countTasks() {
        return todoMain.tasks.size();
    }

    @Step("Empty Task List")
    public static void emptyList() {
        for (int i = 0; i < countTasks(); i++)
            UIActions.mouseHover(todoMain.btn_delete);
    }

    @Step("Filter Only Completed Tasks")
    public static void filterCompleted() {
        UIActions.click(todoMain.toggleVisibilityPanel);
        UIActions.click(todoMain.btn_filterCompleted);
    }

    @Step("Get Current Date")
    public static String getDate() {
        return todoMain.date.getText();
    }

    @Step("Get Tomorrow's Date")
    public static String getTomorrow() {
        UIActions.click(todoMain.date);
        UIActions.click(todoMain.btn_tomorrow);
        return getDate();
    }
}
