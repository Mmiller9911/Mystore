Feature: Homepage


Scenario: Login with a valid username and password
	Given I enter "matt.miller@mqmsolutions.com" as my username
	And I enter "hunky123!" as my password
	And I click login button after entering login details
    
@check    
Scenario Outline: Login with a valid username and invalid password
	Given I enter "<Username>" as my username
    And I enter "<Password>" as my password
    And I click login button after entering login details
    Then I should see a <message> error message
      
    Examples:
    | Username                     | Password | message      |
    | matt.miller@mqmsolutions.com | invalid  | bad password |
    | invalid                      | invalid  | bad username |
        
  Scenario: Login with valid username but no password
	Given I enter "matt.miller@mqmsolutions.com" as my username
	And I click login button after entering login details
    Then I should see a no password error message
    
 Scenario: Login with no username and valid password
	And I enter "hunky123!" as my password
	And I click login button after entering login details
    Then I should see a no username error message
       
  Scenario: Login no username or password
	And I click login button after entering login details
    Then I should see a no username error message

 Scenario: Login with a valid username and password
	Given I enter "matt.miller@mqmsolutions.com" as my username
	And I enter "hunky123!" as my password
	And I click register button
    Then I should see an error message

