import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yauhen.bialiayeu on 06.06.2016.
 */
public class Waiting {

    // Wait for JS is ready
    public static void waitForBrowserReady(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        wait.until(jQueryLoad);
        wait.until(jsLoad);
    }

    // Wait for element disappear. In most of cases should be applied before waitForBrowserReady method.
    public static void waitTillElementDisappear(WebDriver driver, By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    // -//- for WebElement. Less performance.
    public static void waitTillElementDisappear(WebDriver driver, WebElement element) {
        List<WebElement> list = new ArrayList<WebElement>();
        list.add(element);
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfAllElements(list));
    }
    // Wait for element is clickable
    public static void waitTillElementAppear(WebDriver driver, By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitTillElementAppear(WebDriver driver,WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for Ajax requests are completed
    public static void waitAjaxIsCompleted(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for Ajax
        ExpectedCondition<Boolean> ajaxLoad = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return Ajax.activeRequestCount") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };
        wait.until(ajaxLoad);
    }

    public static void waitABit(final long delayInMilliseconds) {
        try {
            Thread.sleep(delayInMilliseconds);
        } catch (InterruptedException e) {
        }
    }
}
