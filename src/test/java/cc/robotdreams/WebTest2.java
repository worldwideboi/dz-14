package cc.robotdreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class WebTest2
{
    WebDriver driver;
    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }
    @Test
    public void openWebsite() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");

        driver.findElement(By.xpath("//div/button[@id='addNewRecordButton']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Карл");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Маркс");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("carl@gmail.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("21");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("2500");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("QA");
        driver.findElement(By.xpath("//div/button[@id='submit']")).click();
        WebElement elementToCheck = driver.findElement(By.xpath(
                "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]"));

        if (!elementToCheck.getText().isEmpty()) {
        } else {
            throw new RuntimeException ("Элемент пустой");
        }
        driver.findElement(By.xpath("//div[@class='action-buttons']/span[@title='Edit']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Михаил");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Достоевский");
        driver.findElement(By.xpath("//div/button[@id='submit']")).click();
    }

   @AfterTest
   public void teardown() {
       driver.quit();
   }
}
