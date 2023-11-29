package SeleniumPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;

public class  Actionsclass{
   public static void main(String[]args) throws InterruptedException, IOException {
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
                Thread.sleep(3000);
       }

       Thread.sleep(5000);
       driver.navigate().to("https://practice.expandtesting.com/drag-and-drop");
       Thread.sleep(3000);
       WebElement source= driver.findElement(By.xpath("//div[@id='column-a']"));
       WebElement dest= driver.findElement(By.xpath("//div[@id='column-b']"));

       obj.dragAndDrop(source,dest).build().perform();
       Thread.sleep(5000);
       obj.dragAndDrop(dest,source).build().perform();
       Thread.sleep(5000);

       driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
       Thread.sleep(3000);

       obj.contextClick(driver.findElement(By.xpath("//span[starts-with(text(),'right')]"))).build().perform();
       Thread.sleep(3000);
       driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[7]")).click();
       driver.switchTo().alert().accept();
       Thread.sleep(3000);
       obj.doubleClick(driver.findElement(By.xpath("//button[starts-with(text(),'Double')]"))).build().perform();
       Thread.sleep(3000);
       driver.switchTo().alert().accept();
        driver.quit();
   }
}