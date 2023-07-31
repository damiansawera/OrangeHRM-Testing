package tests;

import org.testng.annotations.Test;
import pages.recruitment_page.RecruitmentPage;

public class RecruitmentTests extends TestBase {

    @Test
    public void successfullyAddCandidate() {
        RecruitmentPage recruitmentPage = homePage.goToRecruitmentPage();
        recruitmentPage.addFirstName();
        recruitmentPage.addLastName();
        recruitmentPage.selectVacancy();
        recruitmentPage.addEmail();
        recruitmentPage.addContactNumber();
        recruitmentPage.addResume();
        recruitmentPage.clickSaveButton();

    }
}
