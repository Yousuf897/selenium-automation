package week_3.lab_session.links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InteractWithLink {

    /*
    *
    * Navigate to "https://retail.tekschool-students.com/selenium/links"
    *
    * Capture the locator for the first link
    * Try to click
    *
    * Capture the locator for the second link
    * Try to click
    *
    * Capture the locator for the third link
    * Try to click
    *
    * NOTE: for each one of them, try to create a method. call your methods within the main method to execute.
    *
    * Capture all the available links
    * Print their text and the links side by side
    *
    * Expected output:
    *
    * TEXT --> www.TEXT.com
    *
    * */

    public static final String baseUrl = "https://retail.tekschool-students.com/selenium/links";
    public static final String googleUrl = "https://www.google.com/";
    public static WebElement sameTabLink;
    public static WebElement newTabWithHtml;

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        // Waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to URL
        driver.get(baseUrl);
        wait.until(ExpectedConditions.urlToBe(baseUrl));

        // Locate the first link
        locateClickAndVerifyTheFirstLink(driver, action, wait);

        // Locate the second link
        locateClickAndVerifyTheSecondLink(driver, action, wait);

        // Locate the third link
        locateClickAndVerifyTheThirdLink(driver, action, wait);

        // Capture all links with a tag
       List<WebElement> links =  driver.findElements(By.xpath("//div[@class='px-4 flex flex-col gap-4']/a"));

       // print the text and the value of the href
       for ( WebElement link : links )
           System.out.println( link.getText() + " --> " + link.getAttribute("href") );

        // Close tab
        driver.close();

        // Quit the instance of chrome driver
        driver.quit();

    }

    public static void locateClickAndVerifyTheFirstLink(WebDriver driver, Actions action, WebDriverWait wait) {
        sameTabLink = findElementByXpath(driver, "//a[text()='same tab']");
        action.click(sameTabLink).perform();
        waitForUrlToBe(wait, googleUrl);
    }

    public static void locateClickAndVerifyTheSecondLink(WebDriver driver, Actions action, WebDriverWait wait) {
        newTabWithHtml = findElementByXpath(driver, "//a[text()='new tab with html']");
        action.click(newTabWithHtml).perform();
        waitForUrlToBe(wait, googleUrl);
    }

    public static void locateClickAndVerifyTheThirdLink(WebDriver driver, Actions action, WebDriverWait wait) {
        newTabWithHtml = findElementByXpath(driver, "//a[text()='new window with js']");
        action.click(newTabWithHtml).perform();
//        waitForUrlToBe(wait, googleUrl);
    }

    public static WebElement findElementByXpath(WebDriver driver, String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

//     wait.until(ExpectedConditions.urlToBe("https://www.google.com/"));
    public static void waitForUrlToBe(WebDriverWait wait, String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }


}
