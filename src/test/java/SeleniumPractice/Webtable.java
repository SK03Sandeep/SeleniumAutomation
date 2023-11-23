package SeleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

class Webt{
    public void displayallRows(List<WebElement> rows)
    {
        for (WebElement i:rows) {
            System.out.println(i.getText());
            System.out.println("------------------------------------");
        }
    }

    public void displayCompanynames(List<WebElement> comp)  // to display all company names in a table column
    {
        for (WebElement i:comp) {
            System.out.println(i.getText());
        }
    }
}

public class Webtable {

    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //System.out.println("------------->"+driver.getTitle());
        List<WebElement> tablerow= driver.findElements(By.xpath("//table[@id='customers']//tr"));
        List<WebElement> comp= driver.findElements(By.xpath("//table[@id='customers']//tr//td[1]"));

        Webt obj = new Webt();
        //obj.displayallRows(tablerow);
        obj.displayCompanynames(comp);
        Thread.sleep(5000);
        driver.quit();
    }
}
