package tests;

import enums.Roles;
import enums.Status;
import org.testng.annotations.Test;
import pages.admin_page.AdminAddUserPage;
import pages.admin_page.AdminPage;
import utility.Log;

import static org.testng.Reporter.getCurrentTestResult;

public class AdminTests extends TestBase {
    @Test(description = "User is created and role is set to Admin")
    public void addAdminUser() {
        String testCaseName = getCurrentTestName(getCurrentTestResult());
        Log.startTestCase(testCaseName);
        String role = Roles.ADMIN.getRoleName();
        String username = faker.name().username();
        String password = faker.internet().password();
        String status = Status.ENABLED.getStatusName();
        AdminPage adminPage = homePage.goToAdminPage();
        AdminAddUserPage adminAddUserPage = adminPage.addUserPage();
        adminAddUserPage.selectUserRole(role);
        adminAddUserPage.setEmployeeName("a");
        adminAddUserPage.selectStatus(status);
        adminAddUserPage.setUsername(username);
        adminAddUserPage.setPassword(password);
        adminAddUserPage.confirmPassword(password);
        adminAddUserPage.saveUserButton();
        Log.endTestCase(testCaseName);
    }
}



