package pages.login_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Log;

public class LoginPage {
    private WebDriver driver;
    By loginButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    By usernameBox = By.name("username");
    By passwordBox = By.name("password");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Login(String username, String password) {
        Log.info("Logging with username: " + username + " and password: " + password);
        driver.findElement(usernameBox).sendKeys(username);
        driver.findElement(passwordBox).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
