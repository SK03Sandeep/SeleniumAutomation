package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
public class Cookies {
    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Set<Cookie> setcookie= new HashSet<Cookie>();
        driver.get("https://www.flipkart.com/");
        Thread.sleep(3000);
        setcookie=driver.manage().getCookies();

        for (Cookie var: setcookie) {
            System.out.println(var);
            System.out.println("----------------------------------------------------------");
        }

        Cookie obj= new Cookie("Sandeep's functionasl cookies","san#F1111111$dsa");

        driver.manage().addCookie(obj);
        setcookie=driver.manage().getCookies();

        for (Cookie var: setcookie) {
            System.out.println(var);
            System.out.println("----------------------------------------------------------");
        }

        driver.manage().deleteAllCookies();
        setcookie=driver.manage().getCookies();
        System.out.println(setcookie);

        driver.quit();
    }
}
