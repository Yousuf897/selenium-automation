package week_3.day_3.topics.actions.keyboard;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardSendKeysAction {

    public static void main(String[] args) throws InterruptedException {

        String dropDownUrl = "https://www.facebook.com";
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);

        driver.manage().window().maximize();
        driver.get(dropDownUrl);

        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));

        Thread.sleep(3000);

        // Click on username field
        action.click(usernameField).perform();

        for ( char character : "Hello Humans!".toCharArray() ) {
            action.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(100);
        }

        Thread.sleep(2000);

        action.click(passwordField).perform();

        for ( char character : "Welcome to Tekschool!".toCharArray() ) {
            action.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(100);
        }

        Thread.sleep(3000);


        driver.close();
        driver.quit();

    }

}
