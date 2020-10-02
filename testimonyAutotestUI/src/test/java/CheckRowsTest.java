import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import manager.Table;
public class CheckRowsTest extends TestBase {

    @Test
    public void MainToSendAndSendData() throws InterruptedException {
        //переходим на страницу передачи показаний, нажатием кнопки Передача показаний
        applicationManager.getMainPage().clickSend();
        //проверяем заголовок
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        //заполняем поля
        applicationManager.getSendPage().InputAllData();
        //проверяем значения в таблице
        applicationManager.getSendPage().checkRowsIsEmpty();
    }
}
