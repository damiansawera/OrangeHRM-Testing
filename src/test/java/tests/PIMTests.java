package tests;

import org.testng.annotations.Test;
import pages.pim_page.AddEmployeePage;
import pages.pim_page.PimPage;

public class PIMTests extends TestBase {

    @Test(description = "New employee is successfully added to the PIM page")
    public void addNewEmployee() {
    PimPage pimPage = homePage.goToPimPage();
    AddEmployeePage addEmployeePage = pimPage.addNewEmployeePage();
    addEmployeePage.setFirstName(faker.name().firstName());
    addEmployeePage.setLastName(faker.name().lastName());
    addEmployeePage.saveNewEmployeeButton();
    }
}
