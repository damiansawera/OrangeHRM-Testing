package pages.recruitment_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonElements;

public class AddCandidatePage {
    WebDriver driver;
    CommonElements commonElements;
    By uploadFileInput = By.xpath("//input[@class='oxd-file-input']");

    public AddCandidatePage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements();
    }
    public void setFirstName(String firstName) {
        commonElements.setFirstName(driver, firstName);
    }

    public void setLastName(String lastName) {
        commonElements.setLastName(driver, lastName);
    }

    public void selectVacancy(String vacancy) {
        WebElement vacancyField = driver.findElement(commonElements.selectField("Vacancy"));
        vacancyField.findElement(commonElements.selectDropdown).click();
        vacancyField.findElement(commonElements.selectOption(vacancy)).click();

    }

    public void setEmail(String email) {
        WebElement emailField = driver.findElement(commonElements.selectField("Email"));
        emailField.findElement(commonElements.inputBox).sendKeys(email);
    }

    public void setContactNumber(String contactNumber) {
        WebElement contactNumberField = driver.findElement(commonElements.selectField("Contact Number"));
        contactNumberField.findElement(commonElements.inputBox).sendKeys(contactNumber);
    }

    public void setResume(String resume) {
        driver.findElement(uploadFileInput).sendKeys(resume);
    }

    public void clickSaveButton() {
        commonElements.clickSaveButton(driver);
    }

}
