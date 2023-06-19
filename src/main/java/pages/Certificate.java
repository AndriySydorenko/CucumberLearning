package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Certificate {
    @FindBy(xpath = "//input[@name=\"certificate\"]")
    WebElement certID;
    @FindBy(xpath = "//button[@class=\"btn btn-submit -submit certificate-check_submit\"]")
    WebElement checkButton;
    @FindBy(id = "certificateCheckForm")
    WebElement checkFormMassage;

    public WebElement getCheckButton() {
        return checkButton;
    }


    public void fillCertIDField(String certNumber){
        certID.sendKeys(certNumber);
    }

    private final WebDriver driver;

    public Certificate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkcertifChekForm() throws Exception {
        System.out.println(checkFormMassage.getAttribute("class"));

        int i = 0;
        boolean result=false;
        while (true) {
            if (checkLinkCertificate()) {
                result = true;
                break;
            }
            if (checkFormMassage.getAttribute("class").contains("invalid")) {
                result = false;
                break;
            }

            try {
                Thread.sleep(1000);
                i++;
                if (i > 10) {
                    throw new Exception("Out of time wait certificate cheker");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private boolean checkLinkCertificate() {
        return driver.getCurrentUrl().contains("view");
    }
}
