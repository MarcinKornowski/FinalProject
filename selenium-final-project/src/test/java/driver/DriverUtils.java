package driver;

public class DriverUtils {

    public static void setInitialConfiguration() {
        DriverManager.getWebDriver().manage().window().maximize();
    }

    public static void navigateTo(String pageUrl) {
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }
}
