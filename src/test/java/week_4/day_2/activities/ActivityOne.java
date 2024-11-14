package week_4.day_2.activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class ActivityOne {

    public static WebDriver driver = new ChromeDriver();
    public static Random random = new Random();
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static Actions action = new Actions(driver);

    /* Global Variables */
    public static int randomNumber = 0;

    /* Url's */
    public static final String tekRetailMainUrl = "https://retail.tekschool-students.com/";
    public static final String tekRetailLoginUrl = "https://retail.tekschool-students.com/auth/login";
    public static final String tekRetailSignUpUrl = "https://retail.tekschool-students.com/auth/sign-up";
    public static final String tekRetailAccountUrl = "https://retail.tekschool-students.com/profile";

    public static final String signInButtonXpath = "//a[text()='Sign in']";
    public static final String createNewAccountXpath = "//a[text()='Create New Account']";

    /* SignIn page elements */
    public static final String signInEmailXpath = "//input[@id='email']";
    public static final String signInPasswordXpath = "//input[@id='password']";
    public static final String loginButtonXpath = "//button[text()='Login']";

    /* Signup page elements */
    public static final String nameInputXpath = "//input[@id='nameInput']";
    public static final String emailInputXpath = "//input[@id='emailInput']";
    public static final String passwordInputXpath = "//input[@id='passwordInput']";
    public static final String confirmPasswordInputXpath = "//input[@id='confirmPasswordInput']";
    public static final String singUpButtonXpath = "//button[text()='Sign Up']";

    /* Dashboard page elements */
    public static final String dashboardAccountButtonXpath = "//a[text()='Account']";
    public static final String updateButtonXpath = "//button[text()='Update']";
    public static final String personalPhoneNumberFieldXpath = "//input[@id='personalPhoneInput']";
    public static final String displayUsernameXpath = "//h1[@class='account__information-username']";

    /* Create account testing data */
    public static final String userName = "TrevorAa";
    public static final String emailAddress = "trevor.alexander@gmail.com";
    public static final String password = "jD/$3:4kl9D9";
    public static final String personalPhoneNumber = "1234567891";

    /* Settings */
    public static boolean alreadyHaveAccount = true;


    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // navigate to the main application
        driver.get(tekRetailMainUrl);
        wait.until(ExpectedConditions.urlToBe(tekRetailMainUrl));

        // Click on signIn button
        WebElement signInButton = driver.findElement(By.xpath(signInButtonXpath));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        action.click(signInButton).perform();

        // validate that the user is on signIn page
        wait.until(ExpectedConditions.urlToBe(tekRetailLoginUrl));


        if (alreadyHaveAccount) loginUserAndNavigateToProfilePage();
        else createAccountAndNavigateToProfile();

        changeUserNameAndEmailOnProfilePage();

        Thread.sleep(2000);

        driver.close();
        driver.quit();


    }

    private static void createAccountAndNavigateToProfile() throws InterruptedException{

        // Validate that the create new account button is clickable
        WebElement createNewAccountButton = driver.findElement(By.xpath(createNewAccountXpath));
        wait.until(ExpectedConditions.elementToBeClickable(createNewAccountButton));

        // Click On create new account button and navigate to signup page
        action.click(createNewAccountButton).perform();

        // validate that the user is on signup page
        wait.until(ExpectedConditions.urlToBe(tekRetailSignUpUrl));

        // Locate elements on signup page
        WebElement nameInputField = driver.findElement(By.xpath(nameInputXpath));
        WebElement emailInputField = driver.findElement(By.xpath(emailInputXpath));
        WebElement passwordInputField = driver.findElement(By.xpath(passwordInputXpath));
        WebElement confirmPasswordInputField = driver.findElement(By.xpath(confirmPasswordInputXpath));
        WebElement signUpButton = driver.findElement(By.xpath(singUpButtonXpath));

        // Validate that one of the elements on signup page is clickable
        wait.until(ExpectedConditions.elementToBeClickable(nameInputField));

        // Pass the testing data to signup page fields

        action.click(nameInputField).perform();
        for ( char character : userName.toCharArray() ) {
            action.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(100);
        }

        action.click(emailInputField).perform();
        for ( char character : emailAddress.toCharArray() ) {
            action.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(100);
        }

        action.click(passwordInputField).perform();
        for ( char character : password.toCharArray() ) {
            action.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(100);
        }

        action.click(confirmPasswordInputField).perform();
        for ( char character : password.toCharArray() ) {
            action.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(100);
        }

        // Validate that the signup button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));

        // Click on sign up button
        action.click(signUpButton).perform();

        // Validate that the user is on profile page
        wait.until(ExpectedConditions.urlToBe(tekRetailAccountUrl));
    }

    private static void loginUserAndNavigateToProfilePage() throws InterruptedException {
        /* Locate the login page elements */
        WebElement emailInputField = driver.findElement(By.xpath(signInEmailXpath));
        WebElement passwordInputField = driver.findElement(By.xpath(signInPasswordXpath));
        WebElement loginButton = driver.findElement(By.xpath(loginButtonXpath));

        // Validate that the email field is clickable
        wait.until(ExpectedConditions.elementToBeClickable(emailInputField));

        action.click(emailInputField).perform();
        for ( char character : emailAddress.toCharArray() ) {
            action.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(100);
        }

        action.click(passwordInputField).perform();
        for ( char character : password.toCharArray() ) {
            action.sendKeys(String.valueOf(character)).perform();
            Thread.sleep(100);
        }

        action.click(loginButton).perform();

        // Locate the account button element
        WebElement accountButton = driver.findElement(By.xpath(dashboardAccountButtonXpath));
        wait.until(ExpectedConditions.elementToBeClickable(accountButton));
        action.click(accountButton).perform();

        // Validate that we are on profile page
        wait.until(ExpectedConditions.urlToBe(tekRetailAccountUrl));

    }

    public static void changeUserNameAndEmailOnProfilePage() throws InterruptedException{

        // Validate that we are on profile page
        wait.until(ExpectedConditions.urlToBe(tekRetailAccountUrl));

        // Locate name and email input field on profile page
        WebElement nameInputField = driver.findElement(By.xpath(nameInputXpath));
        WebElement emailInputField = driver.findElement(By.xpath(emailInputXpath));
        WebElement personalPhoneNumberField = driver.findElement(By.xpath(personalPhoneNumberFieldXpath));
        WebElement updateButton = driver.findElement(By.xpath(updateButtonXpath));
        WebElement userNameHeading = driver.findElement(By.xpath(displayUsernameXpath));

        // Validate that the name input field is clickable
        wait.until(ExpectedConditions.elementToBeClickable(nameInputField));

        action.click(nameInputField).sendKeys(String.valueOf("Aa")).perform();
        // TODO: Generate random phone numbers (10 digits)
        action.click(personalPhoneNumberField).sendKeys(personalPhoneNumber).perform();
        action.click(updateButton).perform();

        // TODO: Update useName variable on the code right after we update the username.

        String newName = userNameHeading.getText();
       if ( newName.equals(userName) ) System.out.println("passed");
       else System.out.println("Not passed");

        // TODO: Generate random email addresses and the random number should be placed before @ sign.
//        action.click(emailInputField).sendKeys(String.valueOf(randomNumber)).perform();

        // indexOf() --> index of the last occurrence of character 'r'
        // right after r, replace random numbers and write @gmail.com
        // or you can create an email with X values, where x can be replaced with values
        // trevor.alexanderXXXX@gmail.com
        // replace() --> replace XXXX --> random numbers

        // TODO: Update the emailAddress variable value right after you change the actual email on your test

    }

}
