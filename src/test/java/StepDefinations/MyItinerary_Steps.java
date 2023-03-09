package StepDefinations;

import DriverInitialization_Test.DriverInitialization;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyItinerary_Steps extends DriverInitialization {
    @And("a user navigate to the Booked Itinerary")
    public void aUserNavigateToTheBookedItinerary() {
        driver.findElement(By.xpath("//a[contains(text(),'Booked Itinerary')]")).click();
    }

    @And("a user search for Itinerary using orderId")
    public void aUserSearchForItineraryUsingOrderId() {
        String orderId = "4447216AXV";
        driver.findElement(By.id("order_id_text")).sendKeys(orderId);
        driver.findElement(By.id("search_hotel_id")).click();
    }

    @Then("order is displayed successfully")
    public void orderIsDisplayedSuccessfully() {
        if(!driver.findElement(By.id("search_result_error")).isDisplayed()){
            Assert.fail();
        }
        closeDriver();
    }
}
