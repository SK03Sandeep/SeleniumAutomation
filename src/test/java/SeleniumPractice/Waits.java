package SeleniumPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Waits {
    public static  void  main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/waits-demo.html");
        Thread.sleep(3000);
        System.out.println("Page title--> " + driver.getTitle());
        Thread.sleep(10000);

        WebElement btn1= driver.findElement(By.id("btn1"));
        WebElement btn2= driver.findElement(By.id("btn2"));

        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(8));
        btn1.click();

       // wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("txt1"))));
        WebElement tbox1= driver.findElement(By.id("txt1"));
        tbox1.sendKeys("sandeep");
        Assert.assertTrue(tbox1.isDisplayed());

        driver.quit();
    }
}
