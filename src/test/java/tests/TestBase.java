package tests;

import com.github.javafaker.Faker;
import config.ConfigLoader;
import config.DockerSetup;
import config.DriverFactory;;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    protected WebDriver driver;
    protected HomePage homePage;
    protected Faker faker;
    protected Logger logger;

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
    public void setUp(@Optional("chrome") String browser) throws IOException {
        faker = new Faker();
        logger = LogManager.getLogger(TestBase.class);
        driver = DriverFactory.getDriver(browser);
        new LoginPage(driver, logger).Login("Admin", "admin123");
        homePage = new HomePage(driver, logger);
    }

    @AfterMethod
    void tearDown(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
                Files.move(screenshot.toPath(), new File("src/main/resources/screenshots/" + result.getName() + "_" + timestamp + ".png").toPath());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        driver.quit();
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
