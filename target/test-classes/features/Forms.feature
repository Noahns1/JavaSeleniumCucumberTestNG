Feature: Forms Functionality

  @positive
  Scenario: successfully submit student registration form
    Given the user is on the demoqa main page
    When the user clicks on Forms button
    Then the user is redirected to the Forms page
    When the user clicks on practice form tab
    And the user fills in sections and selects all options
    And the user submits student registration form
    Then the user will correct student registration information displayed
    Then window closes

