package pages.time_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimePage {
    WebDriver driver;
    private Logger logger;
    By timesheetsDropdownMenu = By.xpath("//li[contains(@class, 'oxd-topbar-body-nav-tab --parent --visited') and .//span[text()='Timesheets ']]");
    By myTimesheets = By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab-link') and text()='My Timesheets']");
    By employeeTimesheets = By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab-link') and text()='Employee Timesheets']");
    public TimePage(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
    }

    public TimesheetsDropdown timesheetDropdown() {
        WebElement dropdownElement = driver.findElement(timesheetsDropdownMenu);
        return new TimesheetsDropdown(dropdownElement);
    }
    public class TimesheetsDropdown {
        private final WebElement dropdownElement;
        public TimesheetsDropdown(WebElement dropdownElement) {
            this.dropdownElement = dropdownElement;
        }
        public MyTimesheetsPage selectMyTimesheets() {
            dropdownElement.click();
            WebElement myTimesheetsOption = dropdownElement.findElement(myTimesheets);
            myTimesheetsOption.click();
            return new MyTimesheetsPage(driver, logger);
        }
        public  EmployeeTimesheetsPage selectEmployeeTimesheets() {
            dropdownElement.click();
            WebElement employeeTimesheetsOption = dropdownElement.findElement(employeeTimesheets);
            employeeTimesheetsOption.click();
            return new EmployeeTimesheetsPage(driver, logger);

        }
    }
}
