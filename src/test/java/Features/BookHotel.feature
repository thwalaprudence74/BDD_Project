Feature: Hotel Booking
  A feature to test a  book hotel  application

  Background:
    Given a user is on the home page
    When  a user navigates to the Login page using "https://adactinhotelapp.com/"
    And a user enter "Prudie24" and "22R947"
    And a user clicks the login button


  Scenario Outline: successful Booking
    And  a user inputs their details in the search form
    And a user clicks the search button
    And a user select hotel
    And a user clicks the continue button
    And a user enters Booking details"<firstname>", "<lastname>", "<address>", "<cardNumber>", "<cardType>", "<expiryMonth>", "<expiryYear>", "<cvvNumber>"
    And a user clicks the book now button
    Then a user booked successfully


    Examples:
      | firstname | lastname | address  | cardNumber       | cardType | expiryMonth | expiryYear | cvvNumber |
      | Linda     | Maputla  | 41 Konka | 4578196783548219 | VISA     | March       | 2022       | 978       |

  Scenario Outline: Booking unsuccessful
    And a user inputs their details in the search form
    And a user clicks the search button
    And a user select hotel
    And a user clicks the continue button
    And a user enters Booking details"<firstname>", "<lastname>", "<address>", "<cardNumber>", "<cardType>", "<expiryMonth>", "<expiryYear>", "<cvvNumber>"
    And a user clicks the book now button
    Then a user get error message

    Examples:
      | firstname | lastname | address  | cardNumber   | cardType | expiryMonth | expiryYear | cvvNumber |
      | Linda     | Maputla  | 41 Konka | 457819678354 | VISA     | March       | 2022       | 978       |