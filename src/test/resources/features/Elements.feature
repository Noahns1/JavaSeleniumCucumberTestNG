Feature: Elements functionality

  @positive
  Scenario: successful enter text box information
    Given the user is on the demoqa main page
    When the user clicks on Elements button
    Then the user is redirected to elements page
    When the user clicks on Text Box tab
    And the user fills in all sections
    And the user selects submit
    Then the user should see submitted information displayed
    Then window closes

  @negative
  Scenario: input incorrect email format on text box
    Given the user is on the demoqa main page
    When the user clicks on Elements button
    Then the user is redirected to elements page
    When the user clicks on Text Box tab
    And the user fills in all sections
    But the user inputs incorrect email format
    And the user selects submit
    Then the user should not see submitted information
    Then window closes