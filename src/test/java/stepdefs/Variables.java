package stepdefs;

import org.openqa.selenium.WebDriver;

public interface Variables {
    String TAMBAH_BUTTON = "Tambah";
    String ELEMENT_TAMBAH_BUTTON = "//div[@class='col-lg-2']/button[@class='btn btn-primary' and 1]";
    String ELEMENT_NAMA_SAMPAH_FIELD = "//div/input[@class='form-control' and 1]";
    String ELEMENT_TAMBAH_BUTTON_POPUP = "//div/input[@class='form-control' and 1]/../..//button[@class='btn btn-primary']";
    String ELEMENT_LIST_SAMPAH_FIRST_ROW = "//tr[2]/td[2]";
}
