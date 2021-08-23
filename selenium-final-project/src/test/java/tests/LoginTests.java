package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TitlesPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase{

    @Test//(invocationCount = 20)
    public void loginUserWithCorrectLoginAndPassword() {
        LoginPage loginPage = new LoginPage();
        //When
        loginPage.fillLoginInput("pies");
        loginPage.fillPasswordInput("pies");
        loginPage.clickLoginButton();

        //Then
        TitlesPage titlesPage = new TitlesPage();
        String pageHeader = titlesPage.getTitlePageHeader().toUpperCase();
        assertEquals(pageHeader, "TITLES CATALOG");
    }

    @Test//(invocationCount = 20)
    public void loginUserWith_NoLogin() {
        LoginPage loginPage = new LoginPage();
        //When
        loginPage.fillPasswordInput("pies");
        loginPage.clickLoginButton();

        //Then
        WebElement alertMessage = loginPage.getAlertMessage();
        assertTrue(alertMessage.isDisplayed());
        assertEquals(alertMessage.getText(), "You can't leave fields empty");
    }

    @Test//(invocationCount = 20)
    public void loginUserWith_NoPassword() {
        LoginPage loginPage = new LoginPage();
        //When
        loginPage.fillLoginInput("pies");
        loginPage.clickLoginButton();

        //Then
        WebElement alertMessage = loginPage.getAlertMessage();
        assertTrue(alertMessage.isDisplayed());
        assertEquals(alertMessage.getText(), "You can't leave fields empty");
    }

    @Test//(invocationCount = 20)
    public void loginUserWithIncorrectLogin() {
        LoginPage loginPage = new LoginPage();
        //When
        loginPage.fillLoginInput("pies");
        loginPage.fillPasswordInput("kot");
        loginPage.clickLoginButton();

        //Then
        WebElement alertMessage = loginPage.getAlertMessage();
        assertTrue(alertMessage.isDisplayed());
        assertEquals(alertMessage.getText(), "Login failed");
    }

    @Test//(invocationCount = 20)
    public void loginUserWithIncorrectPassword() {
        LoginPage loginPage = new LoginPage();
        //When
        loginPage.fillLoginInput("kot");
        loginPage.fillPasswordInput("pies");
        loginPage.clickLoginButton();

        //Then
        WebElement alertMessage = loginPage.getAlertMessage();
        assertTrue(alertMessage.isDisplayed());
        assertEquals(alertMessage.getText(), "Login failed");
    }
}
