Feature: Login Functionality for OpenCart E-commerce Website

  As a user of the OpenCart website
  I want to be able to log in with my account
  So that I can access my account related features and manage my orders

  Background:
    Given I am on the OpenCart login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully


  Scenario Outline: Unsuccessful login with invalid  or empty credentials
    Given I have entered a invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                                         |
      | invalid@gmail.com | Invalidpassword | Warning: No match for E-Mail Address and/or Password. |
      | invalid@gmail.com | Validpassword   | Warning: No match for E-Mail Address and/or Password. |
      | Valid@gmail.com   | Invalidpassword | Warning: No match for E-Mail Address and/or Password. |


  Scenario: Navigating to forgotten password page
    When I click on forgot password link
    Then I should be redirected to password reset page