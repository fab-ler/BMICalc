import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OverweightCatTest {
    @Test
    public void culculateBMIOverweightCsm() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("61.91");
        browser.findElement(By.name("ht")).sendKeys("162");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Overweight", "Категория неверная");
        System.out.println(category);

        browser.quit();
    }
}
