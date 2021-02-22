package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    /**
     * Wait till element is visible
     * @param selector element selector
     */
    public void waitVisibility(By selector){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    /**
     * Click on the element
     * @param selector element selector
     */
    public void click(By selector){
        waitVisibility(selector);
        driver.findElement(selector).click();
    }

    /**
     * Is element displayed
     * @param selector element selector
     */
    public void isElementDisplayed(By selector){
        waitVisibility(selector);
        assertTrue(driver.findElement(selector).isDisplayed());
    }

    /**
     * Add text to input element
     * @param selector element selector
     * @param value target text
     */
    public void addValue(By selector, String value){
        waitVisibility(selector);
        driver.findElement(selector).sendKeys(value);
    }

    /**
     * Get dropdown element
     * @param dropdownSelector selector of target dropdown menu
     * @return select element
     */
    public Select getDropdownSelect(By dropdownSelector){
        waitVisibility(dropdownSelector);
        Select targetDropdown = new Select(driver.findElement(dropdownSelector));

        return targetDropdown;
    }

    /**
     * Get list of web elements
     * @param selector selector of list web elements
     * @return list of web elements
     */
    public List<WebElement> getListOfWebElements(By selector){
        List<WebElement> elements = driver.findElements(selector);
        return elements;
    }

    public boolean isExists(By selector){
        if (driver.findElements(selector).size()!=0){
            return true;
        }
        return false;
    }
}
