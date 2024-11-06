package week_3.day_2.review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SimpleTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/dropdown");

        driver.manage().window().maximize();


        WebElement languageDropDown = driver.findElement(By.xpath("//select[@name='language']"));

        Select languageSelect = new Select(languageDropDown);

        Thread.sleep(3000);

//        languageSelect.selectByVisibleText("Golang");
//
//        Thread.sleep(1000);
//
//        languageSelect.selectByValue("cPlusPlus");
//
//        Thread.sleep(1000);
//
//        languageSelect.selectByIndex(0);

        if ( languageSelect.isMultiple() ) {
            System.out.println("Yes, it is a type of multiple");
        } else {
            System.out.println("No, it's not. You can't select multiple values!");
        }


        Thread.sleep(3000);

        driver.close();
        driver.quit();


    }

}
