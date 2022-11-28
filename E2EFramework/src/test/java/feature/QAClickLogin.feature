Feature: QA Click Login

Scenario Outline: QA Click login DDT Test

Given Launch QA Click application 
And Click on Login to land on sign in page

When User tries to login with invalid username as <username> and password as <password>

Then login is unsuccessful
And Close browser
Examples:
|username |password |
|j@s.com  |123      |
|c@d.com  |456      |
|g@h.com  |789      |
