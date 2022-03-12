import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PhantomJS {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("phantomjs.binary.path", "C:\\Users\\rozov\\Downloads\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

        //driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa.dmap.cloud/auth/login");

        WebElement theField = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
        theField.sendKeys("Text for screenshot");

        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM_dd_yyyy_hh_mm");
        String fileName = format.format(dateNow) + ".png";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\rozov\\Desktop\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
