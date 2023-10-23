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

public class checkout {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("Halaman beranda soucedemo1")
    public void halaman_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);

    }

    @When("Input Username benar1")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password benar1")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button benar1")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @And("User berada di dashboard benar1")
    public void userBeradaDiDashboard() {
        driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div"));
        String dashboard = driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div")).getText();
        Assert.assertEquals(dashboard, "Swag Labs");
    }

    @And("User click button keranjang benar1")
    public void clickbuttonkeranjang() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
    }

    @And("User click button checkout")
    public void clickbuttoncheckout() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @When("User input First Name")
    public void inputfirstname() {
        driver.findElement(By.id("first-name")).sendKeys("Naufal");
    }

    @When("User input Last Name")
    public void inputlastname() {
        driver.findElement(By.id("last-name")).sendKeys("Rizaldi");
    }

    @When("User input zip code")
    public void inputzipcode() {
        driver.findElement(By.id("postal-code")).sendKeys("45100");
    }

    @And("User click continue")
    public void clickbuttoncontinue() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @And("User click finish")
    public void clickfinish() {
        driver.findElement(By.xpath("//*[@id='finish']")).click();
    }

    @Then("User mendapat pemberitahuan berhasil")
    public void pemberitahuanberhasil() {
        driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2"));
        String notif = driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2")).getText();
        Assert.assertEquals(notif, "Thank you for your order!");
        driver.close();
    }
}
