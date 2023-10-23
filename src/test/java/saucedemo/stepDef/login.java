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

public class login {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("Halaman login saucedemo")
    public void halaman_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);

    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User berada di dashboard")
    public void userBeradaDiDashboard() {
        driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div"));
        String dashboard = driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div")).getText();
        Assert.assertEquals(dashboard, "Swag Labs");
        driver.close();
    }

    @When("Input Username salah")
    public void inputUsernameSalah() {
        driver.findElement(By.id("user-name")).sendKeys("sel1@admin.com");
    }

    @Then("User mendapatkan pesan error")
    public void userMendapatkanPesanError() {
        String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}