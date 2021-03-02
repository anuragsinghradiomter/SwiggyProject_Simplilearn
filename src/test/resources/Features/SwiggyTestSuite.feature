#Swiggy Project Feature File

Feature: Swiggy Bill Total Check
  I want to use check the correctness of Swiggy Menu Bill Total

  Scenario: Total Bill value check
    Given User has add menu items into Swiggy site
    And Menu list and price are added into excelsheets
    When Total Bill has been generated
    Then I validate the correctness of total bill value
