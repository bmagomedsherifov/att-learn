package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendPage extends Element {

    private WebDriver driver;
    private By sendButton = By.xpath("//*[@id=\"button\"]");
    private By dateInput = By.xpath("//*[@id=\"date\"]");
    private By coldDataInput = By.xpath("//*[@id=\"coldData\"]");
    private By hotDataInput = By.xpath("//*[@id=\"hotData\"]");
    private By gasDataInput = By.xpath("//*[@id=\"gasData\"]");
    private By elecDataInput = By.xpath("//*[@id=\"elecData\"]");


    public SendPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //метод для нажатия на кнопку Отправить
    public void clickSendButton() {
        waitForElementClickable(driver.findElement(sendButton), driver);
        click(driver.findElement(sendButton));
    }

    //метод для ввода показаний
    public void InputAllData() {
        driver.findElement(dateInput).sendKeys("28.09.2020");
        driver.findElement(coldDataInput).sendKeys("10");
        driver.findElement(hotDataInput).sendKeys("20");
        driver.findElement(gasDataInput).sendKeys("30");
        driver.findElement(elecDataInput).sendKeys("40");

    }

}
