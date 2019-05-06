Feature: Create Organisation
  Description: Tests the full processes of creating an organisation

  Background: The database is working and empty
    Given I am connected to the database
    When I reset the database
    Then The database should be empty

  Scenario: Create an organisation with a valid name
    Given I create an organisation with the name "organisation"
    When I submit the organisation
    Then My organisation should exist

  Scenario: Create an organisation with an empty name
    Given I create an organisation with the name ""
    When I submit the organisation
    Then My organisation should not exist

  Scenario: Create an organisation twice
    Given I create an organisation with the name "organisation"
    When I submit the organisation
    And I submit the organisation
    Then An exception should be thrown