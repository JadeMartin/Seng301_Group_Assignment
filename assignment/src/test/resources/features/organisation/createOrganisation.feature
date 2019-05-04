Feature: Create Organisation
  Description: Tests the full processes of creating an organisation

  Background: The database is working and empty
    Given I am connected to the database
    And I reset the database

  Scenario: Create an organisation with a valid name
    Given I provide the organisation name "organisation"
    When I submit the organisation
    Then The organisation should exist

  Scenario: Create an organisation without an empty name
    Given I provide the organisation name ""
    When I submit the organisation
    Then the organisation should not exist

  Scenario: Create an organisation with a taken name
    Given The organisation "organisation" exists in the database
    And I provide the organisation name "organisation"
    When I submit the organisation
    Then An exception should be thrown