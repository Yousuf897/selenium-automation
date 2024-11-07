package week_3.day_3.activity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReviewTwo {

    public static void main(String[] args) throws InterruptedException {

        List<String> titles = new ArrayList<>();
        Map<String, String> webTitles = new HashMap<>();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // Open browser
        driver.get("https://www.tekschool.us/");
        Thread.sleep(2000);
        titles.add(driver.getTitle());

        //  Open three tabs and navigate to 3 different web pages.
        ( (JavascriptExecutor) driver ).executeScript("window.open('https://www.google.com','_blank')");
        Thread.sleep(2000);

        ( (JavascriptExecutor) driver ).executeScript("window.open('https://www.facebook.com','_blank')");
        Thread.sleep(2000);


        ( (JavascriptExecutor) driver ).executeScript("window.open('https://www.monday.com','_blank')");
        Thread.sleep(2000);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        for ( String tab : tabs ) {
            driver.switchTo().window(tab);
            titles.add(driver.getTitle());
            Thread.sleep(2000);
        }

        Thread.sleep(2000);

        System.out.println("Titles" + titles);

//        titles.forEach((title) -> System.out.println(title));

        for ( String title : titles ) {
            System.out.println( title );
        }

        // close the second tab
        driver.close();

        // quit the driver
        driver.quit();

    }

}
