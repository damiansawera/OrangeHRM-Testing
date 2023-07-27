package pages.admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    WebDriver driver;
    By addUserButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public AdminAddUserPage addUserPage() {
        driver.findElement(addUserButton).click();
        return new AdminAddUserPage(driver);
    }

}
