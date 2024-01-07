package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Windowhandles {

public static void main(String[]args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
    Thread.sleep(10000);
    System.out.println(driver.getTitle());
    String parentwindow= driver.getWindowHandle();

    WebElement newwindowbutton= driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
    WebElement newtabbutton= driver.findElement(By.xpath("//button[@id='newTabBtn']"));
    newwindowbutton.click();
    Thread.sleep(3000);
    Set<String> allhandles= driver.getWindowHandles();
    for (String i:allhandles) {
        if (i.equals(parentwindow))
            System.out.println("control is on parent window");
        else {
            driver.switchTo().window(i);

            Thread.sleep(3000);
            System.out.println("Control is over newly opened window-->  TITLE IS-"+driver.getTitle());
            driver.close();
            driver.switchTo().window(parentwindow);
        }
    }
    newtabbutton.click();
    Thread.sleep(3000);
        Set<String> newhandles= driver.getWindowHandles();
    System.out.println(newhandles.size());
    for (String i:newhandles) {
        if (i.equals(parentwindow))
            System.out.println("control is on parent window");
        else {
            driver.switchTo().window(i);

            Thread.sleep(3000);
            System.out.println("Control is over newly opened tab-->TITLE IS-->"+driver.getTitle());
            driver.close();
            driver.switchTo().window(parentwindow);
        }
    }

        driver.quit();
}

}
