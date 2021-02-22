package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.parseFloat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradingPage extends BasePage{

    Select sortByDropdown;
    final String SORT_BY_SELECTOR = "//*[@id=\"input-sort\"]";
    final String PRICE_FIELD_SELECTOR = "//*[@id=\"content\"]//p[contains(@class, \"price\")]";
    final String PRICE_VALUE_PATTERN = "\\$(.*?)(?=\\n)";
    final String ADD_TO_CART_BUTTON_SELECTOR = "//*[@id=\"content\"]//i[contains(@class, \"fa fa-shopping-cart\")]";
    final String CART_TOTAL_SELECTOR = "//*[@id=\"cart-total\"]";
    final String CHECKOUT_BUTTON_SELECTOR = "//*[@id=\"cart\"]//i[contains(@class, \"fa fa-share\")]";
    final String CHECKOUT_TITLE_SELECTOR = "//*[@id=\"content\"]//h1[contains(text(), \"Checkout\")]";


    public TradingPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click on the sort by dropdown
     * @return current page
     */
    public TradingPage sortBy(){
        sortByDropdown = getDropdownSelect(By.xpath(SORT_BY_SELECTOR));

        return this;
    }

    /**
     * Sort by price ascending
     * @return current page
     */
    public TradingPage priceAscending(){
        sortByDropdown.selectByVisibleText("Price (Low > High)");

        return this;
    }

    /**
     * ort by price descending
     * @return current page
     */
    public TradingPage priceDescending(){
        sortByDropdown.selectByVisibleText("Price (High > Low)");

        return this;
    }

    /**
     * Get list of presented prices presented in chosen order on the web site
     * @return
     */
    private List getListOfActualValuesOrder(){
        List<WebElement> elements = getListOfWebElements(By.xpath(PRICE_FIELD_SELECTOR));
        List actualValuesOrder = new ArrayList<Float>();
        for (int i = 0; i < elements.size() ; i++) {
            Pattern pattern = Pattern.compile(PRICE_VALUE_PATTERN);
            Matcher matcher = pattern.matcher(elements.get(i).getText().trim());
            if (matcher.find())
            {
                actualValuesOrder.add(i, parseFloat(matcher.group(1)));
            }
        }

        return actualValuesOrder;
    }

    /**
     * Sort prices by ascending
     * @return sorted list
     */
    private List sortedAscending(){
        List array = getListOfActualValuesOrder();
        Collections.sort(array);
        return array;
    }

    /**
     * Sort prices by descending
     * @return sorted list
     */
    private List sortedDescending(){
        List array = getListOfActualValuesOrder();
        Collections.sort(array, Collections.reverseOrder());
        return array;
    }

    /**
     * Verify if the prices have been sorted ascending
     */
    public void isPriceSortedAscending(){
        assertEquals(getListOfActualValuesOrder(), sortedAscending());
    }


    /**
     * Verify if the prices have been sorted descending
     */
    public void isPriceSortedDescending(){
        assertEquals(getListOfActualValuesOrder(), sortedDescending());
    }

    public TradingPage addToChart(){
        click(By.xpath(ADD_TO_CART_BUTTON_SELECTOR));

        return this;
    }

    public TradingPage clickOnTheCart(){
        click(By.xpath(CART_TOTAL_SELECTOR));

        return this;
    }

        public CheckoutPage checkout(){
        click(By.xpath(CHECKOUT_BUTTON_SELECTOR));
        isElementDisplayed(By.xpath(CHECKOUT_TITLE_SELECTOR));

        return new CheckoutPage(this.driver);
    }





}
