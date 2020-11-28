import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordPressLoginHomeWork3 {
    private WebDriver driver;

    public WordPressLoginHomeWork3(WebDriver driver) {
        this.driver = driver;
    }

    By signInLinkMainPage = By.xpath("//*[@id='meta-2']/ul/li[1]/a");
    By loginField = By.xpath("//*[@id='user_login']");
    By passwordField = By.xpath("//*[@id='user_pass']");
    By submitButton = By.xpath("//*[@id='wp-submit']");

    public WordPressLoginHomeWork3 signInLinkClick() {
        WebElement topFrame = driver.findElement(By.xpath("//a/span[contains(text(),'Remove Frame')]"));
        topFrame.click();
        driver.findElement(signInLinkMainPage).click();
        return this;
    }

    public WordPressLoginHomeWork3 waitForPageTitle() {
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElement(
                        driver.findElement(By.xpath("//p[@id='backtoblog']/a")), "Back to opensourcecms"));
        return this;
    }

    public WordPressLoginHomeWork3 sendLoginField(String login) {
        driver.findElement(loginField).sendKeys(login);
        return this;
    }

    public WordPressLoginHomeWork3 sendPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public WordPressLoginHomeWork3 sendSubmitButton() {
        driver.findElement(submitButton).click();
        return this;
    }

    public WordPressLoginHomeWork3 loginUserToAccount(String login, String password) {
        signInLinkClick();
        waitForPageTitle();
        sendLoginField(login);
        sendPasswordField(password);
        sendSubmitButton();
        return this;
    }
}
