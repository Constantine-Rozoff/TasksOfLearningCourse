import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UploadingFile {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa.dmap.cloud/auth/login");

        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("tahnert");
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("monsterPass123!");
        WebElement submit_button = driver.findElement(By.xpath("//span[text()=' SIGN IN ']"));
        submit_button.click();

        WebElement userMenuIcon = driver.findElement(By.xpath("//div[@class='user-container']//i"));
        userMenuIcon.click();
        WebElement editUserPhoto = driver.findElement(By.xpath("//label[text()='Edit Profile Photo']/parent::button"));
        editUserPhoto.click();
        WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
        chooseFile.sendKeys("C:\\Users\\rozov\\Desktop\\pic1.jpg");

        driver.quit();
    }
}
