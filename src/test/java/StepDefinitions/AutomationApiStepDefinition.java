package StepDefinitions;

import facts.InfoUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.RegisterUserInfo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.ResponseCode;
import task.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static userinterfaces.Api.resApiUrl;

public class AutomationApiStepDefinition {


    private Actor actor;


    @Given("The user admin get to web services")
    public void theUserAdminGetToWebServices() {
        actor = Actor.named("Admin");
        actor.whoCan(CallAnApi.at(resApiUrl));
    }

    @When("the admin add a user to the BD")
    public void theAdminAddAUserToTheBD() {

        RegisterUserInfo registerUserInfo = new RegisterUserInfo();
        registerUserInfo.setEmail("eve.holt@reqres.in");
        registerUserInfo.setPassword("pistol");

        actor.has(InfoUser.toViewInfo());

        actor.attemptsTo(
                RegisterUser.withInfo(registerUserInfo)
        );

    }

    @Then("the user is added")
    public void theUserIsAdded() {
        actor.should(
                seeThat("The response code", ResponseCode.was(), equalTo(200))
        );

    }

    @When("the admin look a user to the BD")
    public void theAdminLookAUserToTheBD() {
        actor.attemptsTo(
                GetUsers.fromPage(2)
        );

        actor.attemptsTo(ResponseUsers.fromPage());

    }

    @Then("the requested data are returned")
    public void theRequestedDataAreReturned() {
        actor.should(
                seeThatResponse("all the expected users should be returned",
                        response -> response.statusCode(200)
                                .body("data.last_name", hasItems("Lawson", "Ferguson", "Funke", "Fields")))
        );

    }


    @When("the admin look users to the BD")
    public void theAdminLookUsersToTheBD() {

        actor.attemptsTo(
                GetUser.fromPage(2)
        );


    }

    @Then("the requested data is returned")
    public void theRequestedDataIsReturned() {
        actor.should(
                seeThat("User is not null", ResponseCode.was(), notNullValue())
        );

        actor.should(
                seeThatResponse("he expected first name of one user should be returned",
                        response -> response.statusCode(200)
                                .body("data.first_name", equalTo("Janet")))
        );

    }

    @When("the admin delete a user to the BD")
    public void theAdminDeleteAUserToTheBD() {

        actor.attemptsTo(
                DeleteUser.fromPage(2
                )
        );

    }

    @Then("the user is deleted")
    public void theUserIsDeleted() {
        actor.should(
                seeThat("The response code", ResponseCode.was(), equalTo(204))
        );

    }


}
