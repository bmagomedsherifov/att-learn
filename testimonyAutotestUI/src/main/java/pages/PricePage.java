package pages;

import org.openqa.selenium.WebDriver;

public class PricePage extends Element {

    private WebDriver driver;

    public PricePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
