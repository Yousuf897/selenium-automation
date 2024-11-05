package select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WorkingWithSelectElement {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://retail.tekschool-students.com/selenium/dropdown";

        Thread.sleep(3000);


        driver.get(baseUrl);

        WebElement countryDropDown = driver.findElement(By.id("countrySelect"));

        Select countrySelectDropDown = new Select(countryDropDown);

        Thread.sleep(1000);

        countrySelectDropDown.selectByVisibleText("United States");

        Thread.sleep(1000);

        countrySelectDropDown.selectByValue("Cuba");

        List<WebElement> options = countrySelectDropDown.getOptions();

        for ( WebElement option : options  ) {
            System.out.println( option.getText() );
        }

        countrySelectDropDown.selectByIndex(4);

//        countryDropDown.click();

        Thread.sleep(3000);

        driver.close(); // close the tab
        driver.quit(); // quit the object of chromeDriver

    }

}
