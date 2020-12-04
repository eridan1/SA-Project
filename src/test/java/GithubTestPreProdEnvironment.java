import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GithubTestPreProdEnvironment {
    WebDriver driver;
    Environment testEnvironment;

    @BeforeTest
    @Parameters({"environment"})
    public void setUp(String environment) {
        driver = new ChromeDriver();
        ConfigFactory.setProperty("env", environment);
        testEnvironment = ConfigFactory.create(Environment.class);
        driver.get(testEnvironment.myUrl());
        //driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void loginInto() {
        LoginGithub login = new LoginGithub(driver);
        login.loginUserIntoAccount(testEnvironment.login(), testEnvironment.password());
    }

    @Test(priority = 2)
    public void inspectMainPage() {
        InspectionGithub inspect = new InspectionGithub(driver);
        inspect.checkTheAccountNameIs(testEnvironment.accountOwner());
    }

    @Test(priority = 3)
    public void logoutFromGithub() throws InterruptedException {
        LogoutGithub logout = new LogoutGithub(driver);
        logout.logoutUserFromAccount();
    }
}
