package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HistoryPage;
import pages.MainPage;
import pages.PricePage;
import pages.SendPage;

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
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bmagomedsherifov\\Desktop\\AT_course\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage = new MainPage(driver);
        sendPage = new SendPage(driver);
        historyPage = new HistoryPage(driver);
        pricePage = new PricePage(driver);
        Thread.sleep(1000);
    }

    public void close() {
        driver.quit();
    }
}
