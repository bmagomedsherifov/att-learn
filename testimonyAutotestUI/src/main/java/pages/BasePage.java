package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    protected final static int WAITING_TIME_IN_SECONDS = 30;

    protected void click(WebElement element) {
        element.click();
    }
    //метод  для проверки наличия веб элемента в DOM дереве
    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    //Создается объект типа WebDriverWait который содержит в себе всего одну функцию until,
    // которая представляет собой правило, по которому стоит ожидать элемент.
    // В качестве правила выступает эта запись ExpectedConditions.elementToBeClickable(element) - ждать пока элемент не будет кликабильным.
    // Ждать будем на протяжении 30 сек (таймер указан в константе WAITING_TIME_IN_SECONDS)
    public static WebElement waitForElementClickable(WebElement element, WebDriver driver) {
        return (new WebDriverWait(driver, WAITING_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
