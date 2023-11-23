package Testngtestcases;

import org.testng.annotations.*;

public class Firsttest {
    @Test
    public void  test1()
    {
        System.out.println("Test1");
    }
    @Test
    public void  test2()
    {
        System.out.println("Test2");
    }

    @BeforeMethod
    public void  beformethod()
    {
        System.out.println("executes before every @test method");
    }

    @AfterMethod
    public void  aftermethod()
    {
        System.out.println("executes after every @test method");
    }

    @BeforeTest
    public void Beforetest()
    {
        System.out.println("This is before test annotated method");
    }
    @AfterTest
    public void aftertest()
    {
        System.out.println("This is after test annotated method");
    }

    @BeforeSuite
    public void beforesuite()
    {
        System.out.println("This is before suite annotated method");
    }
    @AfterTest
    public void aftersuite()
    {System.out.println("This is after suite annotated method");}

    @BeforeClass
    public void beforeclass()
    {
        System.out.println("This is before class annotated method");
    }
    @AfterClass
    public void afterclass()
    {System.out.println("This after is class annotated method");}


}
