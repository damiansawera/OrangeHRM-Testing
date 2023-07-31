package pages.time_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeTimesheetsPage {
    WebDriver driver;
    By recordsFound = By.xpath("//span[@class='oxd-text oxd-text--span']");

    public EmployeeTimesheetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean hasPendingTimesheets() {
        if(!driver.findElement(recordsFound).getText().equals("No Records Found"))
            return true;
        return false;
    }
}
