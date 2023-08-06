package pages.admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonElements;
import utility.Log;

import java.time.Duration;

public class AdminAddUserPage {
    WebDriver driver;
    CommonElements commonElements;
    By employeeNameInputBox = By.xpath(".//input[@placeholder='Type for hints...']");
    By inputFieldErrorMessage = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
    By firstAutocompleteOption = By.xpath(".//div[@class='oxd-autocomplete-dropdown --positon-bottom']//span");
    public AdminAddUserPage(WebDriver driver) {
        this.driver = driver;this.commonElements = new CommonElements();
    }

    public void selectUserRole(String role) {

        WebElement userRoleSelectionBox = driver.findElement(commonElements.selectField("User Role"));
        userRoleSelectionBox.findElement(commonElements.dropdownMenu).click();
        userRoleSelectionBox.findElement(commonElements.selectOption(role)).click();
    }

    public void setEmployeeName(String letter) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement employeeNameBox = driver.findElement(commonElements.selectField("Employee Name"));
        employeeNameBox.findElement(employeeNameInputBox).sendKeys(letter);
        wait.until(ExpectedConditions.presenceOfElementLocated(firstAutocompleteOption));
        wait.until(ExpectedConditions.elementToBeClickable(firstAutocompleteOption)).click();
        Log.info("Selecting employee name: " + employeeNameBox.findElement(employeeNameInputBox).getText());
    }

    public void selectStatus(String status) {
        Log.info("Selecting status: " + status);
        WebElement statusSelectionBox = driver.findElement(commonElements.selectField("Status"));
        statusSelectionBox.findElement(commonElements.dropdownMenu).click();
        statusSelectionBox.findElement(commonElements.selectOption(status)).click();
    }

    public void setUsername(String username) {
        Log.info("Setting username: " + username);
        WebElement usernameBox = driver.findElement(commonElements.selectField("Username"));
        usernameBox.findElement(commonElements.inputBox).sendKeys(username);
    }

    public void setPassword(String password) {
        Log.info("Setting password: " + password);
        WebElement passwordBox = driver.findElement(commonElements.selectField("Password"));
        passwordBox.findElement(commonElements.inputBox).sendKeys(password);
    }

    public void confirmPassword(String password) {
        Log.info("Confirming password");
        WebElement confirmPasswordBox = driver.findElement(commonElements.selectField("Confirm Password"));
        confirmPasswordBox.findElement(commonElements.inputBox).sendKeys(password);

    }

    public void saveUserButton() {
        Log.info("Saving new user");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(inputFieldErrorMessage)));
        } catch (NoSuchElementException e) {
        }
        commonElements.clickSaveButton(driver);
    }
}
