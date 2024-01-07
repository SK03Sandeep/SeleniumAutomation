package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Jsexecutor {

    public static void main(String[]args) throws InterruptedException {
        //handling permission pop ups
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");
        WebElement java_menu= driver.findElement(By.xpath("//div[@id='subtopnav']/a[6]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",java_menu);
        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0,1100)");
        WebElement t1=driver.findElement(By.xpath("//input[@name='ex1']"));
        WebElement t2=driver.findElement(By.xpath("//input[@name='ex2']"));
        WebElement t3=driver.findElement(By.xpath("//input[@name='ex3']"));
        js.executeScript("arguments[0].value='System'",t1);
        Thread.sleep(3000);
        js.executeScript("arguments[0].value='out'",t2);
        Thread.sleep(3000);
        js.executeScript("arguments[0].value='println'",t3);
        Thread.sleep(3000);
        js.executeScript("arguments[0].style.border='5px solid red'",t1);
        js.executeScript("arguments[0].style.border='5px solid red'",t2);
        js.executeScript("arguments[0].style.border='5px solid red'",t3);
        Thread.sleep(3000);





        driver.quit();
    }

}
