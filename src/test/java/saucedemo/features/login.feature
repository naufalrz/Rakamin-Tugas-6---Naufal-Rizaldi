Feature: Login Aplikasi saucedemo

  Scenario: Success Login
    Given Halaman login saucedemo
    When Input Username
    And Input Password
    And Click login button
    Then User berada di dashboard

  Scenario: Failed Login
    Given Halaman login saucedemo
    When Input Username salah
    And Input Password
    And Click login button
    Then User mendapatkan pesan error