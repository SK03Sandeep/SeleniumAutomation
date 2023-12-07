package Testngtestcases;
import org.testng.annotations.Test;

// this class is used in "GROUPOFGROUPS" xml file to implement meta groups.
public class Groupsclass1 {
    @Test(groups ={"functional","smoke"})
    public void test1(){
        System.out.println("This is test1 from Groupclass1");
    }


    @Test(groups ={"functional","regression","smoke"})
    public void test2(){
        System.out.println("This is test2 from Groupclass1");
    }


    @Test(groups ={"smoke"})
    public void test3(){
        System.out.println("This is test3 from Groupclass1");
    }

}
