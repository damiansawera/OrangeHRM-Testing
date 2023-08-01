package tests;

import org.testng.annotations.Test;
import pages.recruitment_page.AddCandidatePage;
import pages.recruitment_page.RecruitmentPage;

public class RecruitmentTests extends TestBase {

    @Test
    public void successfullyAddCandidate()  {
        String vacancy = "Senior QA Lead";

        String resume = "src/main/resources/resume.pdf";
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String contactNumber = faker.phoneNumber().subscriberNumber();

        RecruitmentPage recruitmentPage = homePage.goToRecruitmentPage();
        AddCandidatePage addCandidatePage = recruitmentPage.clickAddCandidateButton();
        addCandidatePage.setFirstName(firstName);
        addCandidatePage.setLastName(lastName);
        addCandidatePage.selectVacancy(vacancy);
        addCandidatePage.setEmail(email);
        addCandidatePage.setContactNumber(contactNumber);
        addCandidatePage.setResume(resume);
        addCandidatePage.clickSaveButton();
    }
}
