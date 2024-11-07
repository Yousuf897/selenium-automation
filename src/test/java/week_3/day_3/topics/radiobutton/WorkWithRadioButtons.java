package week_3.day_3.topics.radiobutton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WorkWithRadioButtons {

    public static void main(String[] args) throws InterruptedException {

        String baseUrl = "https://retail.tekschool-students.com/selenium/radio";
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(baseUrl);
        driver.manage().window().maximize();

        Thread.sleep(3000);

        WebElement htmlRadioButton = driver.findElement(By.id("html"));

//        htmlRadioButton.click();

        if ( htmlRadioButton.isSelected() ) System.out.println("yes, it's selected.");
        else System.out.println("No, it's not selected.");

        if ( htmlRadioButton.isEnabled() ) System.out.println("Yes, I can use this radioButton.");
        else System.out.println("No, I cannot use this radio button.");

       List<WebElement> radioButtons =  driver.findElements(By.name("fav_language"));

       for ( WebElement radioButton : radioButtons ) {
           System.out.println( radioButton.getAttribute("value") );
       }

        Thread.sleep(3000);


        driver.close();
        driver.quit();



    }

}
