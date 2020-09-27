package pages;

import org.openqa.selenium.WebElement;

public class BasePage {
    protected void click(WebElement element) {
        element.click();
    }
}
