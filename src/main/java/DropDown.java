import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by yauhen.bialiayeu on 08.06.2016.
 */
public class DropDown {

    public void selectByLabel(WebElement dropDown, String label) {
        dropDown.click();
       List<WebElement> options = dropDown.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (label.equals(option.getText()))
                option.click();
        }
    }
}
