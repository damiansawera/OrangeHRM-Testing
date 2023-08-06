package pages.recruitment_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonElements;
import utility.Log;

public class AddCandidatePage {
    WebDriver driver;
    CommonElements commonElements;
    By uploadFileInput = By.xpath("//input[@class='oxd-file-input']");

    public AddCandidatePage(WebDriver driver) {
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

    public void selectVacancy(String vacancy) {
        Log.info("Selecting vacancy: " + vacancy);
        WebElement vacancyField = driver.findElement(commonElements.selectField("Vacancy"));
        vacancyField.findElement(commonElements.selectDropdown).click();
        vacancyField.findElement(commonElements.selectOption(vacancy)).click();

    }

    public void setEmail(String email) {
        Log.info("Setting email: " + email);
        WebElement emailField = driver.findElement(commonElements.selectField("Email"));
        emailField.findElement(commonElements.inputBox).sendKeys(email);
    }

    public void setContactNumber(String contactNumber) {
        Log.info("Setting contact number: " + contactNumber);
        WebElement contactNumberField = driver.findElement(commonElements.selectField("Contact Number"));
        contactNumberField.findElement(commonElements.inputBox).sendKeys(contactNumber);
    }

    public void setResume(String resume) {
        Log.info("Uploading resume");
        driver.findElement(uploadFileInput).sendKeys(resume);
    }

    public void clickSaveButton() {
        Log.info("Saving new candidate");
        commonElements.clickSaveButton(driver);
    }

}
