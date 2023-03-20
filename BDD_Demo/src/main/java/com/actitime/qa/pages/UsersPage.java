package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.entities.UserCredential;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends TestBase {
    @FindBy(xpath = "//div[text()='New User']")
    @CacheLookup
    private WebElement newUserButton;

    @FindBy(xpath = "//input[@id='createUserPanel_firstNameField']")
    @CacheLookup
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='createUserPanel_lastNameField']")
    @CacheLookup
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='createUserPanel_emailField']")
    @CacheLookup
    private WebElement emailInput;

    @FindBy(xpath = "//div[text()='Save & Send Invitation']")
    @CacheLookup
    private WebElement saveAndSendInvitationButton;

    @FindBy(xpath = "//div[@class='closeLink']/span[text()='Close']")
    @CacheLookup
    private WebElement closeNewUserPanelButton;

    private WebDriverWait wait;

    public UsersPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    public void clickOnNewUserButton() {
        newUserButton.click();
        firstNameInput = wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        lastNameInput = wait.until(ExpectedConditions.elementToBeClickable(lastNameInput));
        emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        saveAndSendInvitationButton = wait.until(ExpectedConditions.elementToBeClickable(saveAndSendInvitationButton));
    }

    public void fillUserData(UserCredential userCredential) {
        firstNameInput.sendKeys(userCredential.getFirstName());
        lastNameInput.sendKeys(userCredential.getLastName());
        emailInput.sendKeys(userCredential.getEmail());
    }

    public void clickOnSaveAndSendInvitationButton() {
        saveAndSendInvitationButton.click();
        closeNewUserPanelButton = wait.until(ExpectedConditions.elementToBeClickable(closeNewUserPanelButton));
    }

    public void clickOnCloseNewUserPanelButton() {
        closeNewUserPanelButton.click();
    }
}
