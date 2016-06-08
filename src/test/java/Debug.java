import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by yauhen.bialiayeu on 06.06.2016.
 */
public class Debug {

    @Test
    public void debug() {
        Utils.setupDriver("Chrome");
        Utils.getDriver().get("http://www.ahalife.com/");
        Waiting.waitForBrowserReady();
        Utils.getDriver().findElement(By.xpath("//a[@data-gacategory='Women']/span[text()='Women']")).click();
        Waiting.waitForBrowserReady();
        Utils.getDriver().findElement(By.xpath("//p[text()='Black Gold Midi']")).click();
        Waiting.waitTillElementDisappear(By.xpath("//p[text()='Black Gold Midi']" ));
        Waiting.waitForBrowserReady();
        Utils.getDriver().findElement(By.xpath("//*[@id='buy-button']")).click();
        TextBox.clear(Utils.getDriver().findElement(By.xpath("//input[@class='desktop-search-input']")));
        TextBox.type(Utils.getDriver().findElement(By.xpath("//input[@class='desktop-search-input']")),"TEst message");
        TextBox.clear(Utils.getDriver().findElement(By.xpath("//input[@class='desktop-search-input']")));
        TextBox.type(Utils.getDriver().findElement(By.xpath("//input[@class='desktop-search-input']")),"New test message");
        Scroll.horizontalScroll(250);
        Scroll.verticalScroll(250);
        Scroll.scrollingToBottomofAPage();
        Switch.createNewTab();
        Utils.getDriver().get("http://www.onliner.by/");
        Switch.createNewTab();
        Utils.getDriver().get("http://www.tut.by/");
        Switch.switchToWindow(0);
        Utils.getDriver().get("http://www.google.com");
        Waiting.waitForBrowserReady();
        Utils.getDriver().findElement(By.id("lst-ib")).sendKeys("first tab");
        Switch.switchToWindow(1);
        Utils.getDriver().get("http://www.google.com");
        Waiting.waitForBrowserReady();
        Utils.getDriver().findElement(By.id("lst-ib")).sendKeys("second tab");
        Switch.switchToWindow(2);
        Utils.getDriver().get("http://www.google.com");
        Waiting.waitForBrowserReady();
        Utils.getDriver().findElement(By.id("lst-ib")).sendKeys("third tab");
        Waiting.waitABit(10000);
        Utils.getDriver().quit();
    }
}
