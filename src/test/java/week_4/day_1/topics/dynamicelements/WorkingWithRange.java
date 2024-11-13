package week_4.day_1.topics.dynamicelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WorkingWithRange {

    public static final String inputFieldsUrl = "https://retail.tekschool-students.com/selenium/inputs";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        driver.get(inputFieldsUrl);
        wait.until(ExpectedConditions.urlToBe(inputFieldsUrl));

        WebElement rangePicker = driver.findElement(By.id("rangeInput"));

        int rangeValue = 25;
        JavascriptExecutor jsExecutor = ( JavascriptExecutor ) driver;

        Thread.sleep(2000);

//        jsExecutor.executeScript("arguments[0].value='" + rangeValue +"';", rangePicker );

        for ( int i = 0; i <= 25; i++ ) {
            jsExecutor.executeScript("arguments[0].value='" + i +"';", rangePicker );
            Thread.sleep(100);
        }


        Thread.sleep(5000);


        driver.close();
        driver.quit();


    }

}
