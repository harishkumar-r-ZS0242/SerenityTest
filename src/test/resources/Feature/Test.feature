Feature: Login

  #include tags
  @Sanity
  Scenario: 1 Verify the user Login functionality
    Given Launch the Application
    And Enter User credentials
      | username | password    |
      | student  | Password123 |
    When Click Submit Button
    Then Verify page title
      | title                  |
      | Logged In Successfully |

  @Regression
  Scenario: 2 Verify Home page navigation
    Given Click "Home" tab
    Then Verify page title
      | title |
      | Hello |

  @Failure
  Scenario: 3 Verify Home page navigation
    Given Click "Practice" tab
    Then Verify page title
      | title    |
      | Practise |
