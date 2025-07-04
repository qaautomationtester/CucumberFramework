Feature: Login to Salesforce Application
	
  @salesforce
  Scenario: Successful User Login to the Application
    Given the user is on the login page
    When the user logs in with email "kudkan90616@agentforce.com" and password "Nish@nth1#"
    Then the user should be successfully logged in
    When the user logs out
  	Then the user should be successfully logged out
