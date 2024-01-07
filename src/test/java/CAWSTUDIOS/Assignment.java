package CAWSTUDIOS;

import com.google.gson.JsonArray;
import java.util.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.FileReader;

class  Readandpopulatedata
{
        WebDriver driver;
        public Readandpopulatedata(WebDriver d)
        {
                this.driver=d;
        }

        //POPULATEDATA METHOD IS USED TO ENTER DATA INTO WEBTABLE.
        public void populatedata() throws InterruptedException {
                String jsondata="[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\n" +
                        "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\n" +
                        "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
                WebElement tabledata_expander= driver.findElement(By.xpath("//summary[normalize-space()='Table Data']"));
                WebElement tabledata_textbox= driver.findElement(By.xpath("//textarea[@id='jsondata']"));
                WebElement refresh_button= driver.findElement(By.xpath("//button[@id='refreshtable']"));

                tabledata_expander.click();
                Thread.sleep(3000);
                tabledata_textbox.clear();
                Thread.sleep(3000);
                tabledata_textbox.sendKeys(jsondata);
                refresh_button.click();
        }

        //  TESTDATA_READ METHOD IS USED TO PARSE THE DATA FROM JSON FILE AND EXTRACT THE VALUES FROM THE RESPECTIVE KEYS. IT RETURNS A LIST OF STRINGS WHICH WILL BE USED FOR ASSERTIONS IN MAIN METHOD
        public List<String> testdata_read(int index) throws FileNotFoundException {
                FileReader file = new FileReader("C:\\Users\\Dell\\IdeaProjects\\seleniumAutomation\\src\\test\\resources\\testdata.json");
                Object obj = JsonParser.parseReader(file);
                JsonObject detailsobj = (JsonObject) obj;
                JsonArray detailsarray = (JsonArray) detailsobj.get("details");

                JsonObject details=(JsonObject)detailsarray.get(index);

                String name= formatstring(String.valueOf(details.get("name")));
                String age = String.valueOf(details.get("age"));
                String gender= formatstring(String.valueOf(details.get("gender")));
                List<String> data = new ArrayList<>();
                data.add(name);
                data.add(age);
                data.add(gender);
                return data;

        }

        // FORMATSTRING METHOD IS USED TO REMOVE DOUBLE QUOTES FROM EXTRACTED JSON DATA.
          public String formatstring(String str)
          {     String temp;
                  StringBuilder ref=  new StringBuilder(str);
                  ref.deleteCharAt(0);
                  ref.deleteCharAt(ref.length()-1);
                  temp= String.valueOf(ref);
                  return temp;
          }

}

// LINES 79-82 intializes the chromedriver and will launch the url.

public class Assignment {
public static void main(String[]args) throws InterruptedException, FileNotFoundException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
        Readandpopulatedata obj= new Readandpopulatedata(driver);
        obj.populatedata();

        List<WebElement> rows=driver.findElements(By.xpath("//table[@id=\"dynamictable\"]/tr"));
        List<WebElement> cols=driver.findElements(By.xpath("//table[@id=\"dynamictable\"]/tr[2]/td"));

       List<String> array= new ArrayList<>();

        {

                // Lines 94 to 98 extracts the data from each row of webtable and stores it in a list
                for (int i=2;i<rows.size()+1;i++){
                        for (int j=1;j<=cols.size();j++)
                        { WebElement cell=driver.findElement(By.xpath("//table[@id=\"dynamictable\"]/tr["+i+"]/td["+j+"]"));
                              array.add(String.valueOf(cell.getText()));
                        }
                        List<String> compare=obj.testdata_read(i-2);

                        for (String display1:compare) {
                                System.out.print(display1+"--");
                        }
                        System.out.println("----------------------------------------------------------------------------");
                        for (String display2:array) {
                                System.out.print(display2+"--");
                        }
                        System.out.println("----------------------------------------------------------------------------");
// comparing data extracted from webtable with data in json file.
                        Assert.assertEquals(compare.get(0),array.get(0));
                        System.out.println("assertion 1 passed");
                        Assert.assertEquals(compare.get(1),array.get(1));
                        System.out.println("assertion 2 passed");
                        Assert.assertEquals(compare.get(2),array.get(2));
                        System.out.println("assertion 3 passed");
                        array.clear();
                        compare.clear();

                }
        }
        driver.quit();
}
}
