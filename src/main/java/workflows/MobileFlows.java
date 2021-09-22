package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Fill Form And Calculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate) {
        MobileActions.updateText(mortgageMain.txt_amount, amount);
        MobileActions.updateText(mortgageMain.txt_term, term);
        MobileActions.updateText(mortgageMain.txt_rate, rate);
        MobileActions.tap(1, mortgageMain.btn_calculate, 500);
    }

    @Step("Business Flow: Save Calculation")
    public static void save() {
        MobileActions.tap(1, mortgageMain.btn_save, 500);
    }

    @Step("Business Flow: Remove One Saved")
    public static void removeSaved() {
        MobileActions.tap(1, mortgageSaved.btns_delete.get(0), 500);
        MobileActions.tap(1, mortgageSaved.btn_confirm, 500);
    }

    @Step("Business Flow: Remove All Saved")
    public static void removeAll() {
        while(mortgageSaved.datesList.size() > 0) {
            MobileActions.tap(1, mortgageSaved.btns_delete.get(0), 500);
            MobileActions.tap(1, mortgageSaved.btn_confirm, 500);
        }

        MobileActions.swipeLeftOrRight("left");
    }
}
