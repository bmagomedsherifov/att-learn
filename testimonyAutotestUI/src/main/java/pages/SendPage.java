package pages;

import manager.Table;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class SendPage extends Element {

    private WebDriver driver;
    private By sendButton = By.xpath("//*[@id=\"button\"]");
    private By dateInput = By.xpath("//*[@id=\"date\"]");
    private By coldDataInput = By.xpath("//*[@id=\"coldData\"]");
    private By hotDataInput = By.xpath("//*[@id=\"hotData\"]");
    private By gasDataInput = By.xpath("//*[@id=\"gasData\"]");
    private By elecDataInput = By.xpath("//*[@id=\"elecData\"]");
    private By inputTable = By.xpath("//*[@id=\"table\"]");


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

    public void checkRowsIsEmpty() {
        Table table = new Table(driver.findElement(inputTable), driver);

        //Расчетный период
        Assertions.assertFalse(table.getValueFromCell(0, 0).isEmpty());
        //Итого
        Assertions.assertFalse(table.getValueFromCell(5, 1).isEmpty());

        for(int i=1; i<5; i++) {
            //Расход
            Assertions.assertFalse(table.getValueFromCell(i, 1).isEmpty());
            //Стоимость
            Assertions.assertFalse(table.getValueFromCell(i, 2).isEmpty());
        }
    }

}
