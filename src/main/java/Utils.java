import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by yauhen.bialiayeu on 08.06.2016.
 */
public class Utils {

    protected static WebDriver driver;

    public static void setupDriver(String name) {
      if (name.equals("Chrome") || name.equals("chrome"))
          driver = new ChromeDriver();

        if (name.equals("Firefox") || name.equals("firefox"))
            driver = new FirefoxDriver();

        if (driver==null)
            System.out.println("Driver not found");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
