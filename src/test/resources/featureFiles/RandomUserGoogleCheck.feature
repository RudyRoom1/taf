Feature: Random user search in google


  Scenario: Random user search in google and check facebook account
    Given Get random user
    Then Search the user in google
    Then Check facebook page for random user is exist