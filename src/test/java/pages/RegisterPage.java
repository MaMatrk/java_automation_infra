package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    final String FIRST_NAME_FIELD_SELECTOR = "//*[@id=\"input-firstname\"]";
    final String LAST_NAME_FIELD_SELECTOR = "//*[@id=\"input-lastname\"]";
    final String EMAIL_ADDRESS_FIELD_SELECTOR = "//*[@id=\"input-email\"]";
    final String TELEPHONE_FIELD_SELECTOR = "//*[@id=\"input-telephone\"]";
    final String PASSWORD_FIELD_SELECTOR = "//*[@id=\"input-password\"]";
    final String PASSWORD_CONFIRM_FIELD_SELECTOR = "//*[@id=\"input-confirm\"]";
    final String POLICY_CHECKBOX_SELECTOR = "//*[@id=\"content\"]//input[contains(@name, \"agree\")]";
    final String SUBMIT_BUTTON_SELECTOR = "//*[@id=\"content\"]//input[contains(@type, \"submit\")]";
    final String REGISTRATION_SUCCESS_MESSAGE_SELECTOR  = "//*[@id=\"content\"]//h1[contains(text(), \"Your Account Has Been Created!\")]";
    final String YES_SUBSCRIBE_SELECTOR  = "//*[@id=\"content\"]/form/fieldset[3]//input[contains(@value, \"1\")]";
    final String NO_SUBSCRIBE_SELECTOR  = "//*[@id=\"content\"]/form/fieldset[3]//input[contains(@value, \"0\")]";

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage signUpAs(String firstName, String lastName, String email, String phone, String pass, String confirmPass){
        addValue(By.xpath(FIRST_NAME_FIELD_SELECTOR), firstName);
        addValue(By.xpath(LAST_NAME_FIELD_SELECTOR), lastName);
        addValue(By.xpath(EMAIL_ADDRESS_FIELD_SELECTOR), email);
        addValue(By.xpath(TELEPHONE_FIELD_SELECTOR), phone);
        addValue(By.xpath(PASSWORD_FIELD_SELECTOR), pass);
        addValue(By.xpath(PASSWORD_CONFIRM_FIELD_SELECTOR), confirmPass);
        click(By.xpath(POLICY_CHECKBOX_SELECTOR));


        return this;
    }

    public RegisterPage isSubscribe(boolean isSubscribe){
        String result = isSubscribe ? YES_SUBSCRIBE_SELECTOR : NO_SUBSCRIBE_SELECTOR;
        click(By.xpath(result));

        return this;
    }

    public void signUp(){
        click(By.xpath(SUBMIT_BUTTON_SELECTOR));
        isElementDisplayed(By.xpath(REGISTRATION_SUCCESS_MESSAGE_SELECTOR));
    }


}
