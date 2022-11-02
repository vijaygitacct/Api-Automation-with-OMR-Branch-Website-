@address
Feature: Address Module API Automation

  @addAddress
  Scenario Outline: Verify add user address to the application through api
    Given User add header and bearer authorization for accessing address endpoint
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<stateId>","<cityId>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User verify the status code is 200
    And User verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | first_name  | last_name | mobile     | apartment | stateId | cityId | country | zipcode | address | address_type |
      | Vijayakumar | Perumal   | 9600748951 | AKR       |      35 |   4112 |     101 |  600095 | chennai | Office       |

  Scenario Outline: Verify update user address to the application through api
    Given User add header and bearer authorization for accessing address endpoint
    When User add request body for update new address "<address_id>","<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User verify the status code is 200
    And User verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | address_id | first_name  | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      |      31100 | Vijayakumar | Perumal   | 9600748951 | AKR       |   123 |   11 |     101 |  600095 | chennai | Office       |

  Scenario: Verify get user address to the application through api
    Given User add header and bearer authorization for accessing address endpoint
    When User send "GET" request for getUserAddress endpoint
    Then User verify the status code is 200
    And User verify the getUserAddress response message matches "OK"

  Scenario Outline: Verify delete user address to the application through api
    Given User add header and bearer authorization for accessing address endpoint
    When User add request body for delete user address "<address_id>"
    And User send "DELETE" request for deleteUserAddress endpoint
    Then User verify the status code is 200
    And User verify the deleteUserAddress response message matches "Address deleted successfully"

    Examples: 
      | address_id |
      |      31100 |
