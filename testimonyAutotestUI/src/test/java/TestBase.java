import manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected final ApplicationManager applicationManager = new ApplicationManager();

    @BeforeEach
    public void setupPage() throws InterruptedException{
        applicationManager.init();
    }

    @AfterEach
    public void closePage(){
        applicationManager.close();

    }

}
