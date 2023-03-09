package StepDefinations;
import DriverInitialization_Test.DriverInitialization;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookHotel_Steps extends DriverInitialization {



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

    @And("a user clicks the book now button")
    public void aUserClicksTheBookNowButton() throws InterruptedException {
        driver.findElement(By.id("book_now")).click();
        Thread.sleep(500);
    }

    @And("a user booked successfully")
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
