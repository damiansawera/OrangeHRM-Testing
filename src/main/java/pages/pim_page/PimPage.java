package pages.pim_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage {
    WebDriver driver;
    By addUserButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

    public PimPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddEmployeePage addNewEmployeePage() {
        driver.findElement(addUserButton).click();
        return new AddEmployeePage(driver);
    }
}
