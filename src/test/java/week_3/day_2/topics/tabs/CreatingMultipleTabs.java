package week_3.day_2.topics.tabs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class CreatingMultipleTabs {

    final static String tekSchoolUrl = "https://tekschool.us/";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(tekSchoolUrl);
        driver.manage().window().maximize();

        Thread.sleep(3000);

        (( JavascriptExecutor ) driver).executeScript("window.open('https://www.google.com/', '_blank')");

        Thread.sleep(3000);

        (( JavascriptExecutor ) driver).executeScript("window.open('https://monday.com/', '_blank')");

        Thread.sleep(3000);

        // TekSchool --> 0
        // Google --> 1
        // Monday --> 2
         List<String> tabs = new ArrayList<>(driver.getWindowHandles());

         driver.switchTo().window(tabs.get(1));

         Thread.sleep(3000);

         driver.switchTo().window(tabs.get(0));

         Thread.sleep(3000);

        driver.switchTo().window(tabs.get(2));

        Thread.sleep(3000);

        for ( String tab : tabs ) {
            driver.switchTo().window(tab);
            driver.close();
        }

        driver.quit();
    }

}
