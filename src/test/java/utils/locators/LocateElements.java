package utils.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocateElements {

    public  WebDriver driver;

    public WebElement locateElementByName(String name) {
        return driver.findElement(By.name(name));
    }

}
