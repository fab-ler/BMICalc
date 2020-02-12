import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NegativeValueInputTest {

    //weight in KG

    @Test
    public void calculateMinKg() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();

        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("10");
        browser.findElement(By.name("ht")).sendKeys("184");
        browser.findElement(By.name("cc")).click();
        Alert alert = browser.switchTo().alert();
        String minWeightAlert = alert.getText();
        assertEquals(minWeightAlert, "Weight should be greater than 10kgs", "error message");
        browser.quit();
    }
}
