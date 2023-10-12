package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions {

    @Given("User is on landing page")
    public void user_is_on_landing_page() {
        int x = 44;
        System.out.println(x);
    }

    @When("User login into application with username and password")
    public void user_login_into_application_with_username_and_password() {
        int x = 45;
        System.out.println(x);
    }

    @Then("Home page is populated")
    public void home_page_is_populated() {
        int x = 46;
        System.out.println(x);
    }

    @Then("Cards are displayed")
    public void cards_are_displayed() {
        int x = 47;
        System.out.println(x);
    }

}
