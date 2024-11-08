package topics.week_3.day_1.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.driver.ChromeDriverSetup;
import utils.locators.LocateElements;
import utils.url.BaseUrl;

public class ActivityOne extends ChromeDriverSetup {

    public static void main(String[] args) throws InterruptedException {

        var locators = new LocateElements();

        CreateChromeDriver();
        navigateToUrl(BaseUrl.dropDownPage);

        WebElement languageDropDown = locators.locateElementByName("language");
        Select lanaguageSelect = new Select(languageDropDown);

        lanaguageSelect.selectByVisibleText("Java");

        Thread.sleep(4000);

        closeTab();
        quitDriver();

    }

}
