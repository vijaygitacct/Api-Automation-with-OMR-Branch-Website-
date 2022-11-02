@stateid
Feature: StateId Module API Automation

  Scenario: Get stateId form stateList endpoint
    Given User add header for accessing stateList endpoint
    When User send "GET" request for StateList endpoint
    Then User verify the status code is 200
    Then User verify the getStateId response message matches "Tamil Nadu"
