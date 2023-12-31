package tests;

import config.ConfigLoader;
import org.testng.annotations.Test;
import pages.recruitment_page.AddCandidatePage;
import pages.recruitment_page.RecruitmentPage;
import utility.Log;

import java.io.File;

import static org.testng.Reporter.getCurrentTestResult;

public class RecruitmentTests extends TestBase {

    @Test(description = "New candidate for the recruitment process is successfully created")
    public void successfullyAddCandidate()  {
        String testCaseName = getCurrentTestName(getCurrentTestResult());
        Log.startTestCase(testCaseName);
        ConfigLoader configLoader = new ConfigLoader("src/test/java/config/configuration.properties");
        boolean isRemote = configLoader.isRemote();
        String vacancy = "Senior QA Lead";
        String resume;
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String contactNumber = faker.phoneNumber().subscriberNumber();
        if (isRemote) {
            resume = "/app/src/main/resources/resume.pdf";
        } else {
            resume = new File("src/main/resources/resume.pdf").getAbsolutePath();
        }

        RecruitmentPage recruitmentPage = homePage.goToRecruitmentPage();
        AddCandidatePage addCandidatePage = recruitmentPage.clickAddCandidateButton();
        addCandidatePage.setFirstName(firstName);
        addCandidatePage.setLastName(lastName);
        addCandidatePage.selectVacancy(vacancy);
        addCandidatePage.setEmail(email);
        addCandidatePage.setContactNumber(contactNumber);
        addCandidatePage.setResume(resume);
        addCandidatePage.clickSaveButton();

        Log.endTestCase(testCaseName);
    }
}
