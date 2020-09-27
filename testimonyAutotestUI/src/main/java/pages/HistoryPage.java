package pages;

import org.openqa.selenium.WebDriver;

public class HistoryPage extends Element {

    private WebDriver driver;

    public HistoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
