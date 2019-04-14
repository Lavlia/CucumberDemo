Feature: This feature checks the functionality of the UI from Left Main Menu in Softvision Site
  As an user
  I want to navigate through Left Main Menu
  So I can check the links in the menu

  Scenario Outline: This scenario check every link in the Left Main Menu
    Given I navigate to Softvision Site
    And I click on  every <LinkButton> in Left Main Menu
    Then I verify if the link have the proper <ElementTitle>

    Examples: Links and their proper names
      | LinkButton | ElementTitle |
      | What       | What's new   |
      | Solutions  | Solutions    |
      | Talent     | Talent       |
      | Studios    | Studios      |