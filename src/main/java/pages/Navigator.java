package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.admin_page.AdminPage;
import pages.pim_page.PimPage;
import pages.time_page.TimePage;

public class Navigator {
    WebDriver driver;
    public Navigator(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPage goToAdminPage() {
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Admin']")).click();
        return new AdminPage(driver);
    }

    public PimPage goToPimPage() {
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']")).click();
        return new PimPage(driver);
    }


    public TimePage goToTimePage() {
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Time']")).click();
        return new TimePage(driver);
    }
}
