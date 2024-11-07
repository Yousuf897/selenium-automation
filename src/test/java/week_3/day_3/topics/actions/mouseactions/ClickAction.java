package week_3.day_3.topics.actions.mouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ClickAction {

    public static void main(String[] args) throws InterruptedException {

        String dropDownUrl = "https://retail.tekschool-students.com/selenium/dropdown";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(dropDownUrl);

        Thread.sleep(2000);

        WebElement dropDownButton = driver.findElement(By.xpath("//select[@id='programmingLanguageSelect']"));

        Actions action = new Actions(driver);

        action.click(dropDownButton).perform();

        Thread.sleep(2000);

        driver.close();
        driver.quit();

    }

}
