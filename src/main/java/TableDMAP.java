import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TableDMAP {
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

        WebElement greetings = driver.findElement(By.xpath("//h3[contains(text(),'Welcome')]"));

        driver.get("https://qa.dmap.cloud/orders");
        //WebElement tableElement = driver.findElement(By.xpath("//div[@class='ag-root-wrapper ag-layout-normal ag-ltr']"));

        //x-path of string with headings
        //div[@class='ag-header ag-focus-managed ag-pivot-off']

        WebElement oneCell = driver.findElement(By.xpath("//div[@comp-id='3533']"));
        oneCell.click();
        System.out.println(oneCell.getText());
    }
}
