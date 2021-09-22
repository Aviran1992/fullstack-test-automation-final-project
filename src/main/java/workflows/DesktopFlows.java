package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Calculate Addition: 2 + 7")
    public static void calculateAddition() {
        UIActions.click(calcMain.btn_seven);
        UIActions.click(calcMain.btn_plus);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Calculate Subtraction: 7 - 2")
    public static void calculateSubtraction() {
        UIActions.click(calcMain.btn_seven);
        UIActions.click(calcMain.btn_minus);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Calculate Multiplication: 2 * 7")
    public static void calculateMultiplication() {
        UIActions.click(calcMain.btn_seven);
        UIActions.click(calcMain.btn_multiply);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Clear")
    public static void clear() {
        UIActions.click(calcMain.btn_clear);
    }
}
