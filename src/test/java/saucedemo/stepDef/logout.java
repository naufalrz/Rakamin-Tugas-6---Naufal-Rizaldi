package saucedemo.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemoo")
    public void halaman_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);

    }

    @When("Input Usernamee")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Passwordd")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login buttonn")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("User berada di dashboardd")
    public void userBeradaDiDashboard() {
        driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div"));
        String dashboard = driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div")).getText();
        Assert.assertEquals(dashboard, "Swag Labs");
    }

    @And("User click button menu")
    public void clickbuttonmenu() {
        driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
    }

    @And("User click logout buttonn")
    public void clickLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User berada di halaman awall")
    public void userberadadiberanda() {
        driver.findElement(By.xpath("//*[@id='root']/div/div[1]"));
        String beranda = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(beranda, "Swag Labs");
        driver.close();
    }
}
