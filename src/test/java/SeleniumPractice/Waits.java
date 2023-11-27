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
        driver.navigate().to("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        Thread.sleep(2000);
        System.out.println("Page title--> " + driver.getTitle());
        Thread.sleep(3000);
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(15));

        WebElement btnchangetxt= driver.findElement(By.xpath("//button[@id='populate-text']"));
        WebElement newtext= driver.findElement(By.xpath("//h2[@class='target-text']")); // after clicking on " btnchangetxt" it will take 10 secs to change the text in this locator.
        WebElement btnDisplay= driver.findElement(By.xpath("//button[@id='display-other-button']"));
        WebElement hiddenbtn= driver.findElement(By.xpath("//button[@id='hidden']"));  // after clicking on " btndisplay" it will take 10 secs to display a new button in this locator.

        btnchangetxt.click();
        wait2.until(ExpectedConditions.textToBePresentInElement(newtext,"Selenium Webdriver"));
        System.out.println("new text 'Selenium Webdriver'found after 10 secs");
        Thread.sleep(3000);
        btnDisplay.click();
        wait2.until(ExpectedConditions.visibilityOf(hiddenbtn));
        System.out.println("new button 'Enabled' found after 10 secs");
        driver.quit();
    }
}
