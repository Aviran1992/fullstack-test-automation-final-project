package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class MobileActions extends CommonOps {

    @Step("Tap on element")
    public static void tap(int fingers, MobileElement element, int duration) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        //mobileDriver.tap(fingers, element,duration);
    }

    @Step("Swipe")
    public static void swipe(int startX, int startY, int endX, int endY, int duration) {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        //mobileDriver.swipe(startX, startY, endX, endY, duration);
    }

    @Step("Swipe Left Or Right")
    public static void swipeLeftOrRight(String direction) {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        int left =  (int) (mobileDriver.manage().window().getSize().width * 0.1);
        int right = (int) (mobileDriver.manage().window().getSize().width * 0.9);
        int middle =(int) (mobileDriver.manage().window().getSize().width * 0.5);

        switch (direction) {
            case "left":
                //mobileDriver.swipe(left, middle, right, middle, 500);
                break;
            case "right":
                //mobileDriver.swipe(right, middle, left, middle, 500);
                break;
        }
    }

    @Step("Zoom element")
    public static void zoom(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        //mobileDriver.zoom(element);
    }

    @Step("Pinch element")
    public static void pinch(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        //mobileDriver.pinch(element);
    }

    @Step("Execute script")
    public static void executeScript(String script) {
        mobileDriver.executeScript(script);
    }

    @Step("Update Text Element")
    public static void updateText(MobileElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
}
