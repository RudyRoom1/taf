Feature: Rest Assure test VideoGamesDB
  My first test using cucumber

  Scenario: All user have same gender
    Given User set specification
    When Endpoint 'api/?page=50&results=4' was set endpoint
    Then Convert json to POJO
    Then All user have same gender

  Scenario: passwords on the page  contains at least 1 digit and 1 capital, none of the passwords contains user name
    Given User set specification
    When Endpoint 'api/?page=50&results=4' was set endpoint
    Then Convert json to POJO
    Then User password contains at least 1 digit and 1 capital, none of the passwords contains user name

  Scenario: at least 1 occurrence of Mrs, Ms and Mr
    Given User set specification
    When Endpoint 'api/?page=50&results=4' was set endpoint
    Then Convert json to POJO
    Then Users title occurrence of Mrs, Ms and Mr

  Scenario: average age is lower than 40
    Given User set specification
    When Endpoint 'api/?page=50&results=4' was set endpoint
    Then Convert json to POJO
    Then Users average age is lower than '40'
