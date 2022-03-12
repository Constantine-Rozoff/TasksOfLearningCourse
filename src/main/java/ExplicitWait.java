import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {
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

//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sidebar-container']")));
//        wait.until(ExpectedConditions.visibilityOf(By.xpath("//div[@class='sidebar-container']")));
//        wait.until(ExpectedConditions.invisibilityOf(By.xpath("//div[@class='sidebar-container']")));

//        WebElement sideBarContainer = driver.findElement(By.xpath("//div[@class='sidebar-container']"));
//        sideBarContainer.click();

        selectOption("data", "models");

    }

    public static void selectOption(String listName, String option) {
        String listXpath = String.format("//i[@class='icon-%s']/..", listName);
        String optionXpath = String.format("//a[@href='/data/%s']", option);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
    }
}
