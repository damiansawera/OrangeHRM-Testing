package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.login_page.LoginPage;

import java.time.Duration;

public class TestBase {
    private WebDriver driver;
    protected HomePage homePage;
    protected Faker faker;

    @BeforeMethod
    void setUp() {
        faker = new Faker();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        new LoginPage(driver).Login("Admin", "admin123");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
