package pages;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    //*[@id="collapse-payment-address"]//input[contains(@name, "payment_address") and contains(@value, "new")]

    final String FIRST_NAME_FIELD_SELECTOR = "//*[@id=\"input-payment-firstname\"]";
    final String LAST_NAME_FIELD_SELECTOR = "//*[@id=\"input-payment-lastname\"]";
    final String COMPANY_FIELD_SELECTOR = "//*[@id=\"input-payment-company\"]";
    final String ADDRESS_FIELD_SELECTOR = "//*[@id=\"input-payment-address-1\"]";
    final String CITY_FIELD_SELECTOR = "//*[@id=\"input-payment-city\"]";
    final String PAST_CODE_FIELD_SELECTOR = "//*[@id=\"input-payment-postcode\"]";
    final String COUNTRY_FIELD_SELECTOR = "//*[@id=\"input-payment-country\"]";
    final String REGION_STATE_FIELD_SELECTOR = "//*[@id=\"input-payment-zone\"]";
    final String SUBMIT_PAYMENT_BUTTON_SELECTOR = "//*[@id=\"button-payment-address\"]";
    final String SUBMIT_SHIPPING_BUTTON_SELECTOR = "//*[@id=\"button-shipping-address\"]";
    final String SUBMIT_SHIPPING_METHOD_BUTTON_SELECTOR = "//*[@id=\"button-shipping-method\"]";
    final String SUBMIT_PAYMENT_METHOD_BUTTON_SELECTOR = "//*[@id=\"button-payment-method\"]";
    final String CONFIRM_BUTTON_SELECTOR = "//*[@id=\"button-confirm\"]";
    final String PAYMENT_CHECKBOX_SELECTOR = "//*[@id=\"collapse-payment-address\"]//input[contains(@name, \"payment_address\") and contains(@value, \"new\")]";
    final String SHIPPING_NEW_ADDRESS_CHECKBOX_SELECTOR = "//input[contains(@name, \"shipping_address\") and contains(@value, \"new\")]";
    final String SHIPPING_EXISTING_ADDRESS_CHECKBOX_SELECTOR = "//input[contains(@name, \"shipping_address\") and contains(@value, \"existing\")]";
    final String TERMS_CONDITIONS_CHECKBOX_SELECTOR = "//*[@id=\"collapse-payment-method\"]//input[contains(@name, \"agree\")]";
    final String CONFIRMATION_MESSAGE_SELECTOR = "//*[@id=\"content\"]/h1[contains(text(), \"Your order has been placed!\")]";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage billingDetails(String firstName, String lastName, String company, String address, String city, String pastCode, String country, String regionState){
        if (isExists(By.xpath(PAYMENT_CHECKBOX_SELECTOR))){
            click(By.xpath(PAYMENT_CHECKBOX_SELECTOR));
        }
        addValue(By.xpath(FIRST_NAME_FIELD_SELECTOR), firstName);
        addValue(By.xpath(LAST_NAME_FIELD_SELECTOR), lastName);
        addValue(By.xpath(COMPANY_FIELD_SELECTOR), company);
        addValue(By.xpath(ADDRESS_FIELD_SELECTOR), address);
        addValue(By.xpath(CITY_FIELD_SELECTOR), city);
        addValue(By.xpath(PAST_CODE_FIELD_SELECTOR), pastCode);
        addValue(By.xpath(COUNTRY_FIELD_SELECTOR),country);
        addValue(By.xpath(REGION_STATE_FIELD_SELECTOR), regionState);


        return this;
    }

    public void submitBillingDetails(){
        click(By.xpath(SUBMIT_PAYMENT_BUTTON_SELECTOR));
    }

    public CheckoutPage shippingToExistingAddress(){
        click(By.xpath(SHIPPING_EXISTING_ADDRESS_CHECKBOX_SELECTOR));
        return this;
    }

    public CheckoutPage shippingToNewAddress(){
        click(By.xpath(SHIPPING_NEW_ADDRESS_CHECKBOX_SELECTOR));
        return this;
    }

    public void submitShippingDetails(){
        click(By.xpath(SUBMIT_SHIPPING_BUTTON_SELECTOR));
    }

    public void submitShippingMethod(){
        click(By.xpath(SUBMIT_SHIPPING_METHOD_BUTTON_SELECTOR));
    }

    public CheckoutPage agreeTermsAndConditions(){
        click(By.xpath(TERMS_CONDITIONS_CHECKBOX_SELECTOR));
        return this;
    }

    public void submitPaymentMethod(){
        click(By.xpath(SUBMIT_PAYMENT_METHOD_BUTTON_SELECTOR));
    }

    public void confirmPayment(){
        click(By.xpath(CONFIRM_BUTTON_SELECTOR));
        isElementDisplayed(By.xpath(CONFIRMATION_MESSAGE_SELECTOR));
    }
}
