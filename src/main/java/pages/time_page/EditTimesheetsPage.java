package pages.time_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonElements;
import utility.Log;

import java.time.Duration;
import java.util.List;

public class EditTimesheetsPage {
    WebDriver driver;
    CommonElements commonElements;
    By timesheetTable = By.xpath("//table[@class='orangehrm-timesheet-table --editable']");
    By projectInputBox = By.xpath(".//input[@placeholder='Type for hints...']");
    By commentButton = By.xpath(".//button[@class='oxd-icon-button oxd-icon-button--secondary orangehrm-timesheet-icon-comment']");
    By commentInputBox = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    By addNewRow = By.xpath("//i[@class='oxd-icon bi-plus']");
    private WebElement getCellInTimesheetTable(int column) {
        WebElement table = driver.findElement(timesheetTable);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement emptyRow = rows.get(rows.size()-2);
        List<WebElement> cells = emptyRow.findElements(By.tagName("td"));
        WebElement cell = cells.get(column);
        return cell;
    }

    public EditTimesheetsPage(WebDriver driver) {
        this.driver = driver;
        this.commonElements = new CommonElements();
    }

    public void selectProject(String projectName) {
        Log.info("Selecting project: " + projectName);
        String projectShortName = "coca";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement projectInputField = getCellInTimesheetTable(0).findElement(projectInputBox);
        projectInputField.sendKeys(projectShortName);
        wait.until(ExpectedConditions.elementToBeClickable(commonElements.selectAutocompleteOption(projectName))).click();
    }

    public void selectActivity(String activity) {
        Log.info("Selecting activity: " + activity);
       WebElement activityDropdown = getCellInTimesheetTable(1).findElement(commonElements.selectDropdown);
       activityDropdown.click();
       activityDropdown.findElement(commonElements.selectOption(activity)).click();
    }

    public void addTimeInMondayColumn(String time) {
        Log.info("Adding time in monday column: " + time);
        WebElement inputField = getCellInTimesheetTable(2).findElement(commonElements.inputBox);
        inputField.sendKeys(time);
    }

    public void addCommentInMondayColumn(String comment) {
        Log.info("Adding comment in monday column: " + comment);
        WebElement addCommentButton = getCellInTimesheetTable(2).findElement(commentButton);
        addCommentButton.click();
        driver.findElement(commentInputBox).sendKeys(comment);
    }

    public void saveTimesheet() {
        Log.info("Saving timesheet");
        driver.findElement(commonElements.saveButton).click();

    }

    public void addRow() {
        Log.info("Adding new row");
        driver.findElement(addNewRow).click();

    }

    public void clearFirstRow() {
        Log.info("Clearing first row");
        WebElement clearButton = driver.findElement(commonElements.clearButtonIcon);
        clearButton.click();
    }
}
