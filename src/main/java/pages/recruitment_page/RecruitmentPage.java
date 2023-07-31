package pages.recruitment_page;

import org.openqa.selenium.WebDriver;
import pages.CommonElements;

public class RecruitmentPage {
    WebDriver driver;
    CommonElements commonElements;
    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements();
    }
    public AddCandidatePage clickAddCandidateButton() {
        driver.findElement(commonElements.addButton).click();
        return new AddCandidatePage(driver);
    }
}
