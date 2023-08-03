package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.login_page.LoginPage;

public class LoginTests extends TestBase {

    @Test(description = "User is logged in successfully")
    public void loggedInSuccessfully() {
        Assert.assertTrue(homePage.isLoggedIn());
    }
}
