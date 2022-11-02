@product
Feature: Product Search Module API Automation

  Scenario Outline: Verify product search to the application through api
    Given User add header for accessing product list endpoint
    When User add request body search product "<text>"
    And User send "POST" request for search product endpoint
    Then User verify the status code is 200
    And User verify the search product response message matches "OK"

    Examples: 
      | text |
      | nuts |
