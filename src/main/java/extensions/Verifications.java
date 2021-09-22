package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement element, String expected) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), expected);
    }

    @Step("Verify Number Of Elements")
    public static void verifyNumberOfElements(List<?> list, int expected) {
        if(list.size() > 0)
            wait.until(ExpectedConditions.visibilityOf((WebElement)list.get(list.size() - 1)));
        assertEquals(list.size(), expected);
    }

    @Step("Verify Visibility Of Elements (Soft-Assertion")
    public static void verifyVisibilityOfElements(List<WebElement> list) {
        for (WebElement item : list) {
            softAssert.assertTrue(item.isDisplayed());
        }

        softAssert.assertAll();
    }

    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName) {
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".PNG");
        } catch (FindFailed e) {
            System.out.println("Error Comparing Image Files " + e);
            fail("Error Comparing Image Files " + e);
        }
    }

    @Step("Verify Two Texts Are Identical")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Two numbers Are Identical")
    public static void verifyNumbers(int actual, int expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Text Inequality")
    public static void verifyInequality(String text1, String text2) {
        assertNotEquals(text1, text2);
    }

}
