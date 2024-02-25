Feature: member test script
  for help, see: https://github.com/karatelabs/karate/wiki/IDE-Support

  Background:
    * url 'http://localhost:8080/'
    * cookie JSESSIONID = 'DBFAFAEEFD76D9A363F0D0123B13D10F'


  Scenario: get all members
    Given path 'members'
    When method get
    Then status 200
    And match response contains '会員一覧'

