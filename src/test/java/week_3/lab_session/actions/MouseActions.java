package week_3.lab_session.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class MouseActions {

    public static final String amazonUrl = "https://www.amazon.com/";

    public static void main(String[] args) throws InterruptedException {

        // Instance of Chrome browser
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Maximize the tab
        driver.manage().window().maximize();

        // Navigate to amazon.com
        driver.get(amazonUrl);
        wait.until(ExpectedConditions.urlToBe(amazonUrl));

        WebElement amazonLogo = driver.findElement(By.xpath("//*[@id=\"nav-bb-logo\"]"));action.click(amazonLogo).perform();

        // Locate the Prime button
        WebElement primeButton = driver.findElement(By.id("nav-link-amazonprime"));

        // Move the mouse in the middle of (Hover) the "Prime" button.
        action.moveToElement(primeButton).perform();

        // Perform a left click on any of the buttons.
        action.click(primeButton).perform();


        // ALT + LEFT ARROW || COMMAND + LEFT ARROW
//        action.keyDown(Keys.ALT).sendKeys(Keys.ARROW_LEFT).perform();

        // Or
        driver.navigate().back();


        // Perform right click on prim button
        action.contextClick(primeButton).perform();



        driver.close();
        driver.quit();

    }

}
