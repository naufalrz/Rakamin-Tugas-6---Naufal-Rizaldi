Feature: Checkout Aplikasi saucedemo

  Scenario: Checkout aplikasi saucedemo
    Given Halaman beranda soucedemo1
    When Input Username benar1
    And Input Password benar1
    And Click login button benar1
    And User berada di dashboard benar1
    And User click button keranjang benar1
    And User click button checkout
    And User input First Name
    And User input Last Name
    And User input zip code
    And User click continue
    And User click finish
    Then User mendapat pemberitahuan berhasil
