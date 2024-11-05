package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSetup {

    public static WebDriver driver;

    public static void CreateChromeDriver() {
        driver = new ChromeDriver();
    }

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static void closeTab() {
        driver.close();
    }



}
