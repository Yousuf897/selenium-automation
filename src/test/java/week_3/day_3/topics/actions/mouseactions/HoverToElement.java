package week_3.day_3.topics.actions.mouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverToElement {

    public static void main(String[] args) throws InterruptedException {

        String dropDownUrl = "https://www.amazon.com";
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(dropDownUrl);
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

        Thread.sleep(2000);

        WebElement medicalCareButton = driver.findElement(By.xpath("//span[text()='Medical Care']"));

        Actions action = new Actions(driver);

        action.moveToElement(medicalCareButton).perform();

        Thread.sleep(4000);

        driver.close();
        driver.quit();

    }

}
