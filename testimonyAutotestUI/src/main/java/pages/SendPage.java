package pages;

import org.openqa.selenium.WebDriver;

public class SendPage extends Element {

    private WebDriver driver;

    public SendPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
