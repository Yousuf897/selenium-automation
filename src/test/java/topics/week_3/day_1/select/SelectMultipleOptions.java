package topics.week_3.day_1.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utils.driver.ChromeDriverSetup;

import java.util.List;

public class SelectMultipleOptions extends ChromeDriverSetup {

    public static void main(String[] args) throws InterruptedException {

        CreateChromeDriver();
        navigateToUrl("http://127.0.0.1:5500/index.html");

        Thread.sleep(3000);

        WebElement countryDropDown = driver.findElement(By.name("country"));
        Select countrySelectDropDown = new Select(countryDropDown);

        countrySelectDropDown.selectByVisibleText("Spain");
        Thread.sleep(1000);

        countrySelectDropDown.selectByValue("Brazil");
        Thread.sleep(1000);

        countrySelectDropDown.selectByIndex(3);
        Thread.sleep(1000);

        List<WebElement> selectedOptions = countrySelectDropDown.getAllSelectedOptions();

        for ( WebElement selectedOption : selectedOptions ) {
            System.out.println(selectedOption.getText());
        }

        countrySelectDropDown.deselectAll();
        Thread.sleep(2000);


        closeTab();
        quitDriver();


    }

}
