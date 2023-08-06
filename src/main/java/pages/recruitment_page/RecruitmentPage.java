package pages.recruitment_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.slf4j.ILoggerFactory;
import pages.CommonElements;
import utility.Log;

public class RecruitmentPage {
    WebDriver driver;
    CommonElements commonElements;
    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements();
    }
    public AddCandidatePage clickAddCandidateButton() {
        Log.info("Opening form to add new candidate");
        driver.findElement(commonElements.addButton).click();
        return new AddCandidatePage(driver);
    }
}
