package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonElements {
    WebDriver driver;

    public CommonElements(WebDriver driver) {
        this.driver = driver;
    }
    public By dropdownMenu = By.className("oxd-select-text-input");
    public By inputBox = By.xpath(".//input[@class='oxd-input oxd-input--active']");
    public By saveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    public By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    public By firstNameBox = By.name("firstName");
    public By lastNameBox = By.name("lastName");
    public By selectActivityDropdown = By.xpath(".//div[contains(@class, 'oxd-select-text-input') and text()='-- Select --']");
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
}
