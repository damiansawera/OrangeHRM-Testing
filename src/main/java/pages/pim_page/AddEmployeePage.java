package pages.pim_page;

import org.openqa.selenium.WebDriver;
import pages.CommonElements;

public class AddEmployeePage {
    WebDriver driver;
    CommonElements commonElements;
    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements();
    }

    public void setFirstName(String firstName) {
        commonElements.setFirstName(driver, firstName);
    }
    public void setLastName(String lastName) {
        commonElements.setLastName(driver, lastName);
    }
    public void saveNewEmployeeButton() {
        commonElements.clickSaveButton(driver);
    }
}
