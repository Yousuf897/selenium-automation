package week_4.day_1.topics.dynamicelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class WorkingWithDateInput {

    public static final String inputFieldsUrl = "https://retail.tekschool-students.com/selenium/inputs";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        driver.get(inputFieldsUrl);
        wait.until(ExpectedConditions.urlToBe(inputFieldsUrl));

        WebElement dateInput = driver.findElement(By.id("dateInput"));

        LocalDate today = LocalDate.now(); // 2024-11-12 --> 11/12/2024 MM-dd-yyyy
        String correctedDateFormat = today.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        Thread.sleep(2000);
//        dateInput.sendKeys(correctedDateFormat);
        action.click(dateInput).sendKeys(correctedDateFormat).perform();

        Thread.sleep(2000);


        String customDate = "10/15/1990";
        dateInput.clear();

        Thread.sleep(2000);
//        dateInput.sendKeys(customDate);
        action.click(dateInput).sendKeys(customDate).perform();

        Thread.sleep(5000);


        driver.close();
        driver.quit();


    }

}
