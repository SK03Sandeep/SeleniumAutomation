package Testngtestcases;

import org.testng.annotations.DataProvider;

// practice of providing dataprovider in separate class and calling it from separate @test class
public class Datasupplier {
    @DataProvider(name = "dp1")
    public Object[][] compdata()
    {
        Object[][]  Ceo= new Object[][]{
                {"sundar pichai","Google"},{"Tim cook","Apple"},{"Satya nadella","Microsoft"}};
        return Ceo;
    }
}
