import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecution {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://en.wikipedia.org/");

//        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("tahnert");
//        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("monsterPass123!");
//        WebElement submit_button = driver.findElement(By.xpath("//span[text()=' SIGN IN ']"));
//        submit_button.click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
       // jse.executeScript("alert('Hello world!')");
        jse.executeScript("window.scrollBy(0, 1000)", "");
        jse.executeScript("window.scrollBy(0, -1000)", "");


    }

}
