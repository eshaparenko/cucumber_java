Feature: New user registration with data table.

  Scenario:
    Given I am on the new user registration page
    When I enter invalid data on the page

      | Fields                 | Values              |
      | First Name             | Tom                 |
      | Last Name              | Kenny               |
      | Email Address          | someone@someone.com |
      | Re-enter Email Address | someone@someone.com |
      | Password               | Password1           |
      | Birthdate              | 01                  |

    Then user registration should be unsuccessful