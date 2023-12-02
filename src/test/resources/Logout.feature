@smoke
Feature: Parabank logout testing
Description: User should already have an account
Background: User should be logged in
@TC1 
Scenario Outline: As a logged-in user, I want to logout successfully from website
Given open the browser
And pass the URL "<URL>"
When enter username "<username>" in the Username field
And enter password "<password>" in the Password field
And click on Login
And click on Log Out
Then validate logout is successful
Examples:
|URL                                                           |username|password |
|https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC|rezwan|Boston@2023|