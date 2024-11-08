package week_3.lab_session.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UsingSelectElement {

    public static final String baseUrl = "https://retail.tekschool-students.com/selenium/dropdown";
    public static WebElement programmingDropDown;

    /*
    * Navigate to "https://retail.tekschool-students.com/selenium/dropdown"
    * Select one of the dropdowns
    * Interact with one of these dropdowns
    * Select one of the available options
    * Print the selected option in console
    * */

    public static void main(String[] args) throws InterruptedException {

        // Chrome Driver
        WebDriver driver = new ChromeDriver();

        // waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to url
        driver.get(baseUrl);
        wait.until(ExpectedConditions.urlToBe(baseUrl));

        // Capture the programming dropdown
        programmingDropDown = driver.findElement(By.name("language"));
        wait.until(ExpectedConditions.visibilityOf(programmingDropDown));

        // Create an object of select
        Select select = new Select(programmingDropDown);

        // Select one of the available options
        select.selectByVisibleText("Java");
        select.selectByIndex(1);
        select.selectByValue("python");

        // Print the selected option
        List<WebElement> options = select.getAllSelectedOptions();
        for ( WebElement option : options ) {
            System.out.println("Selected option: " + option.getText());
        }

        // Deselect one of the selected options
//        select.deselectByVisibleText("Python");
//        select.deselectByIndex(0);
//        select.deselectByValue("Java");
//        select.deselectAll();

        // Check if the select is a type of multiple select
        System.out.println( select.isMultiple() );

        // Close tab
        driver.close();

        // Quit the instance of chrome driver
        driver.quit();

    }

}
