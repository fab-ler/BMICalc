import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MinMaxValuesTest {

    // проверить ввод минимального веса в кг (

    @Test
    public void MinWeightBoundaryCheck() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("10");
        browser.findElement(By.name("ht")).sendKeys("175");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String minWeightAlert = alert.getText();
        assertEquals(minWeightAlert, "Weight should be greater than 10kgs", "error alert popup");
        browser.quit();
    }

    // проверить ввод предположительно максимального веса в кг
    @Test
    public void MaxWeightBoundaryCheck() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("1000");
        browser.findElement(By.name("ht")).sendKeys("175");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String maxWeightAlert = alert.getText();
        assertEquals(maxWeightAlert, "Weight should be less than 100kgs", "error alert popup");
        browser.quit();
    }

    // проверка на ноль (параметр рост в см)
    @Test
    public void MinHeightBoundaryCheck() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("100");
        browser.findElement(By.name("ht")).sendKeys("0");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String minHeightAlert = alert.getText();
        assertEquals(minHeightAlert, "Height should be taller than 33cms", "error alert popup");
        browser.quit();
    }

    // проверить ввод предположительно максимального значения роста в см
    @Test
    public void MaxHeightBoundaryCheck() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name(("wg"))).sendKeys("50");
        browser.findElement(By.name("ht")).sendKeys("1000");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String maxHeightAlert = alert.getText();
        assertEquals(maxHeightAlert, "Height should be less than 230cms", "error alert popup");
        browser.quit();
    }
}
