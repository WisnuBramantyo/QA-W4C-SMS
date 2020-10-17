package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import defaultRequest.DefaultRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class kelolaSampah implements Variables {

    WebDriver driver;
    private static String BUTTON;

    @Given("^Browser \"([^\"]*)\" launched and Sistem Manajemen Sampah page opened$")
    public void browserLaunchedAndSistemManajemenSampahPageOpened(String arg0) {
        if (arg0.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/wisnubramantyo/Downloads/driver/chromedriver");
            driver = new ChromeDriver();
        }
        else {
            System.setProperty("webdriver.gecko.driver","/Users/wisnubramantyo/Downloads/driver/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://manajemensampah.herokuapp.com/sampah");
        driver.manage().window().maximize();
    }

    @And("^I click button \"([^\"]*)\"$")
    public void iClickButton(String arg0) {
        //conditional statement for which button is being clicked by user
        if (TAMBAH_BUTTON.equalsIgnoreCase(arg0)) {
            BUTTON = ELEMENT_TAMBAH_BUTTON;
        }
//        else if (CARA_LAIN_BUTTON.equalsIgnoreCase(arg0)) {
//            BUTTON = ELEMENT_CARA_LAIN_BUTTON;
//        }
//        else if (LANJUT_BUTTON.equalsIgnoreCase(arg0)) {
//            BUTTON = ELEMENT_LANJUT_BUTTON;
//        }

        //click selected button
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON)));
        driver.findElement(By.xpath(BUTTON)).click();
    }

    @When("^I add nama sampah \"([^\"]*)\" and kategori sampah \"([^\"]*)\"$")
    public void iAddNamaSampahAndKategoriSampah(String arg0, String arg1) throws Throwable {
        driver.findElement(By.xpath(ELEMENT_NAMA_SAMPAH_FIELD)).sendKeys(arg0);
        Select kategori = new Select(driver.findElement(By.name("kategori")));
        kategori.selectByVisibleText(arg1);
        driver.findElement(By.xpath(ELEMENT_TAMBAH_BUTTON_POPUP)).click();
    }

    @Then("^Sampah is successfully added$")
    public void sampahIsSuccessfullyAdded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(ELEMENT_LIST_SAMPAH_FIRST_ROW),"Kaleng"));
        driver.close();
    }
}
