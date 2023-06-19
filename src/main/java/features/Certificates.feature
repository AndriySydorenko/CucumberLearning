Feature: Check certificate
  Scenario: Check if certificate is exist
    When User opens certificates page
    And Enter certificate identificator "45924126"
    And Select check button
    Then Verify than certificate is "true"