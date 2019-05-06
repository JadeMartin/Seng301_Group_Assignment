Feature: Create Affiliation
  Description: Tests the full processes of creating an affiliation

  Background: The database is working and empty
    Given I am connected to the database
    When I reset the database
    Then The database should be empty

  Scenario: Create an affiliation with valid fields
    Given I have inserted an actor and organisation
    And I create an affiliation with the actor 1, organisation 1, role "role", start date "03/05/2019", end date "04/05/2019"
    When I submit the affiliation
    Then My affiliation should exist

  Scenario: Create an affiliation with dates in the wrong order
    Given I have inserted an actor and organisation
    And I create an affiliation with the actor 1, organisation 1, role "role", start date "04/05/2019", end date "03/05/2019"
    When I submit the affiliation
    Then My affiliation should not exist
