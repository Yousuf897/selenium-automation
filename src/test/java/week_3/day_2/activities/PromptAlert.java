package week_3.day_2.activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptAlert {

    final static String baseUrl = "https://retail.tekschool-students.com/selenium/javascript-alerts";
    final static WebDriver driver = new ChromeDriver();
    final static String promptText = "TekSchool";

    public static void main(String[] args) throws InterruptedException {

        ConfirmationAlert.navigateTo(baseUrl);
        ConfirmationAlert.waitFor(2000);
        WebElement promptBtn = ConfirmationAlert.findElementByXpath("//button[@id='promptBtn']");
        promptBtn.click();
        ConfirmationAlert.waitFor(2000);

        Alert promptAlert = ConfirmationAlert.switchToAlert();

        promptAlert.sendKeys(promptText);

        ConfirmationAlert.waitFor(2000);

        promptAlert.accept();

        WebElement confirmationText = ConfirmationAlert.findElementByXpath("//div[@id='message']");
        String webText = confirmationText.getText();

        System.out.println(webText);

        ConfirmationAlert.waitFor(2000);

        if ( ("You wrote " + promptText).equals(webText) ) {
            System.out.println("Test is passed!");
        } else {
            System.out.println("Test is failed.");
        }

        driver.close();
        driver.quit();

    }

}
