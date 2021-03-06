import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

// AT THE CURRENT MOMENT WORKS ONLY WITH CHROME
/**
 * Created by yauhen.bialiayeu on 06.06.2016.
 */
public class Switch extends Utils {
    public static  ArrayList<String> winHandles = new ArrayList<String>();

    public static void createNewTab() {
        if (winHandles.size()==0)
            winHandles.add(driver.getWindowHandle());
        WebElement body = driver.findElement(By.xpath("//body"));
        body.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "t"));
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
        winHandles.add(driver.getWindowHandle());
    }

    public static void switchToWindow(int window) {
        driver.switchTo().window(winHandles.get(window));
    }

    public static void closeTab(int window) {
        winHandles.remove(window);
        driver.close();
    }

    public static void switchToNewWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        winHandles.add(driver.getWindowHandle());
    }

    public static void addWindow() {
        winHandles.add(driver.getWindowHandle());
    }
}
