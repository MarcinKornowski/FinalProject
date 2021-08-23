package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TitlesPage;

import static org.testng.Assert.assertEquals;

public class TitlePageTest extends TestBase{

    @Test(invocationCount = 10)
    public void addBookTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginUser("pies", "pies");

        TitlesPage titlesPage = new TitlesPage();
        titlesPage.clickAddTitleButton();
        titlesPage.fillBookInputs("One", "One", "1000");
        titlesPage.clickAddTitleButton();
        titlesPage.fillBookInputs("Two", "Two", "2000");
        titlesPage.clickAddTitleButton();
        titlesPage.fillBookInputs("Three", "Three", "3000");
        titlesPage.clickAddTitleButton();
        titlesPage.fillBookInputs("Four", "Four", "4000");
        titlesPage.getRemoveButtonsListSize();
        titlesPage.removeTitle();
        sleep();
        assertEquals(titlesPage.getRemoveButtonsListSize(), 0);
    }
}
