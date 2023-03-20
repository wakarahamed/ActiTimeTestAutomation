package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.entities.UserCredential;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.UsersUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateUserStepDefinitions extends TestBase {
    UsersPage usersPage;
    HomePage homePage;

    @Given("^Given User in the Actitime home page$")
    public void user_in_the_Actitime_Home_Page() throws Throwable {
        initialization();
    }

    @When("^When User clicks on users tab$")
    public void User_click_on_users_tab() throws Throwable {
        homePage.clickOnUsersLink();
    }

    @Then("^Then User clicks on new user button$")
    public void user_click_on_new_user_button() throws Throwable {
        usersPage.clickOnNewUserButton();
    }

    @Then("^Then Fill up user data$")
    public void user_fill_in_user_data() throws Throwable {
        UserCredential userCredential = UsersUtil.getUserCredential();
        usersPage.fillUserData(userCredential);
    }

    @Then("^Then Click on save and send invite button$")
    public void user_click_on_send_invite_button() throws Throwable {
        usersPage.clickOnSaveAndSendInvitationButton();
    }

    @Then("^Then User should get added successfully$")
    public void user_should_be_added_successfully() throws Throwable {
        driver.quit();
    }
    
    
}
