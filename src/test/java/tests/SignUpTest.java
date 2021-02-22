package tests;

import enums.UserData;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

public class SignUpTest extends BaseTest {
    String email = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";

    @Test
    public void registrationTest(){
        mainPage.navigate();
        mainPage.myAccount().clickOnRegister();
        registerPage.signUpAs(UserData.First_Name.getData(),
                UserData.Last_Name.getData(),
                email,
                UserData.Phone.getData(),
                UserData.Password.getData(),
                UserData.Password.getData()).signUp();
    }

    @Test
    public void registrationWithSubscriptionNewsletterTest(){
        mainPage.navigate();
        mainPage.myAccount().clickOnRegister();
        registerPage.signUpAs(UserData.First_Name.getData(),
                UserData.Last_Name.getData(),
                email,
                UserData.Phone.getData(),
                UserData.Password.getData(),
                UserData.Password.getData()).
                isSubscribe(true).signUp();
    }
}
