package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.admin_page.AdminPage;
import pages.pim_page.PimPage;
import pages.recruitment_page.RecruitmentPage;
import pages.time_page.TimePage;

public class HomePage {
    WebDriver driver;
    private Logger logger;
    public HomePage(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
    }

    public AdminPage goToAdminPage() {
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Admin']")).click();
        return new AdminPage(driver, logger);
    }

    public PimPage goToPimPage() {
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']")).click();
        return new PimPage(driver, logger);
    }


    public TimePage goToTimePage() {
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Time']")).click();
        return new TimePage(driver, logger);
    }

    public RecruitmentPage goToRecruitmentPage() {
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Recruitment']")).click();
        return new RecruitmentPage(driver, logger);
    }
    public boolean isLoggedIn() {
        return driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
}
