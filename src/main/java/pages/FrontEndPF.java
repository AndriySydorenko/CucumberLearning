package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class FrontEndPF {
    @FindBy(xpath = "//span[@class=\"course-descriptor_header-text\"]")
    WebElement pageTitle;
    @FindBy(xpath = "//span[@class=\"course-rating_average\"]")
    WebElement courseRating;
    @FindBy(xpath = "//div[@class=\"introduction-info_content introduction-info-redactor\"]")
    WebElement courseDesc;
    private final WebDriver driver;

    public FrontEndPF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCourseTitle() {
        return pageTitle.getText();
    }

    public String getCourseRate() {
        return courseRating.getText();
    }

    public String getCourseDescription() {
        return courseDesc.getText();
    }

    public List<String> getListCoachesNames() {

        Util.scrollToElementVisibilityOf(driver, By.id("coachesShowAllButton"));
        driver.findElement(By.id("coachesShowAllButton")).click();
        List<WebElement> l = driver.findElements(By.xpath("//ul[@class=\"coach-list coaches_list\"]//li//p[@class=\"coach-card_name\"]"));
        List<String> teachersList = new ArrayList<>();
        for (WebElement element : l) {
            teachersList.add(element.getText());
        }
        return teachersList;
    }

}
