@profile
Feature: Change Profile Picture Module API Automation

  Scenario: Verify change profile picture to the application through api
    Given User add header and bearer authorization for accessing changeProfilePic endpoint
    When User add formData for profilePic file
    And User send "POST" request for changeProfilePic endpoint
    Then User verify the status code is 200
    Then User verify the changeProfilePic response message matches "Profile updated Successfully"
