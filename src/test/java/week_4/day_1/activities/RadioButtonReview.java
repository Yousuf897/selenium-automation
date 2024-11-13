package week_4.day_1.activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RadioButtonReview {

    /*
    *
    * Navigate to "https://retail.tekschool-students.com/selenium/radio"
    * Locate and print the values of T-Shirt radio buttons
    * Store the text into a list of string
    * print each value into the console in a new line
    * Click on the "Large" radio button.
    *
    * */

    // "//div[@class='flex gap-3']/input[@type='radio']/following-sibling::label"
    // "//div[@class='flex gap-3']/input[@name='tshirt']/following-sibling::label"
    // "//input[@name='tshirt']/following-sibling::label"

    public static final String radioButtonUrl = "https://retail.tekschool-students.com/selenium/radio";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(radioButtonUrl);
        wait.until(ExpectedConditions.urlToBe(radioButtonUrl));

        List<WebElement> listOfRadioButtonLabels = driver.findElements(By.xpath("//input[@name='tshirt']/following-sibling::label"));

        for ( WebElement radioButton : listOfRadioButtonLabels ) {
            System.out.println( radioButton.getText());
        }

        WebElement largeRadioButton = driver.findElement(By.id("large"));

        Thread.sleep(3000);

        largeRadioButton.click();

        Thread.sleep(3000);


        driver.close();
        driver.quit();


    }

}
