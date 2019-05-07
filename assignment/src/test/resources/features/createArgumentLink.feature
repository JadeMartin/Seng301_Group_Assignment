Feature: Create Argument
  Description: Tests the full processes of creating an argument

  Background: The database is working and empty
    Given I am connected to the database
    When I reset the database
    Then The database should be empty

  Scenario: Create an argument link between two different arguments successfully
    Given I have inserted an actor, discourse and source and some test arguments
    And I create an argument link by inputting "1" for argument 1 and "2" for argument 2 with argument type "1"
    When I submit the argument link
    Then My argument link should exist

  Scenario: Create an argument link where the first argument does not exist
    Given I have inserted an actor, discourse and source and some test arguments
    And I create an argument link by inputting "1000" for argument 1 and "2" for argument 2 with argument type "1"
    When I submit the argument link
    Then My argument link should exist

  Scenario: Create an argument link where the second argument does not exist
    Given I have inserted an actor, discourse and source and some test arguments
    And I create an argument link by inputting "1" for argument 1 and "2" for argument 2 with argument type "1"
    When I submit the argument link
    Then My argument link should exist