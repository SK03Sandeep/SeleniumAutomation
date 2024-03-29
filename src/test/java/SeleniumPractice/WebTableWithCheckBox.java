package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WebTableWithCheckBox {
    public static void main(String[]args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js= (JavascriptExecutor)driver;
        driver.get("https://seleniumpractise.blogspot.com/");
        Thread.sleep(5000);
        //List<WebElement> locations=driver.findElements(By.xpath("//div[@class='post-body entry-content']/table[@id='customers']/tbody/tr/td[4]"));
        //List<WebElement> checkboxes=driver.findElements(By.xpath("//div[@class='post-body entry-content']/table[@id='customers']/tbody/tr/td[1]/input"));

        //js.executeScript("arguments[0].click()",c);

        for(int i=2;i<=6;i++)
        {
            WebElement s= driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td[4]"));
            WebElement c=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td[1]/input"));

            System.out.println(s.getText());
            if(s.getText().equals("USA"))
            {
                js.executeScript("arguments[0].click()",c);
            }
        }
        TakesScreenshot screenshot= (TakesScreenshot)driver;
        File image=screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(image,new File("C:\\Users\\Dell\\Desktop\\Automation\\Screenshots.png"));
        driver.quit();

    }
}
