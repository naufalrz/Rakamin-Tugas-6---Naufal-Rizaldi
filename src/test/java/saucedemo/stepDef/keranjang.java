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

public class keranjang {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("Halaman beranda soucedemo")
    public void halaman_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);

    }

    @When("Input Username benar")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password benar")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button benar")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("User berada di dashboard benar")
    public void userBeradaDiDashboard() {
        driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div"));
        String dashboard = driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div")).getText();
        Assert.assertEquals(dashboard, "Swag Labs");
    }

    @And("User click button keranjang benar")
    public void clickbuttonkeranjang() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
    }

    @Then("User berada di halaman keranjang benar")
    public void beradadikeranjang() {
        driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
        String beranda = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(beranda, "Your Cart");
        driver.close();
    }
}
