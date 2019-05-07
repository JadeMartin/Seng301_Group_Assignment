Feature: Create Argument
  Description: Tests the full processes of creating an argument

  Background: The database is working and empty
    Given I am connected to the database
    When I reset the database
    Then The database should be empty

  Scenario: Create an argument with valid fields
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1", source "1", discourse "1", rephrasing "string", start index "1", end index "2"
    When I submit the argument
    Then My argument should exist

  Scenario: Create an argument with missing actor
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1000", source "1", discourse "1", rephrasing "string", start index "1", end index "2"
    Then I should be notified with an incorrect argument error

  Scenario: Create an argument with illegal actor
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "sdf", source "1", discourse "1", rephrasing "string", start index "1", end index "2"
    Then I should be notified with an incorrect argument error

  Scenario: Create an argument with missing source
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1", source "1000", discourse "1", rephrasing "string", start index "1", end index "2"
    Then I should be notified with an incorrect argument error

  Scenario: Create an argument with illegal source
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1", source "sdf", discourse "1", rephrasing "string", start index "1", end index "2"
    Then I should be notified with an incorrect argument error

  Scenario: Create an argument with missing discourse
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1", source "1", discourse "1000", rephrasing "string", start index "1", end index "2"
    Then I should be notified with an incorrect argument error

  Scenario: Create an argument with illegal discourse
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1", source "1", discourse "sdf", rephrasing "string", start index "1", end index "2"
    Then I should be notified with an incorrect argument error

  Scenario: Create an argument with empty string rephrasing
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1", source "1", discourse "1", rephrasing "", start index "1", end index "2"
    Then I should be notified with an incorrect argument error

  Scenario: Create an argument with negative start index
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1", source "1", discourse "1", rephrasing "string", start index "-1", end index "2"
    Then I should be notified with an incorrect argument error

  Scenario: Create an argument with negative end index
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1", source "1", discourse "1", rephrasing "string", start index "1", end index "-2"
    Then I should be notified with an incorrect argument error

  Scenario: Create an argument with end index smaller than start index
    Given I have inserted an actor, discourse and source
    And I create an argument with the actor "1", source "1", discourse "1", rephrasing "string", start index "2", end index "1"
    Then I should be notified with an incorrect argument error
