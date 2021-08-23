package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\A\\KORAS\\Projekty\\chromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void disposeWebDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }
}
