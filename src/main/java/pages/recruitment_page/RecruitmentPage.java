package pages.recruitment_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.slf4j.ILoggerFactory;
import pages.CommonElements;

public class RecruitmentPage {
    WebDriver driver;
    private Logger logger;
    CommonElements commonElements;
    public RecruitmentPage(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        this.commonElements = new CommonElements();
    }
    public AddCandidatePage clickAddCandidateButton() {
        logger.info("Opening form to add new candidate");
        driver.findElement(commonElements.addButton).click();
        return new AddCandidatePage(driver, logger);
    }
}
