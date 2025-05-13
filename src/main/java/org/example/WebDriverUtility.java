package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.example.PostPaidFlow.driver;

public class WebDriverUtility {
    private final WebDriver driver;

    // Constructor to initialize WebDriver
    public WebDriverUtility(WebDriver driver) {
        this.driver = driver;
    }

    // Scroll down by given pixel values (x for horizontal, y for vertical)
    public void scrollBy(int x, int y) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,500).perform();
    }
}