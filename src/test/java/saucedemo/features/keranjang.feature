Feature: Keranjang Aplikasi saucedemo

  Scenario: Keranjang aplikasi saucedemo
    Given Halaman beranda soucedemo
    When Input Username benar
    And Input Password benar
    And Click login button benar
    And User berada di dashboard benar
    And User click button keranjang benar
    Then User berada di halaman keranjang benar