import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void success_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();;

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //inpue email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login
        driver.findElement(By.id("login-button")).click();
        driver.close();
    }

    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //inpue email
        driver.findElement(By.id("email")).sendKeys("sel@admin.com");
        //input password
        driver.findElement(By.id("password")).sendKeys("1234");
        //click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String errorlogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorlogin, "Kredensial yang Anda berikan salah");
        driver.close();
    }
}
