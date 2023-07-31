package pages.pim_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommonElements;

public class AddEmployeePage {
    WebDriver driver;
    CommonElements commonElements;
    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements(driver);
    }

    public void setFirstName(String firstName) {
        driver.findElement(commonElements.firstNameBox).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(commonElements.lastNameBox).sendKeys(lastName);
    }

    public void saveNewEmployeeButton() {
        driver.findElement(commonElements.saveButton).click();
    }
}
