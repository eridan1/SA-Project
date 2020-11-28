import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WordPressActionsHomeWork3 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://s1.demo.opensourcecms.com/s/39");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testLogin() {
        WordPressLoginHomeWork3 loginItem = new WordPressLoginHomeWork3(driver);
        loginItem.loginUserToAccount("opensourcecms", "opensourcecms");
    }

    @Test(priority = 2)
    public void testLogout() {
        WordPressLogoutHomeWork3 logoutItem = new WordPressLogoutHomeWork3(driver);
        logoutItem.logoutUserFromAccount();
    }
}
