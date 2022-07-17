package com.zapatocamiaguila.stepsdefinition;

import com.zapatocamiaguila.questions.EstaLogueado;
import com.zapatocamiaguila.questions.LoginInvalido;
import com.zapatocamiaguila.tasks.IngresarEnLogueo;
import com.zapatocamiaguila.tasks.SeleccionarCampo;
import com.zapatocamiaguila.ui.HomeZapatoca;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static org.hamcrest.Matchers.*;

public class LoginStepsDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("como {string} en la plataforma")
    public void comoEnLaPlataforma(String actor) {
        OnStage.theActorCalled(actor).
                attemptsTo(
                        Open.browserOn().the(HomeZapatoca.class)
                );
    }
    @When("ingreso datos de las credenciales")
    public void ingresoDatosDeLasCredenciales(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().
                attemptsTo(IngresarEnLogueo.lasCredencialesDeUsuario(dataTable)
        );
    }
    @Then("pueda ingresar de forma exitosa")
    public void puedaIngresarDeFormaExitosa() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(EstaLogueado.enLaPagina(),
                equalTo(true)
        ));
    }

    @Then("se muestra mensaje campos requeridos")
    public void seMuestraMensajeCamposRequeridos() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(LoginInvalido.camposRequeridos(),
                hasItems("- Campo Requerido","- Debes ingresar un email válido")
        ));
    }
    @When("no se ingresan datos de usuario")
    public void noSeIngresanDatosDeUsuario() {
        OnStage.theActorInTheSpotlight().
                attemptsTo(SeleccionarCampo.usuario()
                );
    }
}
