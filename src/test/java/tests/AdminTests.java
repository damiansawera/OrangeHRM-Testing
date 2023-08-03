package tests;

import enums.Roles;
import enums.Status;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.admin_page.AdminAddUserPage;
import pages.admin_page.AdminPage;
import utility.AllureTestListener;

@Listeners({AllureTestListener.class})
public class AdminTests extends TestBase {
    @Test(description = "User is created and role is set to Admin")
    public void addAdminUser() {
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
    }
}



