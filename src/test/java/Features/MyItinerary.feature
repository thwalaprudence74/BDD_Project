Feature: Itinerary search
  A feature to test a search itinerary application

  Background: order search
    Given a user is on the home page
    When  a user navigates to the Login page using "https://adactinhotelapp.com/"
    And a user enter "Prudie24" and "22R947"
    And a user clicks the login button

    Scenario:
      And a user navigate to the Booked Itinerary
      And a user search for Itinerary using orderId
      Then order is displayed successfully