package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.time_page.EditTimesheetsPage;
import pages.time_page.EmployeeTimesheetsPage;
import pages.time_page.MyTimesheetsPage;
import pages.time_page.TimePage;
import utility.AllureTestListener;

@Listeners({AllureTestListener.class})
public class TimeTests extends TestBase {

    @Test(description = "New record with comment in timesheet of currently logged in user is added")
    public void addTimesheet() {
        String projectName = "The Coca-Cola Company - Coke - Phase 1";
        String activity = "Administration";
        int timeInHours = faker.number().numberBetween(1,24);
        String comment = faker.lorem().sentence();

        TimePage timePage = homePage.goToTimePage();
        MyTimesheetsPage myTimesheets = timePage.timesheetDropdown().selectMyTimesheets();
        EditTimesheetsPage editTimesheets = myTimesheets.clickEditTimesheetsButton();
        editTimesheets.clearFirstRow();
        editTimesheets.addRow();
        editTimesheets.selectProject(projectName);
        editTimesheets.selectActivity(activity);
        editTimesheets.addTimeInMondayColumn(String.valueOf(timeInHours));
        editTimesheets.addCommentInMondayColumn(comment);
        editTimesheets.saveTimesheet();
    }

    @Test
    public void verifyThatPendingTimesheetsExist() throws InterruptedException {
        TimePage timePage = homePage.goToTimePage();
        EmployeeTimesheetsPage employeeTimesheets = timePage.timesheetDropdown().selectEmployeeTimesheets();

        Assert.assertTrue(employeeTimesheets.hasPendingTimesheets());
    }
}
