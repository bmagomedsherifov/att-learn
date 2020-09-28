import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PageNavigationTest extends TestBase {


    //Методы помеченные аннотациями @Тест являются тестами
    @Step
    @DisplayName("From Main page to Send page and back TEST")
    @Test
    public void FromMainToSendAndBack() throws InterruptedException {
        //переход на страницу передачи показаний
        applicationManager.getMainPage().clickSend();
        //проверка эквивалентности результатов (проверка совпадения заголовка)
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        //нажатие кнопки назад
        applicationManager.getSendPage().clickBackButton();
        //проверка эквивалентности результатов (проверка совпадения заголовка)
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
    }

    @Step
    @DisplayName("From Main page to History page and back TEST")
    @Test
    public void FromMainToHistoryAndBack () throws InterruptedException {
        applicationManager.getMainPage().clickHistory();
        Assertions.assertEquals(applicationManager.getHistoryPage().getHeaderText(), "История показаний");
        applicationManager.getHistoryPage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
    }

    @Step
    @DisplayName("From Main page to Price page and back TEST")
    @Test
    public void FromMainToPriceAndBack () throws InterruptedException {
        applicationManager.getMainPage().clickPrice();
        Assertions.assertEquals(applicationManager.getPricePage().getHeaderText(), "Справочник стоимости услуг");
        applicationManager.getPricePage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
    }

}