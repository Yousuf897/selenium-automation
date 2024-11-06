package week_3.day_2.activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleAlert {

    public static void main(String[] args) throws InterruptedException {

        String baseUrl = "https://retail.tekschool-students.com/selenium/javascript-alerts";
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

         WebElement simpleAlertButton = driver.findElement(By.id("alertBtn"));

         Thread.sleep(2000);

        simpleAlertButton.click();

        Thread.sleep(2000);

         Alert simpleAlert = driver.switchTo().alert();

        System.out.println("Text of the alert: " + simpleAlert.getText() );

        Thread.sleep(2000);

        simpleAlert.accept();

        Thread.sleep(2000);

        driver.close();
        driver.quit();

    }

}
