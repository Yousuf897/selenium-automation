package week_3.lab_session.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class KeyboardActions {

    // Variables
    public static final String mondayUrl = "https://monday.com/";
    public static final String mondayLoginPageUrl = "https://auth.monday.com/auth/login_monday/";

    public static void main(String[] args) throws InterruptedException {

        // Instance of Chrome browser
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Maximize the tab
        driver.manage().window().maximize();

        // Navigate to amazon.com
        driver.get(mondayUrl);
        wait.until(ExpectedConditions.urlToBe(mondayUrl));

        // Locate the login button
        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Log in' and @role='link']"));

        // Perform a left click on login button
        action.click(loginButton).perform();

        wait.until(ExpectedConditions.urlToBe(mondayLoginPageUrl));

        // Locate the input field
        WebElement emailAddressInput = driver.findElement(By.id("user_email"));

        action.click(emailAddressInput).perform();

        for ( char character : "john_doe@gmail.com".toCharArray() ) {
            action.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(100);
        }

        driver.close();

        driver.quit();

    }

}
