import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BMICalculatorTest {

   @Test
    public void categoryTestNormal () {
       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
       WebDriver browser = new ChromeDriver();
       browser.get("https://healthunify.com/bmicalculator/");
       browser.findElement(By.name("wg")).sendKeys("82");
       browser.findElement(By.name("ht")).sendKeys("185");
       browser.findElement(By.name("cc")).click();
       String caterory = browser.findElement(By.name("desc")).getAttribute("value");
       assertEquals(caterory, "Your category is Normal", "Категория верная");
       browser.quit();
    }

    @Test
    public void categoryTestObese () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("185");
        browser.findElement(By.name("ht")).sendKeys("100");
        browser.findElement(By.name("cc")).click();
        String caterory = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(caterory, "Your category is Obese", "Категория верная");
        browser.quit();
    }

    @Test
    public void categoryTestStarvation () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("30");
        browser.findElement(By.name("ht")).sendKeys("150");
        browser.findElement(By.name("cc")).click();
        String caterory = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(caterory, "Your category is Starvation", "Категория верная");
        browser.quit();
    }
}
