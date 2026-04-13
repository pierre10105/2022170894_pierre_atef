import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class exercise1 {
    WebDriver driver;

    // STEP 0: Open Website (Lifecycle Hook)
    @BeforeTest
    public void openWebSite() {
        // Ensure you have the driver executable or use WebDriverManager
        driver = new ChromeDriver();
        System.out.println("Before Test: Opening Website");
        driver.get("https://www.noon.com/egypt-en/");
    }

    // STEP 1: Sign Up (Priority 1)
    @Test(priority = 1)
    public void signUp() {
        System.out.println("Execution Log: Performing Sign Up operations...");
        // driver.findElement(By.id("signup")).click();

    }

    // STEP 2: Log In (Priority 2)
    @Test(priority = 2)
    public void logIn() {
        System.out.println("Execution Log: Performing Login operations...");
        // driver.findElement(By.id("login")).click();
    }

    // STEP 3: Add to Cart (Priority 3)
    @Test(priority = 3)
    public void addToCart() {
        System.out.println("Execution Log: Adding items to the cart...");
        // driver.findElement(By.id("add-to-cart")).click();
    }

    // STEP 4: Close Browser (Lifecycle Hook)
    @AfterTest
    public void logOut() {
        if (driver != null) {
            driver.quit();
            System.out.println("Execution Log: Browser closed and logged out.");
        }
    }
}