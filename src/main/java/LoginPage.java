import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void Login(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
    }
    public String getCurrentURL() {
       return driver.getCurrentUrl();
    }
}
