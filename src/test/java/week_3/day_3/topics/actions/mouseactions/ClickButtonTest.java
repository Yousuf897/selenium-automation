package week_3.day_3.topics.actions.mouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickButtonTest {

    public static void main(String[] args) throws InterruptedException {

        String amazonUrl = "https://www.amazon.com/";
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(amazonUrl);

        Thread.sleep(2000);

        WebElement medicalCare = driver.findElement(By.xpath("//span[text()='Medical Care']"));

        Actions action = new Actions(driver);

//        action.click(medicalCare).perform();
        action.contextClick(medicalCare).perform();

        Thread.sleep(5000);

        driver.close();
        driver.quit();


    }

}
