package SeleniumPractice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public WebDriver driver;

    public Screenshots(WebDriver d)
    {
        this.driver=d;
    }
    public void takeSS() throws IOException {
        TakesScreenshot screenshot= (TakesScreenshot)driver;
        File image=screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(image,new File("C:\\Users\\Dell\\Desktop\\Automation\\Screenshots.png"));
    }
}
