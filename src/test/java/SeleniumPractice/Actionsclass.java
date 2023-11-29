package SeleniumPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class  Actionsclass{
   public static void main(String[]args) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.flipkart.com/");
       Thread.sleep(5000);
       Actions obj= new Actions(driver);
       if(driver.findElement(By.xpath("/html/body/div[3]/div/span")).isDisplayed())
           driver.findElement(By.xpath("/html/body/div[3]/div/span")).click();
       Thread.sleep(3000);
       List<WebElement> categoriesdropdown=driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div/div/div/span"));
       for (WebElement i:categoriesdropdown) {
            obj.moveToElement(i).build().perform();
                Thread.sleep(5000);
       }
       driver.quit();
   }
}