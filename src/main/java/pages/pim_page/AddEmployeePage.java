package pages.pim_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {
    WebDriver driver;
    By saveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    By firstNameBox = By.name("firstName");
    By lastNameBox = By.name("lastName");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameBox).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameBox).sendKeys(lastName);
    }

    public void saveNewEmployeeButton() {
        driver.findElement(saveButton).click();
    }
}
