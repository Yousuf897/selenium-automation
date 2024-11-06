package week_3.day_2.activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationAlert {

    final static String baseUrl = "https://retail.tekschool-students.com/selenium/javascript-alerts";
    final static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {

        navigateTo(baseUrl);
        maximizeWindow();

        waitFor(2000);

        WebElement confirmAlertButton = findElementByXpath("//button[text()='Confirm']");

        clickOnButton(confirmAlertButton);

        Alert confirmAlert = switchToAlert();

        waitFor(2000);

        confirmAlert.dismiss();

        waitFor(2000);

        driver.close();
        driver.quit();

    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void waitFor(int seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }

    // Method which returns WebElement, accepts String of xpath.
    // take the xpath and will return WebElement
    public static WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static void clickOnButton(WebElement element) {
        element.click();
    }

    public static Alert switchToAlert() {
        return driver.switchTo().alert();
    }

}
