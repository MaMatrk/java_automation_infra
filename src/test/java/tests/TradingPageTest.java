package tests;

import enums.UserData;
import org.junit.jupiter.api.Test;

public class TradingPageTest extends BaseTest {

    private String phonesPage = "Phones & PDAs";

    @Test
    public void SortingPriceAscendingDescendingTest(){
        mainPage.navigate();
        mainPage.navigateToTargetTradingPage(phonesPage);
        tradingPage.sortBy().priceAscending();
        tradingPage.isPriceSortedAscending();
        tradingPage.sortBy().priceDescending();
        tradingPage.isPriceSortedDescending();
    }

    @Test
    public void PlacingOrderTest(){
        mainPage.navigate();
        mainPage.navigateToTargetTradingPage(phonesPage);
        tradingPage.addToChart().clickOnTheCart().checkout();
        loginPage.loginAs(UserData.Email_Address.getData()).withPassword(UserData.Password.getData()).login();
        checkoutPage.billingDetails(
                UserData.First_Name.getData(),
                UserData.Last_Name.getData(),
                UserData.Company.getData(),
                UserData.Address.getData(),
                UserData.City.getData(),
                UserData.Post_Code.getData(),
                UserData.Country.getData(),
                UserData.Region_State.getData()).submitBillingDetails();
        checkoutPage.shippingToExistingAddress().submitShippingDetails();
        checkoutPage.submitShippingMethod();
        checkoutPage.agreeTermsAndConditions().submitPaymentMethod();
        checkoutPage.confirmPayment();
    }
}
