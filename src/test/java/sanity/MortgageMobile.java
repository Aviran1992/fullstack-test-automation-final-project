package sanity;

import extensions.MobileActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test01 - Verify Mortgage")
    @Description("This test fills in mortgage fields and calculate repayment")
    public void test01_verifyMortgage() {
        MobileFlows.calculateMortgage("1000", "3", "4");
        Verifications.verifyTextInElement(mortgageMain.txt_repayment, "£30.03");
    }

    @Test(description = "Test02 - Verify Saved")
    @Description("This test verifies the functionality of the save button")
    public void test02_verifySaved() {
        MobileFlows.save();
        MobileActions.swipeLeftOrRight("right");
        Verifications.verifyNumbers(mortgageSaved.datesList.size(), 1);
    }

    @Test(description = "Test03 - Verify Deletion")
    @Description("This test verifies the functionality of the delete button")
    public void test03_verifyDeletion() {
        for(int i = 0; i < 2; i++)
            MobileFlows.save();
        MobileActions.swipeLeftOrRight("right");
        MobileFlows.removeSaved();
        Verifications.verifyNumberOfElements(mortgageSaved.datesList, 1);
    }
}
