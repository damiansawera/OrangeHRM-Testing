package pages.admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminAddUserPage {
    WebDriver driver;
    By dropdownMenu = By.className("oxd-select-text-input");
    By inputBox = By.xpath(".//input[@class='oxd-input oxd-input--active']");
    By employeeNameInputBox = By.xpath(".//input[@placeholder='Type for hints...']");
    By inputFieldErrorMessage = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
    By saveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private By selectField(String field) {
        return By.xpath("//div[contains(@class, 'oxd-grid-item--gutters') and .//label[text()='"+field+"']]");
    }
    private By selectOption(String option) {
        return By.xpath("//div[@class='oxd-select-option']//span[text()='"+option+"']");
    }
    public AdminAddUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectUserRole(String role) {
        WebElement userRoleSelectionBox = driver.findElement(selectField("User Role"));
        userRoleSelectionBox.findElement(dropdownMenu).click();
        userRoleSelectionBox.findElement(selectOption(role)).click();
    }

    public void addEmployeeName(String letter) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement employeeNameBox = driver.findElement(selectField("Employee Name"));
        employeeNameBox.findElement(employeeNameInputBox).sendKeys(letter);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-autocomplete-option']//span"))).click();
    }

    public void selectStatus(String status) {
        WebElement statusSelectionBox = driver.findElement(selectField("Status"));
        statusSelectionBox.findElement(dropdownMenu).click();
        statusSelectionBox.findElement(selectOption(status)).click();
    }

    public void addUsername(String Username) {
        WebElement usernameBox = driver.findElement(selectField("Username"));
        usernameBox.findElement(inputBox).sendKeys(Username);
    }

    public void addPassword(String password) {
        WebElement passwordBox = driver.findElement(selectField("Password"));
        passwordBox.findElement(inputBox).sendKeys(password);
    }

    public void confirmPassword(String password) {
        WebElement confirmPasswordBox = driver.findElement(selectField("Confirm Password"));
        confirmPasswordBox.findElement(inputBox).sendKeys(password);

    }

    public void saveUserButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(inputFieldErrorMessage)));
        driver.findElement(saveButton).click();
    }
}
