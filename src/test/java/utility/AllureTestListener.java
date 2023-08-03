package utility;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import tests.TestBase;

public class AllureTestListener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(byte[] screenshot) {
        return screenshot;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((TestBase) testClass).getDriver();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshotPNG(screenshot);
    }
}
