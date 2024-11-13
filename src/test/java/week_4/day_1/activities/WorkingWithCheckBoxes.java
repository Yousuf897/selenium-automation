package week_4.day_1.activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class WorkingWithCheckBoxes {

    public static final String checkBoxesUrl = "https://retail.tekschool-students.com/selenium/checkbox";


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        driver.get(checkBoxesUrl);
        wait.until(ExpectedConditions.urlToBe(checkBoxesUrl));

        WebElement javaCheckBox = driver.findElement(By.id("javaInput"));

        Thread.sleep(1000);

        action.click(javaCheckBox).perform();

        Thread.sleep(3000);


        driver.close();
        driver.quit();


    }

}
