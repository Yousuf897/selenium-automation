package week_3.day_3.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Review {



    public static void main(String[] args) throws InterruptedException {


       // Create object of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open browser
        driver.get("https://www.tekschool.us/");
        Thread.sleep(2000);

         //  Open three tabs and navigate to 3 different web pages.
        ( (JavascriptExecutor) driver ).executeScript("window.open('https://www.google.com','_blank')");
        Thread.sleep(2000);
        String googleTitle = driver.getTitle();

        ( (JavascriptExecutor) driver ).executeScript("window.open('https://www.facebook.com','_blank')");
        Thread.sleep(2000);


        ( (JavascriptExecutor) driver ).executeScript("window.open('https://www.monday.com','_blank')");
        Thread.sleep(2000);
        String mondayTitle = driver.getTitle();

        // capture all windows
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());


        Thread.sleep(2000);

         // get the title of each page. print them into console.
//        System.out.println(googleTitle);
//        System.out.println(facebookTitle);
//        System.out.println(mondayTitle);

        for ( String tab : tabs ) {
            driver.switchTo().window(tab);
            System.out.println( "Title: " + driver.getTitle());
        }

         // switch to the second tab
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);

          // close the second tab
        driver.close();

         // quit the driver
        driver.quit();



    }

}
