@cityid
Feature: CityId Module API Automation

  Scenario: Get cityId form cityList endpoint
    Given User add header for accessing cityList endpoint
    When User add request body stateId to get cityList
    And User send "POST" request for cityList endpoint
    Then User verify the status code is 200
    Then User verify the getCityId response message matches "Perambalur"
