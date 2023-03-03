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

public class AllSteps extends DriverInitialization {
    WebDriver driver;
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
    }

    @And("a user inputs their details in the search form")
    public void aUserInputsTheirDetailsInTheSearchForm() {
        //location
        WebElement locations = driver.findElement(By.id("location"));
        Select location = new Select(locations);
        location.selectByIndex(2);

        //hotel
        WebElement hotels = driver.findElement(By.id("hotels"));
        Select hotel = new Select(hotels);
        hotel.selectByIndex(2);

          //room type
        WebElement roomTypes = driver.findElement(By.id("room_type"));
        Select roomType = new Select(roomTypes);
        roomType.selectByIndex(2);


       // check in date
        driver.findElement(By.id("datepick_in")).clear();
        driver.findElement(By.id("datepick_in")).sendKeys("02/03/2022");

        //check out date
        driver.findElement(By.id("datepick_out")).clear();
        driver.findElement(By.id("datepick_out")).sendKeys("04/03/2022");


    }

    @And("a user clicks the search button")
    public void aUserClicksTheSearchButton() {
        driver.findElement(By.id("Submit")).click();
    }

    @And("a user select hotel")
    public void aUserSelectHotel() {
        driver.findElement(By.id("radiobutton_0")).click();
    }

    @And("a user clicks the continue button")
    public void aUserClicksTheContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("a user enters Booking details{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void aUserEntersBookingDetails(String firstName, String lastName, String address, String cardNumber, String cardType, String expiryMonth, String expiryYear, String cvvNumber) {
       // first name
        driver.findElement(By.id("first_name")).sendKeys(firstName);

       // last name
        driver.findElement(By.id("last_name")).sendKeys(lastName);

        //address
        driver.findElement(By.id("address")).sendKeys(address);

        //card number
        driver.findElement(By.id("cc_num")).sendKeys(cardNumber);

       // card type
        WebElement types = driver.findElement(By.id("cc_type"));
        Select type = new Select(types);
        type.selectByVisibleText(cardType);

       // expiryMonth
        WebElement months = driver.findElement(By.id("cc_exp_month"));
        Select month = new Select(months);
        month.selectByVisibleText(expiryMonth);

       // expiryYear
        WebElement years = driver.findElement(By.id("cc_exp_year"));
        Select year = new Select(years);
        year.selectByVisibleText(expiryYear);

        //cvvNumber
        driver.findElement(By.id("cc_cvv")).sendKeys(cvvNumber);
    }


    @And("a user navigate to the Booked Itinerary")
    public void aUserNavigateToTheBookedItinerary() {
        driver.findElement(By.xpath("//a[contains(text(),'Booked Itinerary')]")).click();
    }

    @And("a user search for Itinerary using orderId")
    public void aUserSearchForItineraryUsingOrderId() {
        String orderId = "K1Q3LU630Q";
        driver.findElement(By.id("order_id_text")).sendKeys(orderId);
        driver.findElement(By.id("search_hotel_id")).click();
    }

    @Then("order is displayed successfully")
    public void orderIsDisplayedSuccessfully() {
        if(!driver.findElement(By.id("search_result_error")).isDisplayed()){
            Assert.fail();
        }
    }

    @And("a user clicks the book now button")
    public void aUserClicksTheBookNowButton() throws InterruptedException {
        driver.findElement(By.id("book_now")).click();
        Thread.sleep(500);
    }

    @Then("a user booked successfully")
    public void aUserBookedSuccessfully() {
        if(!driver.findElement(By.id("order_no")).isDisplayed()){
            Assert.fail();
        }
    }

    @Then("a user get error message")
    public void aUserGetErrorMessage() {

        if(!driver.findElement(By.id("cc_num_span")).isDisplayed()){
            Assert.fail();
        }
    }

}
