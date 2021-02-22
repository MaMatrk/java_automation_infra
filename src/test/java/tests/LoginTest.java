package tests;

import enums.UserData;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{
    private String fakePassword = "1234";


    @Test
    public void LoginTest(){
        mainPage.navigate();
        mainPage.myAccount().clickOnLogin();
        loginPage.loginAs(UserData.Email_Address.getData()).withPassword(UserData.Password.getData()).login();
    }

    @Test
    public void LoginNegativeTest(){
        mainPage.navigate();
        mainPage.myAccount().clickOnLogin();
        loginPage.loginAs(UserData.Email_Address.getData()).withPassword(fakePassword).failedLogin();
    }
}
