@HomePage
Feature: home page

  Background: click on the start button
    Given User should be able to go to home page
    And Verify that the user is on the home page the timer
    When User clicks Start button
    Then  Start button should be visible
    And Start button must be clickable


  Scenario: click on the stop button
    Given User clicks Stop button
    Then  Stop button should be visible
    And Stop button must be clickable

  Scenario: click on the Reset button
    Given User clicks Reset button
    Then  Reset button should be visible
    And Reset button must be clickable


  Scenario: verifying minute 15 on timer
      When the timer reaches the 15 minutes
      Then User clicks Stop button

  Scenario: verifying minute 0 on timer
    When the timer reaches the 0 minute
    Then the timer is verified in 0 minute

    #negative scenario
  Scenario: clicking start button when the timer is 0
    When the timer reaches the 0 minutes
    Then the timer is verified in 0 minute
    And User clicks Start button
    And start button is not clickable

    #negative scenario
  Scenario: clicking start button when the timer is 0
    When the timer reaches the 0 minutes
    Then the timer is verified in 0 minute
    And User clicks Stop button
    And Stop button is not clickable















