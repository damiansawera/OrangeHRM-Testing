package tests;

import com.github.javafaker.Faker;
import config.ConfigLoader;
import config.DockerSetup;
import config.DriverFactory;;
import io.qameta.allure.Attachment;
import junit.framework.TestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.login_page.LoginPage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {
    private WebDriver driver;
    protected HomePage homePage;
    protected Faker faker;

    @BeforeSuite
    public void startDocker() throws IOException, InterruptedException {
        ConfigLoader configLoader = new ConfigLoader("src/test/java/config/configuration.properties");
        boolean isRemote = configLoader.isRemote();
        if (isRemote) {
            DockerSetup.startDockerGrid();
        }

    }
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws IOException {
        faker = new Faker();
        driver = DriverFactory.getDriver(browser);
        new LoginPage(driver).Login("Admin", "admin123");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    void tearDown(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            // Your existing code to take a screenshot
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
                File destination = new File("src/main/resources/screenshots/" + result.getName() + "_" + timestamp + ".png");
                Files.move(screenshot.toPath(), destination.toPath());
                
                attachScreenshotToAllure(destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] attachScreenshotToAllure(File screenshot) {
        try {
            return Files.readAllBytes(screenshot.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
    @AfterSuite
    public void stopDocker() throws IOException, InterruptedException {
        ConfigLoader configLoader = new ConfigLoader("src/test/java/config/configuration.properties");
        boolean isRemote = configLoader.isRemote();
        if (isRemote) {
            DockerSetup.stopDockerGrid();
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
}
