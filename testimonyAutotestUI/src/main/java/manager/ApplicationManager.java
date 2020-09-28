package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HistoryPage;
import pages.MainPage;
import pages.PricePage;
import pages.SendPage;

import java.util.concurrent.TimeUnit;

// класс отвечающий за создание драйвера и объектов страниц
public class ApplicationManager {

    public WebDriver driver;
    public MainPage mainPage;
    public SendPage sendPage;
    public PricePage pricePage;
    public HistoryPage historyPage;

    public PricePage getPricePage() {
        return pricePage;
    }

    public HistoryPage getHistoryPage() {
        return historyPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public SendPage getSendPage() {
        return sendPage;
    }

    public void init() throws InterruptedException {
        //задаем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmagomedsherifov\\Desktop\\AT_course\\AutotestsLearning\\testimonyAutotestUI\\src\\main\\resources\\chromedriver.exe");
        //инициализируем драйвер
        driver = new ChromeDriver();
        //неявное ожидание
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //задаем страницу, которую необходимо открыть в браузере
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage = new MainPage(driver);
        sendPage = new SendPage(driver);
        historyPage = new HistoryPage(driver);
        pricePage = new PricePage(driver);
    }

    //закрытие окон, после выполнения теста
    public void close() {
        driver.quit();
    }
}
