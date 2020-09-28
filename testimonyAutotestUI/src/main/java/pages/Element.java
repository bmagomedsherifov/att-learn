package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Element extends BasePage {

    private WebDriver driver;
    private By header = By.xpath("/html/body/h1");
    private By backButton = By.xpath("//*[@id='back_button']");

    public Element (WebDriver driver){
        this.driver = driver;
    }

    //метод для получения текста хедера
    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    //метод для нажатия кнопки назад
    public void clickBackButton(){
        //перед тем как кликнуть на кнопку назад тест будет ждать пока кнопка не будет кликабильной и после этого нажмет на нее
        waitForElementClickable(driver.findElement(backButton), driver);
        click(driver.findElement(backButton));
    }

}
