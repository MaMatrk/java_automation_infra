package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    public MainPage mainPage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public TradingPage tradingPage;
    public CheckoutPage checkoutPage;

    @BeforeEach
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        tradingPage = PageFactory.initElements(driver, TradingPage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    }

    @AfterEach
    public void finish(){
        driver.quit();
    }
}
