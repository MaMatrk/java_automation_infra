package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    final String BASE_URL = "http://tutorialsninja.com/demo/";
    final String MY_ACCOUNT_SELECTOR = "//*[@id=\"top-links\"]//a[contains(@title, \"My Account\")]";
    final String REGISTER_SELECTOR = "//*[@class=\"dropdown-menu dropdown-menu-right\"]/*[a=\"Register\"]";
    final String LOGIN_SELECTOR = "//*[@class=\"dropdown-menu dropdown-menu-right\"]/*[a=\"Login\"]";
    final String REGISTER_PAGE_TITLE_SELECTOR = "//*[@id=\"content\"]//h1[contains(text(),\"Register Account\")]";
    final String LOGIN_PAGE_TITLE_SELECTOR = "//*[@id=\"content\"]//h2[contains(text(),\"Returning Customer\")]";
    final String PHONE_PDA_PAGE_SELECTOR = "//*[@id=\"menu\"]//a[contains(text(), \"Phones & PDAs\")]";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to base URL page
     */
    public void navigate(){
        driver.get(BASE_URL);
    }

    /**
     * Click on My Account drop-down
     * @return MainPage instance
     */
    public MainPage myAccount(){
        click(By.xpath(MY_ACCOUNT_SELECTOR));

        return this;
    }

    /**
     * Click on Register
     * @return RegisterPage instance
     */
    public RegisterPage clickOnRegister(){
        click(By.xpath(REGISTER_SELECTOR));
        isElementDisplayed(By.xpath(REGISTER_PAGE_TITLE_SELECTOR));

        return new RegisterPage(this.driver);
    }

    /**
     * Click on Login
     * @return LoginPage instance
     */
    public LoginPage clickOnLogin(){
        click(By.xpath(LOGIN_SELECTOR));
        isElementDisplayed(By.xpath(LOGIN_PAGE_TITLE_SELECTOR));

        return new LoginPage(this.driver);
    }

    public TradingPage navigateToTargetTradingPage(String productName){
        click(By.xpath("//*[@id=\"menu\"]//a[contains(text(), \""+productName+"\")]"));
        return new TradingPage(this.driver);
    }

}
