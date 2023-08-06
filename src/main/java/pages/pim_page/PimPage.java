package pages.pim_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.CommonElements;
import utility.Log;

public class PimPage {
    WebDriver driver;
    CommonElements commonElements;

    public PimPage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements();
    }

    public AddEmployeePage addNewEmployeePage() {
        Log.info("Opening form to add new employee");
        driver.findElement(commonElements.addButton).click();
        return new AddEmployeePage(driver);
    }
}
