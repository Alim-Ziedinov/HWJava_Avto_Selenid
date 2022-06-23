import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.awt.SystemColor.text;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        //System.setProperty("webdriver.gecko.driver", "./drivers/linux/geckodriver");
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }


    @Test
    void shouldSubmitRequest() {
        driver.get("http://localhost:9999");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Сюзанна");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+79788586822");
     //   List<WebElement> elements = driver.findElements(By.className("input__control"));
     //   elements.get(0).sendKeys("Василий");
      //  elements.get(1).sendKeys("+79270000000");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String text = driver.findElement(By.className("paragraph_theme_alfa-on-white")).getText().trim();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, text);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
