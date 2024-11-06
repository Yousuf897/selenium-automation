package utils.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElements {

    public WebDriver driver;

    public LocateElements() {
        this.driver = new ChromeDriver();
    }

    public WebElement locateElementByName(String name) {
        return driver.findElement(By.name(name));
    }

}
