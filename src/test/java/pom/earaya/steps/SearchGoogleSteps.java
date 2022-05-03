package pom.earaya.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.earaya.base.CucumberBaseTest;
import pom.earaya.page.GoogleHomePage;

public class SearchGoogleSteps {

    private GoogleHomePage ghp;

    @Given("estoy en un navegador con la pagina inicial de google")
    public void estoyEnUnNavegadorConLaPaginaInicialDeGoogle() {
        ghp = new GoogleHomePage(CucumberBaseTest.getDriver());
        ghp.irAHomePage();
    }

    @When("introduzco la palabra {string} en la barra")
    public void introduzcoLaPalabraEnLaBarra(String arg0) {
        ghp.buscarTexto(arg0);
    }

    @And("realizo la busqueda con Enter")
    public void realizoLaBusquedaConEnter() {
        ghp.clickBtnBarraGoogle();

    }

    @Then("el navegador me muestra los resultados")
    public void elNavegadorMeMuestraLosResultados() {
    }
}
