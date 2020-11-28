import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainPageSearchField {
    WebDriver driver;
    //MainPageSearch mainPageSearch = new MainPageSearch(driver);

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        // go to website
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void findValidValue() {
        MainPageSearch mainSearch = new MainPageSearch(driver);
        mainSearch.searchFieldInput("пылесос");
        mainSearch.searchButtonClick();
        mainSearch.waitForPageTitle("Пылесосы");
        mainSearch.checkTheFirstItemIs("Пылесос");
    }

    @Test(priority = 2, description = "Negative test case")
    public void findInvalidValue() {
        MainPageSearch mainPageSearch = new MainPageSearch(driver);
        mainPageSearch.searchFieldInput("::::");
        mainPageSearch.searchButtonClick();
        mainPageSearch.waitForPageTitle("::::");
        mainPageSearch.checkTheAbsenceOfItems();
    }

    @Test(priority = 3)
    public void findValueNotFromBreadCrumbs() {
        MainPageSearch mainPageSearch = new MainPageSearch(driver);
        mainPageSearch.searchFieldInput("чупакабра");
        mainPageSearch.searchButtonClick();
        mainPageSearch.waitForPageTitle("чупакабра");
        mainPageSearch.checkTheFirstItemIs("чупакабру");
        mainPageSearch.checkFindItemsText("Найдено");
    }
}
