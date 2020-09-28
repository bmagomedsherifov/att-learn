import manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected final ApplicationManager applicationManager = new ApplicationManager();

    //методы помеченные данной аннотацией выплоняются кадый раз перед тестом
    @BeforeEach
    public void setupPage() throws InterruptedException{
        applicationManager.init();
    }

    //методы помеченные данной аннотацией выплоняются кадый раз после тестом
    @AfterEach
    public void closePage(){
        applicationManager.close();

    }

}
