@login
Feature: Login Module API Automation

  Scenario: Get User logtoken from login endpoint
    Given User add header
    When User add basicAuthentication for login
    And User send "POST" request for login
    Then User verify the status code is 200
    Then User verify the login response body firstName present as "Vijayakumar" and get the logtoken get saved
