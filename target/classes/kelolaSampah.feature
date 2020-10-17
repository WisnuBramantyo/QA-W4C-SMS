Feature: Kelola Sampah

  Scenario: Tambah Sampah
    Given Browser "Chrome" launched and Sistem Manajemen Sampah page opened
    And I click button "Tambah"
    When I add nama sampah "Kaleng" and kategori sampah "Logam"
    Then Sampah is successfully added

