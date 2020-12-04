import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrangeHRMHomeWork1 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://s1.demo.opensourcecms.com/s/44");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void testLoginLogout() {
        // define and hide frame element
        WebElement topFrame = driver.findElement(By.xpath("//a/span[contains(text(),'Remove Frame')]"));
        topFrame.click();
        // define main elements
        WebElement loginElement = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        WebElement passwordElement = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        // check and login
        loginElement.sendKeys("opensourcecms");
        passwordElement.sendKeys("opensourcecms");
        submitButton.click();
        // check result
        Assert.assertTrue(driver.getCurrentUrl().contains("orangehrm/index.php"));
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText(), "Добро пожаловать, Admin");
        // define logout element
        WebElement logoutElement = driver.findElement(By.xpath("//ul[@id='option-menu']/li[3]/a"));
        // logging out
        logoutElement.click();
        // check result
        Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
