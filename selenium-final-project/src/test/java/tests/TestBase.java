package tests;

import driver.DriverManager;
import driver.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateTo("https://ta-ebookrental-fe.herokuapp.com/login");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeWebDriver();
    }

    public void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
