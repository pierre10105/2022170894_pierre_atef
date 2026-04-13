import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import java.time.Duration;


public class exercise2 {
    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
// Adding @Optional("chrome") tells TestNG: "If the XML doesn't tell you the browser, just use Chrome."
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get("https://demo.guru99.com/test/login.html");
    }

    @BeforeMethod
    public void navigateToLogin() {
        driver.get("https://demo.guru99.com/test/login.html");
    }

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][] {
                { "test@mail.com", "123", false },
                { "test@mail.com", "152", true  }
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String pass, boolean isValid) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(pass);
        driver.findElement(By.id("SubmitLogin")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("success"));

        if (isValid) {
            Assert.assertTrue(driver.getCurrentUrl().contains("success"));
        } else {
            try {
                Assert.assertFalse(driver.getCurrentUrl().contains("success"));

            }catch(AssertionError error) {
                System.out.println("Invalid Account");
            }
        }
    }

    @AfterClass
    public void tearDown() { driver.quit(); }
}