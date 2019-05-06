Feature: Create Actor
  Description: Tests the full processes of creating an actor

  Background: The database is working and empty
    Given I am connected to the database
    When I reset the database
    Then The database should be empty

  Scenario: Create an actor with a valid first name and last name
    Given I create an actor with the first name "John" and the last name "Smith"
    When I submit the actor
    Then My actor should exist

  Scenario: Create an actor with an empty first name
    Given I create an actor with the first name "" and the last name "Smith"
    When I submit the actor
    Then My actor should not exist

  Scenario: Create an actor with an empty last name
    Given I create an actor with the first name "John" and the last name ""
    When I submit the actor
    Then My actor should not exist

  Scenario: Create an actor twice and confirm new
    Given I create an actor with the first name "John" and the last name "Smith"
    When I submit the actor
    And I submit the actor
    And I confirm that it is a new actor
    Then My actor should exist

  Scenario: Create an actor twice and don't confirm new
    Given I create an actor with the first name "John" and the last name "Smith"
    When I submit the actor
    And I submit the actor
    And I do not confirm that it is a new actor
    Then My actor should not exist