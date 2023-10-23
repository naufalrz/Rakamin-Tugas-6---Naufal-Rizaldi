Feature: Logout Aplikasi saucedemo

  Scenario: Success Logout
    Given Halaman login saucedemoo
    When Input Usernamee
    And Input Passwordd
    And Click login buttonn
    And User berada di dashboardd
    And User click button menu
    And User click logout buttonn
    Then User berada di halaman awall