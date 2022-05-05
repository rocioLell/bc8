package automationcraft.testcreation.google.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.google.pages.GoogleHomePage;
import automationcraft.testcreation.google.pages.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSteps {

    GoogleHomePage ghp;

    @Given("that I have gone to the Google page")
    public void that_i_have_gone_to_the_google_page() {
        ghp = new GoogleHomePage(DriverFactory.getDriver());
        ghp.irAGoogleHome();
    }

    @When("I add {string} to the search box")
    public void i_add_to_the_search_box(String string) {
        ghp.insertarTextoEnSearchBox(string);
    }

    @When("click the Search Button")
    public void click_the_search_button() {
        ghp.clickearBtnBusqueda();
    }

    @Then("{string} should be mentioned in the results")
    public void should_be_mentioned_in_the_results(String string) {
        SearchResultPage srp = new SearchResultPage(DriverFactory.getDriver());
        srp.validarPalabraEnPrimerLink(string);
    }
}
