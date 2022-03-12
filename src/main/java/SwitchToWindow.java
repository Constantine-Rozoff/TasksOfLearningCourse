import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchToWindow {
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

        selectExternalLinkOption("templates", "ResourceSpace");
        //selectExternalLinkOption("reporting", "Looker");

        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("apiuser");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("meiqix5");
        driver.findElement(By.xpath("//input[@name='Submit']")).click();

        //driver.quit();
    }

    public static void selectExternalLinkOption(String listName, String option) {
        String listXpath = String.format("//i[@class='icon-%s']/..", listName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String optionXpath = String.format("//label[text()='%s']/following-sibling::i", option);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
    }
}
