import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementsArray {

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

        driver.findElement(By.xpath("//i[@class='icon-bell']"));

        driver.get("https://qa.dmap.cloud/data/audiences");

//        WebElement logo = driver.findElement(By.xpath("//div[@class='sidebar-logo-item']"));
//        WebElement sideMenuData = driver.findElement(By.xpath("//div[@class='sidebar-item']/label[(text()='Data')]"));
//        WebElement subMenuAudiences = driver.findElement(By.xpath("//div[@class='sidebar-item']//a[@href='/data/audiences']"));
//
//        Actions hoverMouseOver = new Actions(driver);
//
//        hoverMouseOver.moveToElement(logo).perform();
//        sideMenuData.click();
//        hoverMouseOver.moveToElement(sideMenuData).perform();
//        subMenuAudiences.click();

        WebElement offersFilter = driver.findElement(By.xpath("//dmap-select[@placeholder='Select Offer']"));
        //hoverMouseOver.moveToElement(offersFilter).click().perform();
        offersFilter.click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//ng-dropdown-panel//span"));
        checkboxes.get(0).click();
        checkboxes.get(1).click();

        if (checkboxes.size() == 7) System.out.println("It's OK");
        else System.out.println("Fail!");

        // Можно использовать, чтобы убедиться, что таких элементов нет на странице
        if (driver.findElements(By.xpath("//a[text(), 'Log in']")).size() > 0) System.out.println("Such element is presented");
        else System.out.println("Cannot find such element");

       // driver.quit();
    }
}
