package pages.login_page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private Logger logger;
    By loginButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    By usernameBox = By.name("username");
    By passwordBox = By.name("password");

    public LoginPage(WebDriver driver, Logger logger) {
        this.logger = logger;
        this.driver = driver;
    }

    public void Login(String username, String password) {
        logger.info("Logging with username: " + username + " and password: " + password);
        driver.findElement(usernameBox).sendKeys(username);
        driver.findElement(passwordBox).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
