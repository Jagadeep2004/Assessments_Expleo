Feature: Address Book Feature using Data Table

  Scenario: Add new address using Data Table

    Given User logs into the application
    When User navigates to Address Book page
    And User enters address details
      | firstName | John            |
      | lastName  | Doe            |
      | address1  | 123 Main Street |
      | city      | Chennai         |
      | postCode  | 600001          |
      | country   | India           |
      | region    | Tamil Nadu      |
    Then Address should be added successfully