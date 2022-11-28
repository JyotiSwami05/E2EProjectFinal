Feature: OrangeHRM Login

Scenario: Orange HRM default login

Given User is on Login page

When User clicks on login button by entering username as "Admin" and password as "admin123"

Then Login Success is "true" 
#And Username is displayed this is comment

And Username display is "true"

And Close Application


Scenario: Orange HRM invalid login

Given User is on Login page

When User clicks on login button by entering username as "user" and password as "user123"

Then Login Success is "false"

And Username display is "false"

And Close Application
