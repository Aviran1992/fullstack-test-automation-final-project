package workflows;

import extensions.DBActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.Arrays;
import java.util.List;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Login")
    public static void login(String user, String pass) {
        UIActions.updateText(sauceLogin.txt_username, user);
        UIActions.updateText(sauceLogin.txt_password, pass);
        UIActions.click(sauceLogin.btn_login);
    }

    @Step("Business Flow: Set Login Verifications")
    public static List setLoginVerification(String state) {
        switch (state) {
            case "error":
                return Arrays.asList(sauceLogin.errorMessage, getData("LoginError"));
            case "error-free":
                return Arrays.asList(sauceProducts.title_products, "PRODUCTS");
            default:
                return Arrays.asList("Error");
        }
    }

    @Step("Business Flow: Login To SauceDemo with DB Credentials")
    public static void loginDB(String query) {
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(sauceLogin.txt_username, cred.get(0));
        UIActions.updateText(sauceLogin.txt_password, cred.get(1));
        UIActions.click(sauceLogin.btn_login);
    }

    @Step("Business Flow: Checkout")
    public static void checkout() {
        UIActions.click(sauceNav.link_cart);
        UIActions.click(sauceCart.btn_checkout);
        fillForm("Aviran", "Cohen", "390");
        UIActions.click(sauceCheckout.btn_continue);
        UIActions.click(sauceCheckout.btn_finish);
    }

    @Step("Business Flow: Fill Information Form")
    public static void fillForm(String first, String last, String postal) {
        UIActions.updateText(sauceCheckout.txt_firstName, first);
        UIActions.updateText(sauceCheckout.txt_lastName, last);
        UIActions.updateText(sauceCheckout.txt_postalCode, postal);
    }

    @Step("Business Flow: Clear And Logout")
    public static void clearAndLogout() {
        if(driver.findElements(By.id("react-burger-menu-btn")).size() > 0) {
            UIActions.click(sauceNav.btn_hamburgerMenu);
            UIActions.click(sauceMenu.btn_reset);
            UIActions.click(sauceMenu.btn_logout);
        }
    }

    @Step("Business Flow: Add All Items To Cart")
    public static void addAll() {
        for (WebElement btn : sauceProducts.addButtons)
            UIActions.click(btn);
    }

    @Step("Business Flow: Remove All Items From Cart")
    public static void removeAll() {
        for (WebElement btn : sauceProducts.removeButtons)
            UIActions.click(btn);
    }

    @Step("Business Flow: Add Items To The Cart")
    public static void addItems(int numberOfItems) {
        for (int i = 0; i < numberOfItems && i < sauceProducts.itemsLinks.size(); i++) {
            UIActions.click(sauceProducts.addButtons.get(i));
        }
    }
}
