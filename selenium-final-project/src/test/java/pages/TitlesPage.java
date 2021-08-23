package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElement;

import java.util.List;

public class TitlesPage {

    @FindBy(css = "#titles > h2")
    private WebElement titlePageHeader;

    @FindBy(id = "add-title-button")
    private WebElement addTitleButton;

    @FindBy(name = "title")
    private WebElement titleInput;

    @FindBy(name = "author")
    private WebElement authorInput;

    @FindBy(name = "year")
    private WebElement yearInput;

    @FindBy(name = "submit-button")
    private WebElement submitAddBook;

    @FindAll(@FindBy(xpath = "//*[contains(@id, 'title-')]/div[2]/button[2]"))
    List<WebElement> removeBookButtonsList;

    @FindBy(xpath = "//*[contains(@id, 'title-')]/div[2]/button[2]")
    private WebElement removeBookButton;

    @FindBy(xpath = "//*[contains(@class, 'alert--info')]")
    private WebElement alertInfo;

    public TitlesPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getTitlePageHeader() {
        WaitForElement.waitUntilElementVisible(titlePageHeader);
        return titlePageHeader.getText();
    }

    @FindBy(xpath = "//*[contains (@class, 'titles-list')]")
    private WebElement bookList;

    @FindBy(xpath = "//*[contains(@id, 'title-')]")
    private WebElement book;

    public void clickAddTitleButton() {

        if(removeBookButtonsList.size() == 0) {
            addTitleButton = new WebDriverWait(DriverManager.getWebDriver(), 5).
                    until(ExpectedConditions.elementToBeClickable(getAddTitleButton()));
            Actions actions = new Actions(DriverManager.getWebDriver());
            actions.moveToElement(addTitleButton).perform();
            addTitleButton.click();
        } else {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 10);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(bookList)));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(getAddTitleButton())));
            Actions actions = new Actions(DriverManager.getWebDriver());
            actions.moveToElement(addTitleButton).perform();
            addTitleButton.click();
        }
    }
    public WebElement getAddTitleButton() {
        return addTitleButton;
    }

    public void fillBookInputs(String title, String author, String year) {
        this.fillTitleInput(title);
        this.fillAuthorInput(author);
        this.fillYearInput(year);
        Actions actions = new Actions(DriverManager.getWebDriver());
        actions.moveToElement(submitAddBook);
        submitAddBook.click();
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 5);
        wait.until
                (ExpectedConditions.refreshed
                        (ExpectedConditions.visibilityOfAllElements(removeBookButtonsList)));

    }
    public WebElement getSubmitAddBook() {
        return submitAddBook;
    }

    public void removeTitle() {
        for(WebElement button : removeBookButtonsList) {
            if(removeBookButtonsList.size() > 0) {
                WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 5);
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getBookList())));
                wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(getRemoveBookButton())));
                Actions actions = new Actions(DriverManager.getWebDriver());
                actions.moveToElement(button);
                button.click();
                WaitForElement.waitUntilElementInvisible2(button);
            } else {
                WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 5);
                wait.until(ExpectedConditions.invisibilityOf(bookList));
                WaitForElement.waitUntilElementVisible(alertInfo);
            }
        }
    }
    public WebElement getRemoveBookButton() {
        return removeBookButton;
    }
    public WebElement getBookList() {return bookList;}

    public void fillTitleInput(String title) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 5);
        WaitForElement.waitUntilElementVisible(titleInput);
        titleInput.sendKeys(title);
    }

    public void fillAuthorInput(String author) {
        authorInput.sendKeys(author);
    }

    public void fillYearInput(String year) {
        yearInput.sendKeys(year);
    }



    public int getRemoveButtonsListSize() {
//        System.out.println(removeBookButtonsList.size());
        return removeBookButtonsList.size();
    }
}
