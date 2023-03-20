package com.actitime.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.entities.UserCredential;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.UsersUtil;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateUserTest extends TestBase {
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static UsersPage usersPage;

    public CreateUserTest() {
        super();
    }

    @BeforeSuite
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        usersPage = homePage.clickOnUsersLink();
    }

    @Test(priority = 1)
    public void openNewUserPanel() {
        usersPage.clickOnNewUserButton();
    }

    @Test(priority = 2, dependsOnMethods = {"openNewUserPanel"})
    public void fillUserData() throws CsvValidationException, IOException {
        UserCredential userCredential =  UsersUtil.getUserCredential();
        usersPage.fillUserData(userCredential);
    }

    @Test(priority = 3, dependsOnMethods = {"fillUserData"})
    public void createNewUser() {
        usersPage.clickOnSaveAndSendInvitationButton();
    }

    @Test(priority = 4, dependsOnMethods = {"createNewUser"})
    public void closeNewUserPanel() {
        usersPage.clickOnCloseNewUserPanelButton();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
