package pages.time_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyTimesheetsPage {
    WebDriver driver;
    private By selectButton(String button) {
        return By.xpath("//button[contains(@class, 'oxd-button oxd-button--medium oxd-button--ghost') and text()='"+button+"']");
    }

    public MyTimesheetsPage(WebDriver driver) {
        this.driver = driver;
    }

    public EditTimesheetsPage clickEditTimesheetsButton() {
        driver.findElement(selectButton(" Edit ")).click();
        return new EditTimesheetsPage(driver);
    }
}
