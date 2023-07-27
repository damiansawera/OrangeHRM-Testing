package pages.time_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimePage {
    WebDriver driver;
    public TimePage(WebDriver driver) {
        this.driver = driver;
    }

    public TimesheetsDropdown timesheetDropdown() {
        WebElement dropdownElement = driver.findElement(By.xpath("//li[contains(@class, 'oxd-topbar-body-nav-tab --parent --visited') and .//span[text()='Timesheets ']]"));
        return new TimesheetsDropdown(dropdownElement);
    }
    public class TimesheetsDropdown {
        private final WebElement dropdownElement;
        public TimesheetsDropdown(WebElement dropdownElement) {
            this.dropdownElement = dropdownElement;
        }
        public MyTimesheetsPage selectMyTimesheets() {
            dropdownElement.click();
            WebElement myTimesheetsOption = dropdownElement.findElement(By.xpath("//a[contains(@class, 'oxd-topbar-body-nav-tab-link') and text()='My Timesheets']"));
            myTimesheetsOption.click();
            return new MyTimesheetsPage(driver);
        }
    }
}
