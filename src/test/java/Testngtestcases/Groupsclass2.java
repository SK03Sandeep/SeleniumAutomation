package Testngtestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


// this class is used in "GROUPOFGROUPS" xml file to implement meta groups.
public class Groupsclass2 {
    @Test
    public WebDriver launchbrowser()
    {
        WebDriver driver=new ChromeDriver();
        return  driver;
    }

    @Test(groups = {"functional","regression"})
    public void class2test1(){
        System.out.println("This is test1 from groupclass2");
        WebDriver d= launchbrowser();
        d.get("https://github.com/SK03Sandeep");
        System.out.println(d.getTitle());
        d.quit();
    }


    @Test(groups ={"functional","regression","smoke"})
    public void class2test2(){
        System.out.println("This is test2 from groupclass2");
        WebDriver d= launchbrowser();
        d.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        System.out.println(d.getTitle());
        d.quit();
    }


    @Test(groups = "smoke")
    public void class2test3(){
        System.out.println("This is test3 from groupclass2");
    }
}
