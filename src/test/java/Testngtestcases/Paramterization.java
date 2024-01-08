package Testngtestcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramterization {
    @Parameters({"state","city","pincode"})
    @Test
    public void parameterTest(String city, String state,Integer pincode) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        driver.findElement(By.xpath("//td[@class='mouseOut' and @width='77']/a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(String.valueOf(pincode));
        Thread.sleep(2000);
        driver.quit();

    }
}
