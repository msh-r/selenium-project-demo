package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue; // Make sure this is uncommented and imported

public class BasicTest {
    public static WebDriver driver;
    public String appUrl = "https://www.facebook.com";

    @BeforeTest
    public void setup() {
        // Open the browser and URL
        driver = new ChromeDriver();

        // Open the URL
        driver.get(appUrl);
    }

    @AfterTest
    public void teardown() {
        // Quit the browser instance
        driver.quit();
    }

    @Test
    public void urlValidation() {
        String expectedResult = "https://www.facebook.com/";
        String actualResult = driver.getCurrentUrl();

        Reporter.log("Expected Result = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);

        assertTrue(actualResult.equals(expectedResult), "Mismatch in the application URL");
    }

    @Test
    public void titleValidation() {
        String expectedResult = "Facebook - log in or sign up";
        String actualResult = driver.getTitle();

        Reporter.log("Expected Result = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);

        assertTrue(actualResult.equals(expectedResult), "Mismatch in the application title");
    }

    @Test
    public void welcomeMessageValidation() {
        WebElement welMsg = driver.findElement(By.xpath("//h2[@class='_8eso']"));

        String expectedResult = "Connect with friends and the world around you on Facebook.";
        String actualResult = welMsg.getText();

        Reporter.log("Expected Result = " + expectedResult);
        Reporter.log("Actual Result = " + actualResult);

        assertTrue(actualResult.equals(expectedResult), "Mismatch in the welcome message");
    }
}
