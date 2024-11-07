package week_3.day_3.topics.actions.mouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {


    public static void main(String[] args) throws InterruptedException {

        String dragAndDropUrl = "https://retail.tekschool-students.com/selenium/drag-drop";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(dragAndDropUrl);

        Thread.sleep(2000);

        WebElement source = driver.findElement(By.xpath("//div[text()='Payment should not accept invalid expiration date']"));
        WebElement target = driver.findElement(By.xpath("//div[@data-rbd-droppable-id='2']"));

        Actions action = new Actions(driver);

        action.clickAndHold(source).
                moveByOffset(0, 10).
                moveToElement(target).
                release().
                perform();

        Thread.sleep(2000);

        driver.close();
        driver.quit();


    }

}
