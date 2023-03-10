package StepDefinations;

import DriverInitialization_Test.DriverInitialization;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyItinerary_Steps extends DriverInitialization {
    ExtentReports extent;
    ExtentTest test;

    @And("a user navigate to the Booked Itinerary")
    public void aUserNavigateToTheBookedItinerary() {
        extent = getReportObject("\\reports\\searchReport.html");
        test = extent.createTest("Order Search");
        driver.findElement(By.xpath("//a[@href='BookedItinerary.php']")).click();
    }

    @And("a user search for Itinerary using orderId")
    public void aUserSearchForItineraryUsingOrderId() {
        String orderId = "4447216AXV";
        driver.findElement(By.id("order_id_text")).sendKeys(orderId);
        driver.findElement(By.id("search_hotel_id")).click();
    }

    @Then("order is displayed successfully")
    public void orderIsDisplayedSuccessfully() {
        if (!driver.findElement(By.id("search_result_error")).isDisplayed()) {
            test.fail("Itinerary searched failed").addScreenCaptureFromPath("screenshot.png");
            Assert.fail();
        } else {
            test.pass("Itinerary search passed");
        }
        closeDriver();
        extent.flush();
    }
}
