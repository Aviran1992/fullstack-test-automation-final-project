package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class SauceWeb extends CommonOps {

    @Test(description = "Test01 - Verify Login", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test verifies the user login system")
    public void test01_verifyLogin(String username, String state) {
        WebFlows.login(username, getData("Pass"));
        Verifications.verifyTextInElement((WebElement) WebFlows.setLoginVerification(state).get(0), (String) WebFlows.setLoginVerification(state).get(1));
    }

    @Test(description = "Test02 - Verify Visibility Of Products")
    @Description("This test verifies all products are visible (using soft-assert)")
    public void test02_verifyVisibilityOfProducts() {
        WebFlows.login(getData("Username"), getData("Pass"));
        Verifications.verifyVisibilityOfElements(sauceProducts.itemsLinks);
    }

    @Test(description = "Test03 - Verify Checkout Image")
    @Description("This test verifies the checkout image using sikuli tool")
    public void test03_verifyCheckoutImage() {
        WebFlows.login(getData("Username"), getData("Pass"));
        WebFlows.checkout();
        Verifications.visualElement("SauceCheckout");
    }

    @Test(description = "Test04 - Verify Functionality Of Add Buttons")
    @Description("This test verifies the add buttons work")
    public void test04_verifyAddButtons() {
        WebFlows.login(getData("Username"), getData("Pass"));
        WebFlows.addAll();
        Verifications.verifyTextInElement(sauceNav.link_cart, String.valueOf(sauceProducts.addButtons.size()));
    }

    @Test(description = "Test05 - Verify Functionality Of Remove Buttons")
    @Description("This test verifies the remove buttons work")
    public void test05_verifyRemoveButtons() {
        WebFlows.login(getData("Username"), getData("Pass"));
        WebFlows.addAll();
        WebFlows.removeAll();
        Verifications.verifyTextInElement(sauceNav.link_cart, "");
    }

    @Test(description = "Test06 - Verify Sorting Functionality ")
    @Description("This test verifies the sorting dropdown works")
    public void test06_verifySort() {
        WebFlows.login(getData("Username"), getData("Pass"));
        UIActions.updateDropdown(sauceProducts.dropdown_sort, "Name (Z to A)");
        Verifications.verifyTextInElement(sauceProducts.itemsLinks.get(0), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test(description = "Test07 - Check Cart Items List")
    @Description("This test verifies the right number of items were added to the cart")
    public void test07_verifyNumberOfAddedItems() {
        WebFlows.login(getData("Username"), getData("Pass"));
        WebFlows.addItems(2);
        UIActions.click(sauceNav.link_cart);
        Verifications.verifyNumberOfElements(sauceCart.cartItems, 2);
    }
}
