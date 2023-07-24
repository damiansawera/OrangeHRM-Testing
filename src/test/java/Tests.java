import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    @Test
    public void firstTest() {
        loginPage.Login("Admin","admin123");
        Assert.assertEquals(loginPage.getCurrentURL(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

}
