package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "Test01 - Add And Verify New Task")
    @Description("This test adds a new task to the todo list and verifies it was added successfully")
    public void test01_addAndVerifyTask() {
        ElectronFlows.addNewTask("Finish the project");
        Verifications.verifyNumbers(ElectronFlows.countTasks(), 1);
    }

    @Test(description = "Test02 - Verify Completed Filter")
    @Description("This test verifies the functionality of the completed filter button")
    public void test02_VerifyCompletedFilter() {
        ElectronFlows.addNewTask("task one");
        ElectronFlows.filterCompleted();
        Verifications.verifyNumbers(ElectronFlows.countTasks(), 0);
    }

    @Test(description = "Test03 - Verify Date Picker")
    @Description("This test verifies the functionality of the date picker")
    public void test03_VerifyDatePicker() {
        Verifications.verifyInequality(ElectronFlows.getDate(), (ElectronFlows.getTomorrow()));
    }

}
