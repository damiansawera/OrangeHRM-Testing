package pages.admin_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CommonElements;
import utility.Log;

public class AdminPage {
    WebDriver driver;
    CommonElements commonElements;
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements();
    }

    public AdminAddUserPage addUserPage() {
        Log.info("Opening form to add new user");
        driver.findElement(commonElements.addButton).click();
        return new AdminAddUserPage(driver);
    }
}
