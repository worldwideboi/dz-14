package cc.robotdreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }

    @Test
    public void openWebsite() throws InterruptedException {
        driver.get("https://demoqa.com/elements");

        driver.findElement(By.xpath("//li[5]/span[text()='Buttons']")).click();
        driver.findElement(By.xpath("//div[3]/button[text()='Click Me']")).click();
        String expectedMessage = "You have done a dynamic click";
        String actualMessage = driver.findElement(By.xpath("//*[@id='dynamicClickMessage']")).getText();

        assert actualMessage.equals(expectedMessage) : "Сообщение соответствует ожидаемому: " + actualMessage;
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}

















