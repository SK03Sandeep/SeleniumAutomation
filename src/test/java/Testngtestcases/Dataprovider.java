package Testngtestcases;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Dataprovider {

    @Test(priority = 2,dataProvider = "logindata")
    public void Displaydata(String username, String password) {
        System.out.println(username + "<---->" + password);
    }


    @Test(priority = 1,dataProvider = "registrationdata")
    public void Displayregdata(Object[] data) {
        for (Object i:data) {
            System.out.println(i);
        }
        System.out.println("------------------------------------------------");
    }



        @DataProvider(name="logindata")
        public Object[][] datalogin()
        {
            Object[][] logindata = new Object[][]{
                    {"sandeep", "sandeepk03"},
                    {"virat kohli", "vk18"},
                    {"rohit sharma", "RS45"}
            };

            return logindata;
        }

        @DataProvider (name = "registrationdata")
        public Object[][] dataregister()
        {
            Object[][] regdata = new Object[][]{
                    {"sandeep",958766942,22,"male","HYD"},{"VK",668766942,35,"male","DEL"},
                    {"sandeep",954346942,37,"male","MUMBAI"}
            };

            return  regdata;
        }
    }