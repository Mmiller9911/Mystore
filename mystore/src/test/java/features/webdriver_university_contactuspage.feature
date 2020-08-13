@contact @all
Feature: Contact us page


@tcid1
Scenario: Submit valid data via contact us form
	Given I access webdriveruniversity contact us form
	When I enter a valid firstname
	When I enter a valid last name
	| woods | jackson | jones |
	And I enter a valid email address 
	And I enter comments
	|example comment one | example comment two |
	When I click on the submit button
	Then the information should successfully be submitted via the contact us form
	

@tcid2
Scenario: Submit information using the contact us form and then reset the form
	Given I access webdriveruniversity
	And I click on the contact us button
	And I enter firstname
	And I enter surname
	And I enter email address
	And I enter comments
	|example comment one | example comment two |
	When I click on the reset button
	Then the information should be removed	
	
	
@tcid3
Scenario: Submit information using the contact us form
	Given I access webdriveruniversity
	And I click on the contact us button
	And I enter firstname
	And I enter surname
	And I enter email address
	And I enter comments
	|example comment one | example comment two |
	When I click on the submit button
	Then the information should be successfully be submitted via the contact us form
	
@tcid4
Scenario: Submit an invalid email address using the contact us form
	Given I access webdriveruniversity
	And I click on the contact us button
	And I enter firstname
	And I enter surname
	And I enter an invalid email address
	And I enter comments
	|example comment one | example comment two |
	When I click on the submit button
	Then an error message should be seen
	
@tcid5
Scenario: Submit multiple comments
	Given I access webdriveruniversity
	And I click on the contact us button
	And I enter firstname
	And I enter surname
	And I enter email address
	And I enter comments
	| Example comment one   | Example comment two  |
	| Example comment three | Example comment four |
	| Example comment five  | Example comment six  |
	When I click on the submit button
	Then the information should be successfully be submitted via the contact us form
	
	
	