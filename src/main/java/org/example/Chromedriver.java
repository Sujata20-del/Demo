package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Chromedriver {


    public static void main(String[] args) throws InterruptedException {
        // Set up the ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Open a webpage
        driver.get("https://testvil1.myvi.in/new-connection/buy-postpaid-sim-connection-online");



       // Test
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/new-connection/buy-postpaid-sim-connection-online']")).isDisplayed();
        driver.findElement(By.xpath("//a[text()='family plans']")).click();
        Thread.sleep(1000);

        WebElement proceedButton = driver.findElement(By.xpath("//button[@data-price='701' and @data-soccid='26052935']"));
        proceedButton.click();

        //Viewdetails click
        //driver.findElement(By.xpath("//a[@data-toggle='modal']\n")).click();
       // driver.findElement(By.xpath("//label[@for='radio-12']")).click();

        driver.findElement(By.xpath("//div[@class='familymember-header active-mode position-relative']//p[@class='member-number'][normalize-space()='member 1']")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='familymember-header active-mode position-relative']//div[@class='member-desc'][normalize-space()='primary member']")).isDisplayed();
        driver.findElement(By.xpath("//h5[text()='1. contact details']\n")).isDisplayed();
        String pincode = "302001";
        driver.findElement(By.id("enterpin")).sendKeys(pincode);

        if (isPincodeValid(pincode)) {
            System.out.println("Great! We deliver at your doorstep.");
        } else {
            System.out.println("Sorry, this pin code is not serviceable for new SIM delivery. You may still proceed to add all Vi postpaid numbers.");
        }

        String  Mobnumber= "9123373231";
        driver.findElement(By.id("neoPhoneNumber")).sendKeys("9_123_373_231");
        Thread.sleep(3000);

        //Scroll little down
        Actions actions =new Actions(driver);
        actions.scrollByAmount(0,500).perform();

        // Select a Number
        driver.findElement(By.xpath("//h5[normalize-space()='2. select a number']")).isDisplayed();
        WebElement radioButton1 = driver.findElement(By.xpath("//label[@for='radio-11']"));
        radioButton1.click();
        System.out.println("Radio First button is selected");
        Thread.sleep(2000);
        WebElement radioButton2 = driver.findElement(By.xpath("//label[@for='radio-12']"));
        radioButton2.click();
        System.out.println("Radio Second button is selected");

        //Delivery Address

        driver.findElement(By.xpath("//span[@class='spanHead forDesktop']//h5[@class='mb-0'][normalize-space()='3. delivery address']")).isDisplayed();
        driver.findElement(By.xpath("//p[@class='ddetails lastddetails']")).isDisplayed();

        driver.findElement(By.xpath("//input[@id='enterFullname']")).sendKeys("Sujata Adhikari");
        driver.findElement(By.xpath("//input[@id='gmapAddressField']")).sendKeys("Test1");
        driver.findElement(By.xpath("//input[@id='enterFlatNumber']")).sendKeys("34");





    }
    static boolean isPincodeValid(String pincode) {
        return pincode.matches("^(34|35|36)\\d{4}$");
    }










}

