package week_3.day_2.review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestSelectWithMultipleValues {

    public static void main(String[] args) throws InterruptedException {

        String baseUrl = "http://127.0.0.1:5500/index.html";
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        driver.manage().window().maximize();

        WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));

        Select countrySelect = new Select(countryDropDown);

        Thread.sleep(3000);

       countrySelect.selectByVisibleText("Brazil");

       Thread.sleep(1000);

       countrySelect.selectByIndex(3);
       
       List<WebElement> selectedOptions = countrySelect.getAllSelectedOptions();

       for ( WebElement option : selectedOptions ) {
           System.out.println( option.getText() );
       }

        System.out.println(" * * * * *  * * * * *  * * * * * ");

       for ( WebElement availableOption : countrySelect.getOptions() ) {
           System.out.println(availableOption.getText());
       }

       countrySelect.deselectByVisibleText("Brazil");

       Thread.sleep(1000);

       countrySelect.selectByVisibleText("Brazil");

       Thread.sleep(1000);

       countrySelect.selectByVisibleText("United States");

       countrySelect.deselectAll();

        Thread.sleep(3000);

        driver.close();
        driver.quit();


    }

}
