package steps;

import config.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.Certificate;

import static org.junit.Assert.*;

public class CertSteps extends BaseClass {
    static final String mainUrl = "https://certificate.ithillel.ua/";
    Certificate certificatePage = PageFactory.initElements(driver, Certificate.class);

    static {
        if (driver == null) {
            BaseClass.BeforParent();
        }
    }

    @When("User opens certificates page")
    public void userOpensCertificatesPage() {
        driver.get(mainUrl);
        assertEquals(mainUrl, driver.getCurrentUrl());
    }

    @And("Select check button")
    public void selectCheckButton() {
        certificatePage.getCheckButton().click();
    }

    @And("Enter certificate identificator {string}")
    public void enterCertificateIdentificator(String arg0) {
        certificatePage.fillCertIDField(arg0);
    }

    @Then("Verify than certificate is {string}")
    public void verifyThanCertificateIs(String expected) throws Exception {
        assertEquals(Boolean.valueOf(expected),certificatePage.checkcertifChekForm());
    }
}
