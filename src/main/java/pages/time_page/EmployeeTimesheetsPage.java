package pages.time_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class EmployeeTimesheetsPage {
    WebDriver driver;
    By recordsFound = By.xpath("//span[@class='oxd-text oxd-text--span']");

    public EmployeeTimesheetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean hasPendingTimesheets() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        Function<WebDriver, Boolean> condition = driver -> {
            WebElement element = driver.findElement(recordsFound);
            return !element.getText().equals("No Records Found");
        };

        try {
            return wait.until(condition);
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
