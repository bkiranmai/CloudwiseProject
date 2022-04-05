Feature: Duplicate names

Scenario: Display all the duplicate names in the list
Given Open "chrome" browser
When Launch the site "https://www.cloudwise.nl"
And Mousehover on "Dit is Cloudwise" button and select "Alle Cloudwisers"
Then Count of all departments should be equal to "9"
And Click on each department and get the list of all users and count should be equal to "97"
And Display all the duplicate names in the list
When Close the site



