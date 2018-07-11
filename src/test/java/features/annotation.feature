@Negative
Feature: annotation
#This is how background can be used to eliminate duplicate steps

#Scenario with AND
  Scenario: Fail to login
    Given I am on Facebook login page
    When I enter username as "TOM"
    And I enter password as "JERRY"
    Then Login should fail

#Scenario with BUT

  Scenario: Check relogin option
    Given I am on Facebook login page
    When I enter username as "TOM"
    And I enter password as "JERRY"
    Then Login should fail
    But Relogin option should be available