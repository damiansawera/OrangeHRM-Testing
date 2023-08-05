package pages.pim_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CommonElements;

public class PimPage {
    WebDriver driver;
    private Logger logger;
    CommonElements commonElements;

    public PimPage(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        this.commonElements = new CommonElements();
    }

    public AddEmployeePage addNewEmployeePage() {
        logger.info("Opening form to add new employee");
        driver.findElement(commonElements.addButton).click();
        return new AddEmployeePage(driver, logger);
    }
}
