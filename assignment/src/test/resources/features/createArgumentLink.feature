#Feature: Create Actor
#  Description: Tests the full processes of creating an actor
#
#  Background: The database is working and empty
#    Given I am connected to the database
#    When I reset the database
#    Then The database should be empty
#
#  Scenario: Create an actor with a valid first name and last name
#    Given I create an actor with the first name "John" and the last name "Smith"
#    When I submit the actor
#    Then My actor should exist
#
#  Scenario: Create an actor with an empty first name
#    Given I create an actor with the first name "" and the last name "Smith"
#    Then I should be notified that there is an error
#
#  Scenario: Create an actor with an empty last name
#    Given I create an actor with the first name "John" and the last name ""
#    Then I should be notified that there is an error
#
#  Scenario: Create a homonym actor
#    Given I create an actor with the first name "John" and the last name "Smith"
#    When I submit the actor
#    And I create an actor with the first name "John" and the last name "Smith"
#    And I answer "1" to insert duplicate
#    And I submit the actor
#    Then My actor should exist
#
#  Scenario: Do not create a homonym actor
#    Given I create an actor with the first name "John" and the last name "Smith"
#    When I submit the actor
#    And I create an actor with the first name "John" and the last name "Smith"
#    And I answer "2" to insert duplicate
#    Then Two actors should not exist
#
#  Scenario: Create a homonym actor with number input that is out of bounds
#    Given I create an actor with the first name "John" and the last name "Smith"
#    When I submit the actor
#    And I create an actor with the first name "John" and the last name "Smith"
#    And I answer "123" to insert duplicate
#    Then I should be notified that there is an error
#
#  Scenario: Create a homonym actor with illegal input
#    Given I create an actor with the first name "John" and the last name "Smith"
#    When I submit the actor
#    And I create an actor with the first name "John" and the last name "Smith"
#    And I answer "sdf" to insert duplicate
#    Then I should be notified that there is an error
#
