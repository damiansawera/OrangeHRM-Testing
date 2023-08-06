package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Log;

import static org.testng.Reporter.getCurrentTestResult;

public class LoginTests extends TestBase {
    @Test(description = "User is logged in successfully")
    public void loggedInSuccessfully() {
        String testCaseName = getCurrentTestName(getCurrentTestResult());
        Log.startTestCase(testCaseName);

        Assert.assertTrue(homePage.isLoggedIn());
        Log.info("Logged in successfully.");
        Log.endTestCase(testCaseName);
    }
}
