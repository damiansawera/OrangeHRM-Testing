package pages.pim_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommonElements;

public class PimPage {
    WebDriver driver;
    CommonElements commonElements;

    public PimPage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements(driver);
    }

    public AddEmployeePage addNewEmployeePage() {
        driver.findElement(commonElements.addButton).click();
        return new AddEmployeePage(driver);
    }
}
