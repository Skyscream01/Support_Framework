import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Created by yauhen.bialiayeu on 06.06.2016.
 */
public class TextBox {

    public static void type(WebElement element, String text) {
        element.click();
        String[] array = text.split("");
        for (String symbol : array) {
        element.sendKeys(symbol);
        }
    }

    public static void clear(WebElement element) {
        element.click();
        element.sendKeys(Keys.HOME);
        element.sendKeys(Keys.chord(Keys.LEFT_SHIFT, Keys.END));
        element.sendKeys(Keys.DELETE);
    }
}
