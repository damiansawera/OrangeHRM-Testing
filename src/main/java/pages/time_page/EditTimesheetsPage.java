package pages.time_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EditTimesheetsPage {
    WebDriver driver;
    By saveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    By inputBox = By.xpath(".//input[@class='oxd-input oxd-input--active']");
    By timesheetTable = By.xpath("//table[@class='orangehrm-timesheet-table --editable']");
    By selectActivityDropdown = By.xpath("//div[contains(@class, 'oxd-select-text-input') and text()='-- Select --']");
    By projectInputBox = By.xpath(".//input[@placeholder='Type for hints...']");
    By commentButton = By.xpath("//button[@class='oxd-icon-button oxd-icon-button--secondary orangehrm-timesheet-icon-comment']");
    By commentInputBox = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    private By selectOption(String option) {
        return By.xpath("//div[@class='oxd-select-option']//span[text()='"+option+"']");
    }
    private By selectAutocompleteOption(String autocompleteOption) {
        return By.xpath("//div[@class='oxd-autocomplete-option']//span[text()='"+autocompleteOption+"']");
    }


    public EditTimesheetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProject(String projectName) {
        String projectShortName = "coca";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(projectInputBox).sendKeys(projectShortName);
        wait.until(ExpectedConditions.elementToBeClickable(selectAutocompleteOption(projectName))).click();
    }

    public void selectActivity(String activity) {
       WebElement activityDropdown = driver.findElement(selectActivityDropdown);
       activityDropdown.click();
       activityDropdown.findElement(selectOption(activity)).click();
    }

    public void addTimeInMondayColumn(String time) {
        WebElement table = driver.findElement(timesheetTable);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement secondRow = rows.get(1);
        List<WebElement> cells = secondRow.findElements(By.tagName("td"));
        WebElement thirdCell = cells.get(2);
        WebElement inputField = thirdCell.findElement(inputBox);
        inputField.sendKeys(time);
    }

    public void addCommentInMondayColumn(String comment) {
        driver.findElement(commentButton).click();
        driver.findElement(commentInputBox).sendKeys(comment);
    }

    public void saveTimesheet() {
        driver.findElement(saveButton).click();
    }
}
