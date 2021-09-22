package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SauceWebDB extends CommonOps {

    @Test(description = "Test01 - Login To Saucedemo With DB Credentials")
    @Description("This test login with DB credentials and verifies the main header")
    public void test01_verifyLogin() {
        WebFlows.loginDB("SELECT username, password FROM sauce_users WHERE id='1'");
        Verifications.verifyTextInElement(sauceProducts.title_products, "PRODUCTS");
    }

    @Test(description = "Test02 - Login To Saucedemo With DB Credentials")
    @Description("This test tries to login with DB credentials and verifies the error message")
    public void test02_verifyErrorLogin() {
        WebFlows.loginDB("SELECT username, password FROM sauce_users WHERE id='2'");
        Verifications.verifyTextInElement(sauceLogin.errorMessage, getData("LoginError"));
    }
}
