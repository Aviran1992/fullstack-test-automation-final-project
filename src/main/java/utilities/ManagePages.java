package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    public static void initSauce() {
        sauceLogin = PageFactory.initElements(driver, pageObjects.saucedemo.LoginPage.class);
        sauceProducts = PageFactory.initElements(driver, pageObjects.saucedemo.ProductsPage.class);
        sauceMenu = PageFactory.initElements(driver, pageObjects.saucedemo.LeftMenu.class);
        sauceNav = PageFactory.initElements(driver, pageObjects.saucedemo.TopNavbar.class);
        sauceCart= PageFactory.initElements(driver, pageObjects.saucedemo.CartPage.class);
        sauceCheckout = PageFactory.initElements(driver, pageObjects.saucedemo.CheckoutPage.class);
    }

    public static void initMortgage() {
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
        mortgageSaved = new pageObjects.mortgage.SavedPage(mobileDriver);
    }

    public static void initTodo() {
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initCalculator() {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }

}
