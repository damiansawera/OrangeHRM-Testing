package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.login_page.LoginPage;
import utility.AllureTestListener;

@Listeners({AllureTestListener.class})
public class LoginTests extends TestBase {
    @Test(description = "User is logged in successfully")
    public void loggedInSuccessfully() {
        Assert.assertTrue(homePage.isLoggedIn());
    }
}
