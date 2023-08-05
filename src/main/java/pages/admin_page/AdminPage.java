package pages.admin_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CommonElements;

public class AdminPage {
    WebDriver driver;
    private Logger logger;
    CommonElements commonElements;
    public AdminPage(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        this.commonElements = new CommonElements();
    }

    public AdminAddUserPage addUserPage() {
        logger.info("Opening form to add new user");
        driver.findElement(commonElements.addButton).click();
        return new AdminAddUserPage(driver, logger);
    }
}
