package seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class First {
    public static void main(String[]args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/basic-controls.html");
        Thread.sleep(3000);
        System.out.println("Page title--> "+driver.getTitle());
        Thread.sleep(10000);

        WebElement title= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        if (title.isDisplayed())
        {
            System.out.println("page is loaded");

        }
        else
            System.out.println("page is not loaded");

        WebElement fname= driver.findElement(By.id("firstName"));
        WebElement lname= driver.findElement(By.id("lastName"));
        WebElement checkboxenglish= driver.findElement(By.id("englishchbx"));
        WebElement checkboxhindi = driver.findElement(By.id("hindichbx"));
        WebElement registerbtn = driver.findElement(By.id("registerbtn"));

        fname.sendKeys("sandeep");
        System.out.println("First name-->"+fname.getAttribute("value"));
        lname.sendKeys("konka");
        System.out.println("Last name-->"+lname.getAttribute("value"));

        checkboxenglish.click();
        checkboxhindi.click();

        if(checkboxenglish.isSelected() && checkboxhindi.isSelected())
            System.out.println("Both the checkboxes are checked");
        else
            System.out.println("Both the checkboxes are not checked");

        Thread.sleep(3000);
        registerbtn.click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("msg"))));

        System.out.println("Registration done message-->"+driver.findElement(By.xpath("//label[@id='msg']")).getText());

        driver.quit();

    }
}
