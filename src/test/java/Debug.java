import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by yauhen.bialiayeu on 06.06.2016.
 */
public class Debug {
    WebDriver driver = new ChromeDriver();

    @Test
    public void debug() {
        driver.get("http://www.ahalife.com/");
        Waiting.waitForBrowserReady(driver);
        driver.findElement(By.xpath("//a[@data-gacategory='Women']/span[text()='Women']")).click();
        Waiting.waitForBrowserReady(driver);
        driver.findElement(By.xpath("//p[text()='Black Gold Midi']")).click();
        Waiting.waitTillElementDisappear(driver, By.xpath("//p[text()='Black Gold Midi']" ));
        Waiting.waitForBrowserReady(driver);
        driver.findElement(By.xpath("//*[@id='buy-button']")).click();
        TextBox.clear(driver.findElement(By.xpath("//input[@class='desktop-search-input']")));
        TextBox.type(driver.findElement(By.xpath("//input[@class='desktop-search-input']")),"TEst message");
        TextBox.clear(driver.findElement(By.xpath("//input[@class='desktop-search-input']")));
        TextBox.type(driver.findElement(By.xpath("//input[@class='desktop-search-input']")),"New test message");
        Scroll.horizontalScroll(driver, 250);
        Scroll.verticalScroll(driver, 250);
        Scroll.scrollingToBottomofAPage(driver);
        Switch.createNewTab(driver);
        driver.get("http://www.onliner.by/");
        Switch.createNewTab(driver);
        driver.get("http://www.tut.by/");
        Switch.switchToWindow(driver, 0);
        driver.get("http://www.google.com");
        Waiting.waitForBrowserReady(driver);
        driver.findElement(By.id("lst-ib")).sendKeys("first tab");
        Switch.switchToWindow(driver, 1);
        driver.get("http://www.google.com");
        Waiting.waitForBrowserReady(driver);
        driver.findElement(By.id("lst-ib")).sendKeys("second tab");
        Switch.switchToWindow(driver, 2);
        driver.get("http://www.google.com");
        Waiting.waitForBrowserReady(driver);
        driver.findElement(By.id("lst-ib")).sendKeys("third tab");
        Waiting.waitABit(10000);
        driver.quit();
    }
}
