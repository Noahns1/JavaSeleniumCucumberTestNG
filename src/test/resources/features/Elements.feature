Feature: Elements functionality

  Background:
    Given the user is on the demoqa main page
    When the user clicks on Elements button
    Then the user is redirected to elements page

  @positive
  Scenario: successful enter text box information
    When the user clicks on Text Box tab
    And the user fills in all sections
    And the user selects submit
    Then the user should see submitted information displayed
    Then window closes

  @negative
  Scenario: input incorrect email format on text box
    When the user clicks on Text Box tab
    And the user fills in all sections
    But the user inputs incorrect email format
    And the user selects submit
    Then the user should not see submitted information
    Then window closes

  @positive
  Scenario: user checks box
    When the user clicks on Check Box tab
    And the user checks box
    And confirmation message appears after box is checked
    Then window closes

  @positive
  Scenario: user navigates through the file path
    When the user clicks on Check Box tab
    And the user clicks Home drop down button
    And the user clicks Desktop drop down button
    And the user checks Commands box
    Then result message for Commands appears
    Then window closes

  @positive
  Scenario: user verifies all radio buttons work as expected
    When the user clicks on Radio Button tab
    And user clicks Yes button
    Then user verifies Yes confirmation
    And user clicks Impressive button
    Then user verifies Impressive confirmation
    And user verifies No button is not clickable
    Then window closes

  @positive
  Scenario: User adds, edits, and deletes Registration Form
    When user clicks on Web Tables tab
    And user clicks add button
    When user fills in registration form
      | firstName | Noah       |
      | lastName  | S          |
      | userEmail | NS@mail.com|
      | age       | 24         |
      | salary    | 1          |
      | department| Selenium   |
    And user clicks submit
    Then user verifies form is submitted with correct info
    When user clicks edit
    And user edits registration form inputs
      | firstName | Noah        |
      | lastName  | Schlaupitz  |
      | userEmail | NNS@mail.com|
      | age       | 24          |
      | salary    | 10          |
      | department| Selenium!   |
    Then user clicks submit
    Then user verifies form is submitted with updated info
    When user clicks Delete button
    Then user verifies row is now empty
    Then window closes



