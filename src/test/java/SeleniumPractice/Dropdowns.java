package SeleniumPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Dropdowns {
    public static  void  main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        Thread.sleep(3000);
        System.out.println("Page title--> " + driver.getTitle());
        Thread.sleep(10000);
        WebElement Singledropdown = driver.findElement(By.id("course"));
        Select obj= new Select(Singledropdown);

        obj.selectByIndex(2);
        Thread.sleep(2000);
        obj.selectByValue("python");
        Thread.sleep(2000);
        obj.selectByVisibleText("Javascript");
        System.out.println(obj.getFirstSelectedOption().getText());

        Assert.assertEquals("Javascript",obj.getFirstSelectedOption().getText());

        WebElement multidropdown = driver.findElement(By.xpath("//select[@id='ide']"));
        Select multi= new Select(multidropdown);
        multi.selectByVisibleText("NetBeans");
        Thread.sleep(2000);
        multi.selectByIndex(1);
        List<WebElement> multid= multi.getAllSelectedOptions();
        for(WebElement i:multid)
        {
            System.out.println(i.getText());
        }

        driver.quit();
    }
}