import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordPressLogoutHomeWork3 {
    private WebDriver driver;

    public WordPressLogoutHomeWork3(WebDriver driver) {
        this.driver = driver;
    }

    By popUpMenuItem = By.xpath("//li[@id='wp-admin-bar-my-account']");
    By logoutLink = By.xpath("//li[@id='wp-admin-bar-logout']/a");

    public WordPressLogoutHomeWork3 hoverPopUpMenuItem() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(popUpMenuItem)).perform();
        return this;
    }

    public WordPressLogoutHomeWork3 sendLogoutUser() {
        driver.findElement(logoutLink).click();
        return this;
    }

    public WordPressLogoutHomeWork3 waitForLogoutPageText() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElement(
                        driver.findElement(By.xpath("//p[@class='message']")), "You are now logged out"));
        return this;
    }

    public WordPressLogoutHomeWork3 logoutUserFromAccount() {
        hoverPopUpMenuItem();
        sendLogoutUser();
        waitForLogoutPageText();
        return this;
    }
}
