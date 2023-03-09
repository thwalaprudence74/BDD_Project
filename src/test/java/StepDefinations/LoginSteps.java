package StepDefinations;

import DriverInitialization_Test.DriverInitialization;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginSteps extends DriverInitialization {

    ExtentReports extent;
    ExtentTest test;
    @Given("a user is on the home page")
    public void aUserIsOnTheHomePage() {
        driver = initializeDriver();
        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\ilabadmin\\Desktop\\cucumber\\BDD_Exercise\\BDD_Exercise\\reports/index.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        test = extent.createTest("Login");
    }

    @When("a user navigates to the Login page using {string}")
    public void aUserNavigatesToTheLoginPageUsing(String url) {
        driver.get(url);
    }

    @And("a user enter {string} and {string}")
    public void aUserEnterAnd(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("a user clicks the login button")
    public void aUserClicksTheLoginButton() {
        driver.findElement(By.id("login")).click();
    }

    @Then("a user is logged in successfully")
    public void aUserIsLoggedInSuccessfully() {
        Boolean logged = driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]")).getText().equalsIgnoreCase("Welcome to Adactin Group of Hotels");
        Assert.assertTrue(logged);
        test.pass("Login is successful");
        extent.flush();
        closeDriver();
    }



}
