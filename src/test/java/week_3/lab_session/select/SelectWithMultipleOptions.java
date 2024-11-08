package week_3.lab_session.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.spec.ECField;
import java.time.Duration;
import java.util.List;

public class SelectWithMultipleOptions {

    public static final String baseUrl = "";
    public static WebElement countryDropDown;

    /*
     * Navigate to "https://retail.tekschool-students.com/selenium/dropdown"
     * Select one of the dropdowns
     * Interact with one of these dropdowns
     * Select one of the available options
     * Print the selected option in console
     * */

    public static void main(String[] args) {

        try {

            // Chrome Driver
            WebDriver driver = new ChromeDriver();

            // waits
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to url
            driver.get(baseUrl);
            wait.until(ExpectedConditions.urlToBe(baseUrl));

            // Capture the programming dropdown
            countryDropDown = driver.findElement(By.name("country"));
            wait.until(ExpectedConditions.visibilityOf(countryDropDown));

            // Create an object of select
            Select select = new Select(countryDropDown);

            // Check if the select is multiple or not
            if ( select.isMultiple() ) {

                // Select one of the available options
                select.selectByVisibleText("United States");
                select.selectByIndex(1);
                select.selectByValue("Spain");

                // Print the selected option
                List<WebElement> options = select.getAllSelectedOptions();
                for (WebElement option : options) {
                    System.out.println("Selected option: " + option.getText());
                }

                // Deselect one of the selected options
                select.deselectByVisibleText("United States");
                select.deselectByIndex(1);
                select.deselectByValue("Spain");

                // Or we can deselect all the options at once
                select.deselectAll();

                // Check if the select is a type of multiple select
                System.out.println(select.isMultiple());

            } else {
                System.out.println("Select is not a type of multiple.");
            }

            // Close tab
            driver.close();

            // Quit the instance of chrome driver
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
