Feature: Display the title of the page

  Background: 
    Given Open "chrome" browser
    When Launch the site "https://www.cloudwise.nl"

  Scenario: Validate the title of the page in english
    When Click on the English flag icon
    And Mousehover on "This is Cloudwise" button and select "All cloudwisers"
    Then "All cloudwisers" page should be displayed
    And Count of all departments should be equal to "9"
    When Close the site

  Scenario: Validate the title of the page in Dutch
    And Mousehover on "Dit is Cloudwise" button and select "Alle Cloudwisers"
    Then "Alle Cloudwisers" page should be displayed
    And Count of all departments should be equal to "9"
    When Close the site
