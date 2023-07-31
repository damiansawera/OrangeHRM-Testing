package pages.admin_page;

import org.openqa.selenium.WebDriver;
import pages.CommonElements;

public class AdminPage {
    WebDriver driver;
    CommonElements commonElements;
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements();
    }

    public AdminAddUserPage addUserPage() {
        driver.findElement(commonElements.addButton).click();
        return new AdminAddUserPage(driver);
    }
}
