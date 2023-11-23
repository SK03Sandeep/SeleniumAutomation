package Testngtestcases;
import  java.lang.String;
import java.lang.Object;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datasuppliertest {

@Test(dataProvider="dp1",dataProviderClass=Datasupplier.class)
    public void DisplayCeo(String name,String company)
{
    System.out.println(name+"--------"+company);
}

}
