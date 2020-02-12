import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NegativeInvalidInput {
    // проверить оставления пустым поля вес

    @Test
    public void EmptyWeightInput() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("");
        browser.findElement(By.name("ht")).sendKeys("175");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String alertMessage = alert.getText();
        assertEquals(alertMessage, "Enter the value for weight", "error alert popup");
        browser.quit();
    }

    // проверить оставления пустым поля рост
    @Test
    public void EmptyHeightInput() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("100");
        browser.findElement(By.name("ht")).sendKeys("");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String alertMessage = alert.getText();
        assertEquals(alertMessage, "Height should be taller than 33cms", "error alert popup");
        browser.quit();
    }

    // заполнение поля рост бувенными символами (ввод невалидных симолов)
    @Test
    public void InvalidHeightInput() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("100");
        browser.findElement(By.name("ht")).sendKeys("qweqrqw");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String alertMessage = alert.getText();
        assertEquals(alertMessage, "Enter the value for weight", "error alert popup");
        browser.quit();
    }

    // заполнение поля вес бувенными символами (ввод невалидных симолов) 
    @Test
    public void InvalidWeightInput() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("qweqrqw");
        browser.findElement(By.name("ht")).sendKeys("190");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String alertMessage = alert.getText();
        assertEquals(alertMessage, "Enter the value for weight", "error alert popup");
        browser.quit();
    }
}
