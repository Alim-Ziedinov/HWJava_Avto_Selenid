import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        System.setProperty("Webdriver.geckodriver.driver", "./win/geckodriver.exe");
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }


    @Test
    voidshouldTestSomething() {
        driver.get("ja");
    }
}
