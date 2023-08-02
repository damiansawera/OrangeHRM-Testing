package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonElements {
    public CommonElements() {
    }
    public By dropdownMenu = By.className("oxd-select-text-input");
    public By inputBox = By.xpath(".//input[@class='oxd-input oxd-input--active']");
    public By saveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    public By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    public By firstNameBox = By.name("firstName");
    public By lastNameBox = By.name("lastName");
    public By selectDropdown = By.xpath(".//div[contains(@class, 'oxd-select-text-input') and text()='-- Select --']");
    public By clearButtonIcon = By.xpath("//i[@class='oxd-icon bi-trash']");


    public By selectField(String field) {
        return By.xpath("//div[contains(@class, 'oxd-grid-item--gutters') and .//label[text()='"+field+"']]");
    }
    public By selectOption(String option) {
        return By.xpath("//div[@class='oxd-select-option']//span[text()='"+option+"']");
    }
    public By selectAutocompleteOption(String autocompleteOption) {
        return By.xpath("//div[@class='oxd-autocomplete-option']//span[text()='"+autocompleteOption+"']");
    }
    public void setFirstName(WebDriver driver, String firstName) {
        driver.findElement(firstNameBox).sendKeys(firstName);
    }
    public void setLastName(WebDriver driver, String lastName) {
        driver.findElement(lastNameBox).sendKeys(lastName);
    }
    public void clickSaveButton(WebDriver driver) {
        WebElement saveButtonElement = driver.findElement(saveButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", saveButtonElement);
    }
}
