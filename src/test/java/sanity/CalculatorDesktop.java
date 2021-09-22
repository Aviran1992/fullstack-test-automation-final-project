package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01 - Verify Addition Command")
    @Description("This test verifies the functionality of the plus button")
    public void test01_verifyAddition() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 9");
    }

    @Test(description = "Test02 - Verify Subtraction Command")
    @Description("This test verifies the functionality of the minus button")
    public void test02_verifySubtraction() {
        DesktopFlows.calculateSubtraction();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 5");
    }

    @Test(description = "Test03 - Verify Multiplication Command")
    @Description("This test verifies the functionality of the Multiplication button")
    public void test03_verifyMultiplication() {
        DesktopFlows.calculateMultiplication();
        Verifications.verifyTextInElement(calcMain.field_result, "Display is 14");
    }
}
