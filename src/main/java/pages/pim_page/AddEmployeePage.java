package pages.pim_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CommonElements;

public class AddEmployeePage {
    WebDriver driver;
    private Logger logger;
    CommonElements commonElements;
    public AddEmployeePage(WebDriver driver, Logger logger) {
        this.logger = logger;
        this.driver = driver;
        this.commonElements = new CommonElements();
    }

    public void setFirstName(String firstName) {
        logger.info("Setting first name: " + firstName);
        commonElements.setFirstName(driver, firstName);
    }
    public void setLastName(String lastName) {
        logger.info("Setting last name: " + lastName);
        commonElements.setLastName(driver, lastName);
    }
    public void saveNewEmployeeButton() {
        logger.info("Saving new employee");
        commonElements.clickSaveButton(driver);
    }
}
