Feature: Search Feature - Data Driven Testing

  Background:
    Given User is on home page
    Then Search bar should appear

  Scenario Outline: Search with valid keywords

    When User searches "<keyword>"
    Then Valid products should appear

    Examples:
      | keyword |
      | iPhone  |
      | Samsung |

  Scenario Outline: Search with invalid keywords

    When User searches "<keyword>"
    Then Invalid product message should appear

    Examples:
      | keyword   |
      | nikk    |