package waits;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), 5);
    }

    public static WebElement waitUntilElementVisible(WebElement element) {
        WebDriverWait wait = getWebDriverWait();
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementInvisible(By by) {// Zmienic na webelement jesli mozliwe
        WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.invisibilityOf(DriverManager.getWebDriver().findElement(by)));
    }

    public static void waitUntilElementInvisible2(WebElement element) {// Zmienic na webelement jesli mozliwe
        WebDriverWait wait = getWebDriverWait();
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static WebElement waitUntilElementClickable(WebElement element) {
        WebDriverWait wait = getWebDriverWait();
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilElementIsPresent(By by) {
        WebDriverWait wait = getWebDriverWait();
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
