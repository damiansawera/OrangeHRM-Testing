package tests;

import enums.Roles;
import enums.Status;
import org.testng.annotations.Test;
import pages.admin_page.AdminAddUserPage;
import pages.admin_page.AdminPage;

public class AdminTests extends TestBase {
    @Test
    public void addAdminUser() {
        String role = Roles.ADMIN.getRoleName();
        String username = faker.name().username();
        String password = faker.internet().password();
        AdminPage adminPage = navigator.goToAdminPage();
        AdminAddUserPage adminAddUserPage = adminPage.addUserPage();
        adminAddUserPage.selectUserRole(role);
        adminAddUserPage.addEmployeeName("a");
        adminAddUserPage.selectStatus(Status.ENABLED.getStatusName());
        adminAddUserPage.addUsername(username);
        adminAddUserPage.addPassword(password);
        adminAddUserPage.confirmPassword(password);
        adminAddUserPage.saveUserButton();

        //TODO: Assertion
    }
}



