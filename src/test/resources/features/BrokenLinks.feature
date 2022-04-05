Feature: Broken Links

  Scenario Outline: Verify the broken links in the departments page
    Given Open "<browser>" browser
    When Launch the site "<url>"
    And Mousehover on "<text1>" button and select "<text2>"
    Then Count of all departments should be equal to "9"
    And Identify and display the broken links for all departments
    When Close the site

    Examples: 
      | browser | url                      | text1             | text2            |
      | chrome  | https://www.cloudwise.eu | This is Cloudwise | All cloudwisers  |
      | edge    | https://www.cloudwise.nl | Dit is Cloudwise  | Alle Cloudwisers |
