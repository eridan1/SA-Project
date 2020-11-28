import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssDinnerPlayFullGameHomeWork2 {
    private WebDriver driver;
    private final String[] answers = new String[]
    {
        "plate", //1
        "bento", //2
        "#fancy", //3
        "plate apple", //4
        "#fancy pickle", //5
        ".small", //6
        "orange.small", //7
        "bento orange.small", //8
        "plate, bento", //9
        "*", //10
        "plate *", //11
        "plate + apple", //12
        "bento ~ pickle", //13
        "plate > apple", //14
        "plate :first-child", //15
        "plate apple:only-child, plate pickle:only-child", //16
        "plate apple:last-child, pickle", //17
        "plate:nth-child(3)", //18
        "bento:nth-last-child(3)", //19
        "apple:first-of-type", //20
        "plate:nth-of-type(even)", //21
        "plate:nth-of-type(2n+3)", //22
        "apple:only-of-type", //23
        "apple:last-of-type, orange:last-of-type", //24
        "bento:empty", //25
        "apple:not(.small)", //26
        "[for]", //27
        "plate[for]", //28
        "bento[for='Vitaly']", //29
        "[for^='Sa']", //30
        "[for$='ato']", //31
        "[for*='obb']" //32
    };

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://flukeout.github.io/");
    }

    @Test(priority = 1)
    public void cssDinnerPlayGame() throws InterruptedException {
        System.out.println("Start playing game '" + driver.getTitle() + "'");
        // define locators for game
        WebElement currentGameTask = driver.findElement(By.className("order"));
        WebElement gameLevel = driver.findElement(By.className("level-text"));
        WebElement rowForAnswer = driver.findElement(By.xpath("//*[@class='input-strobe' and @type = 'text']"));
        WebElement enterButton = driver.findElement(By.xpath("//div[contains(@class,'enter-button') and contains(text(), 'enter') ]"));
        // define an explicit wait
        WebDriverWait waitBeforeAnswer = (new WebDriverWait(driver, 1));
        WebDriverWait waitAfterAnswer = (new WebDriverWait(driver, 1));
        // playing game
        for (int i = 0; i < answers.length; i++) {
            System.out.println("Game level is '" + gameLevel.getText() + "'");
            System.out.println("Current task is '" + currentGameTask.getText() + "'");
            waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
            rowForAnswer.sendKeys(answers[i]);
            Thread.sleep(1000);
            enterButton.click();
            if (i < answers.length - 1) {
                waitAfterAnswer.until(ExpectedConditions.textToBe(new By.ByClassName("level-text"), "Level " + (i + 2) + " of 32"));
            } else {
                waitAfterAnswer.until(ExpectedConditions.presenceOfElementLocated(new By.ByClassName("winner")));
            }
        }
        System.out.println("The end of game");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
