package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Element {

    private WebDriver driver;
    //переменные для кнопок на странице, через xpath
    private By dataSend = By.xpath("//*[@id=\"send_button\"]");
    private By dataHistory = By.xpath("//*[@id=\"history_button\"]");
    private By catalog = By.xpath("//*[@id=\"catalog_button\"]");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //метод для нажатия кнопки Передача показаний
    public void clickSend() {
        click(driver.findElement(dataSend));
    }

    //метод для нажатия кнопки История показаний
    public void clickHistory() {
        click(driver.findElement(dataHistory));
    }

    ////метод для нажатия кнопки Справочник
    public void clickPrice() {
        click(driver.findElement(catalog));
    }
}