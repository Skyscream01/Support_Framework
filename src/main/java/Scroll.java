import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by yauhen.bialiayeu on 06.06.2016.
 */
public class Scroll extends Utils {

    public static boolean checkHorizontalScroll() {
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        Boolean horScrollStatus = (Boolean) javascript.
                executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
        return  horScrollStatus;
    }

    public static boolean checkVerticalScroll() {
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        Boolean vertScrollStatus = (Boolean) javascript.
                executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
        return vertScrollStatus;
    }

    public static void verticalScroll(int position) {
        if (checkVerticalScroll()) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, " + position + ");");
        }
        else
        // Change to LOGGER
            System.out.println("Page is not scrollable vertically");
    }

    public static void verticalScroll(int position, WebElement scrollBar) {
        Action scroll =  new Actions(driver).clickAndHold(scrollBar).moveByOffset(0,position).release().build();
        scroll.perform();
    }

    public static void horizontalScroll(int position) {
        if (checkHorizontalScroll()) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(" + position + ", 0);");
        }
        else
            // Change to LOGGER
            System.out.println("Page is not scrollable horizontally");
    }

    public static void scrollingToBottomofAPage() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

    public static void scrollToElement(WebElement element, WebElement scrollBar) {
        Action scroll =  new Actions(driver).clickAndHold(scrollBar).moveByOffset(0,30).release().build();
        while (!element.isDisplayed())
            scroll.perform();
        scroll.perform();
    }

}
