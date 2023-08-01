package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.login_page.LoginPage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {
    private WebDriver driver;
    protected HomePage homePage;
    protected Faker faker;

    @BeforeSuite
    public void startDockerGrid() throws IOException, InterruptedException {
        String[] startDocker = { "cmd", "/c", "start", "docker\\start_docker.bat" };
        ProcessBuilder processBuilder = new ProcessBuilder(startDocker);
        processBuilder.start();
        Thread.sleep(15000);
    }
    @BeforeMethod
    @Parameters("browser")
    public synchronized void setUp(String browser) throws MalformedURLException {
        faker = new Faker();
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), edgeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.edgedriver().setup();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        new LoginPage(driver).Login("Admin", "admin123");
        homePage = new HomePage(driver);
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
    public void stopDockerGrid() throws IOException, InterruptedException {
        String[] stopDocker = { "cmd", "/c", "start", "docker\\stop_docker.bat" };
        String[] killTask = { "taskkill", "/f", "/im", "cmd.exe" };
        ProcessBuilder processBuilder1 = new ProcessBuilder(stopDocker);
        processBuilder1.start();
        Thread.sleep(6000);

        ProcessBuilder processBuilder2 = new ProcessBuilder(killTask);
        processBuilder2.start();
    }
}
