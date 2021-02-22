package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    final String EMAIL_ADDRESS_SELECTOR = "//*[@id=\"input-email\"]";
    final String PASSWORD_SELECTOR = "//*[@id=\"input-password\"]";
    final String LOGIN_BUTTON_SELECTOR = "//input[contains(@value, \"Login\")]";
    final String WARNING_SELECTOR = "//*[@id=\"account-login\"]//div[contains(text(), \" Warning: No match for E-Mail Address and/or Password.\")]";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginAs(String username){
        addValue(By.xpath(EMAIL_ADDRESS_SELECTOR), username);

        return this;
    }

    public LoginPage withPassword(String password){
        addValue(By.xpath(PASSWORD_SELECTOR), password);

        return this;
    }

    public void login(){
        click(By.xpath(LOGIN_BUTTON_SELECTOR));;
    }

    public void failedLogin(){
        click(By.xpath(LOGIN_BUTTON_SELECTOR));
        isElementDisplayed(By.xpath(WARNING_SELECTOR));
    }

}
