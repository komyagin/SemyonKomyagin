Feature: Different Elements page web elements page test

  Scenario: Entering Different Elements page a and interacting with elements
    Given I am on Home page
    And I login as username: 'Roman' password: 'Jdi1234'
    And I go through the header menu Service -> Different Elements Page
    When I select checkboxes
      | Checkboxes |
      | Water      |
      | Wind       |
    And  I select 'Selen' radiobutton
    And  I select 'Yellow' in dropdown menu
    Then For each checkbox there is an individual log row and value is corresponding to the status of checkbox
      | Checkboxes |
      | Water      |
      | Wind       |
    And For radio button 'Selen' there is a log row and value is corresponding to the status of radio button
    And For dropdown value 'Yellow' there is a log row and value is corresponding to the selected value