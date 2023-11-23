package SeleniumPractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class Alerts {
    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        Thread.sleep(3000);
        System.out.println("Page title--> " + driver.getTitle());
        Thread.sleep(10000);
        WebElement title= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        if (title.isDisplayed())
        {
            System.out.println("page is loaded-->"+driver.findElement(By.xpath("//h1[@class='post-title entry-title']")).getText());

        }
        else
            System.out.println("page is not loaded");


        WebElement alertbtn= driver.findElement(By.id("alertBox"));
        WebElement confirmbtn= driver.findElement(By.id("confirmBox"));
        WebElement promptbtn= driver.findElement(By.id("promptBox"));

        alertbtn.click();
        Thread.sleep(3000);

        Alert a1=driver.switchTo().alert();
        a1.accept();

        WebElement output= driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println("Output--->"+output.getText());
        Assert.assertEquals("You selected alert popup",output.getText());
        confirmbtn.click();
        Thread.sleep(2000);

        Alert a2=driver.switchTo().alert();
        System.out.println("Alert name-->"+a2.getText());
        a2.dismiss();
        WebElement output2= driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println("Output--->"+output2.getText());
        Thread.sleep(5000);

        promptbtn.click();
        Alert a3=driver.switchTo().alert();
        a3.sendKeys("My name is k sandeep, automation engineer in oracle");
        Thread.sleep(3000);
        a3.accept();
        System.out.println("Output--->"+driver.findElement(By.xpath("//div[@id='output']")).getText());
        driver.close();
    }
}
