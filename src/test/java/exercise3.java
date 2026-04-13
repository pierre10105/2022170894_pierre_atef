import org.testng.annotations.*;

public class exercise3 {

    @BeforeGroups("Smoke")
    public void startSmokeLog() {
        System.out.println("--- STARTING SMOKE TESTS ---");
    }

    @AfterGroups("Smoke")
    public void endSmokeLog() {
        System.out.println("--- SMOKE TESTS COMPLETED ---");
    }

    // --- SMOKE GROUP ---
    @Test(groups = {"Smoke"})
    public void testHomepageLoads() {
        System.out.println("Executing: Homepage Load Test");
    }

    @Test(groups = {"Smoke"})
    public void testLoginPageVisible() {
        System.out.println("Executing: Login UI Visibility Test");
    }

    // --- REGRESSION GROUP ---
    @Test(groups = {"Regression"})
    public void testLoginValidCreds() {
        System.out.println("Executing: Valid Credentials Regression");
    }

    @Test(groups = {"Regression"})
    public void testPasswordReset() {
        System.out.println("Executing: Password Reset Functionality");
    }

    @Test(groups = {"Regression"})
    public void testAccountBalance() {
        System.out.println("Executing: Account Balance Calculation");
    }
}