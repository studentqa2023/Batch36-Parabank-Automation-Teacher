@smoke
Feature: Parabank login testing
Description: User should already have an account
Background:
@TC1 
Scenario Outline: As a user, I want to login to Parabank website using valid credentials
Given open the browser
And pass the URL "<URL>"
When enter username "<username>" in the Username field
And enter password "<password>" in the Password field
And click on Login
Then validate login is successful
Examples:
|URL                                                           |username|password |
|https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC|rezwan|Boston@2023|