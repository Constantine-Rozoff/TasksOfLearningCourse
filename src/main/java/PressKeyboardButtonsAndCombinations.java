import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PressKeyboardButtonsAndCombinations {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa.dmap.cloud/auth/login");

        WebElement theField = driver.findElement(By.xpath("//input[@formcontrolname='username']"));
        String select = Keys.chord(Keys.CONTROL, "a");
        String cut = Keys.chord(Keys.CONTROL, "x");
        String paste = Keys.chord(Keys.CONTROL, "v");
        theField.sendKeys(Keys.chord(Keys.SHIFT, "hello guys"));


        theField.sendKeys(select);
        theField.sendKeys(cut);
        theField.sendKeys(paste);

        theField.sendKeys(Keys.ENTER);

        driver.quit();
    }
}
