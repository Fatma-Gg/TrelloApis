Feature: Trello Api Feature
  Scenario: Create a board
    Given The request is set up with board name
    When POST request is sent
    Then Response status code is 200



  Scenario: Create a List
   Given The request is set up with the list name
  When POST request is sent to create list
  Then the status code is egual to 200

  Scenario: Create a new card
    Given The request is set up with the card name
    When POST request is sent to create a new card
    Then my status code is successful 200

  Scenario: update a board
    Given The new name of board is sent
    When Put request is sent to update the board
    Then the status code of req successful 200

  Scenario: update a list
    Given The new name of list is sent
    When Put request is sent to update the list
    Then the status code of request success 200

  Scenario: update a card
    Given The new name of card is sent
    When Put request is sent to update the card
    Then our status code of req is success 200

  Scenario: get a board
    Given  request is set up with board ID
    When Get request is sent
    Then get Response status code is 200

  Scenario: get a list
    Given  request is set up with list ID
    When Get list request is sent
    Then get list Response status code is 200

  Scenario: get a card
    Given  request is set up with card ID
    When Get card request is sent
    Then get card Response status code is 200

  Scenario: create a chicklist
    Given  request is set up with chicklist ID
    When post card request is sent with chicklist id
    Then post chicklist Response status code is 200

  Scenario: update a Check list
    Given The new name of check list is sent
    When Put request is sent to update the checklist
    Then checklist status code of req is success 200

  Scenario: get a checklist
    Given  request is set up with checklist ID2
    When Get checklist request is sent
    Then get checklist Response status code is 200

  Scenario: Delete a checklist
    Given  Delete request is set up with checklist ID2
    When Delete checklist request is sent
    Then Delete checklist Response status code is 200

  Scenario: Delete a card
    Given  Delete request is set up with card IDD
    When Delete card request is sent
    Then Delete card_req Response status code is 200

  Scenario: Delete a board
  Given The request is set up
  When  DELETE request is send
  Then status code response equal 200