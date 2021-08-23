package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    @FindBy(id = "login")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-btn")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'alert--error')]/p")
    private WebElement alertMessage;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void fillLoginInput(String login) {
        loginInput.sendKeys(login);

    }

    public void fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginUser(String login, String password) {
        WaitForElement.waitUntilElementVisible(loginInput);
        this.fillLoginInput(login);
        this.fillPasswordInput(password);
        this.clickLoginButton();
    }

    public WebElement getAlertMessage() {
        WaitForElement.waitUntilElementVisible(alertMessage);
        return alertMessage;
    }
}
