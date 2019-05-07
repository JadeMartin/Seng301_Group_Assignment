Feature: Create Argument Link
  Description: Tests the full processes of creating an argument

  Background: The database is working and empty
    Given I am connected to the database
    When I reset the database
    Then The database should be empty

  Scenario: Create an argument link between two different arguments successfully
    Given I insert two arguments in the database
    And I create an argument link by inputting "1" for argument one and "2" for argument two with argument type "1"
    When I submit the argument link
    Then My argument link should exist

  Scenario: Create an argument link where the first argument does not exist
    Given I insert two arguments in the database
    And I create an argument link by inputting "1000" for argument one and "2" for argument two with argument type "1"
    Then I should be notified with an incorrect argument link error

  Scenario: Create an argument link with an illegal first argument
    Given I insert two arguments in the database
    And I create an argument link by inputting "sdf" for argument one and "2" for argument two with argument type "1"
    Then I should be notified with an incorrect argument link error

  Scenario: Create an argument link where the second argument does not exist
    Given I insert two arguments in the database
    And I create an argument link by inputting "1" for argument one and "1000" for argument two with argument type "1"
    Then I should be notified with an incorrect argument link error

  Scenario: Create an argument link with an illegal second argument
    Given I insert two arguments in the database
    And I create an argument link by inputting "1" for argument one and "sdf" for argument two with argument type "1"
    Then I should be notified with an incorrect argument link error

  Scenario: Create an argument link where the type does not exist
    Given I insert two arguments in the database
    And I create an argument link by inputting "1" for argument one and "2" for argument two with argument type "1000"
    Then I should be notified with an incorrect argument link error

  Scenario: Create an argument link with an illegal type
    Given I insert two arguments in the database
    And I create an argument link by inputting "1" for argument one and "1000" for argument two with argument type "sdf"
    Then I should be notified with an incorrect argument link error

  Scenario: Create an argument link where both arguments are the same
    Given I insert two arguments in the database
    And I create an argument link by inputting "1" for argument one and "1" for argument two with argument type "1"
    Then I should be notified with an incorrect argument link error