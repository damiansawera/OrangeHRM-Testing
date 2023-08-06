package pages.pim_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CommonElements;
import utility.Log;

public class AddEmployeePage {
    WebDriver driver;
    CommonElements commonElements;
    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements();
    }

    public void setFirstName(String firstName) {
        Log.info("Setting first name: " + firstName);
        commonElements.setFirstName(driver, firstName);
    }
    public void setLastName(String lastName) {
        Log.info("Setting last name: " + lastName);
        commonElements.setLastName(driver, lastName);
    }
    public void saveNewEmployeeButton() {
        Log.info("Saving new employee");
        commonElements.clickSaveButton(driver);
    }
}
