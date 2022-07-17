package com.zapatocamiaguila.stepsdefinition;

import com.zapatocamiaguila.questions.CuentaCreada;
import com.zapatocamiaguila.tasks.IngresarCredenciale;
import com.zapatocamiaguila.tasks.IngresarEnLogueo;
import com.zapatocamiaguila.ui.HomeZapatoca;
import com.zapatocamiaguila.ui.RegistroZapatoca;
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

public class RegistroUsuarioStepsDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("como {string} ingreso al formulario")
    public void comoIngresoAlFormulario(String actor) {
        OnStage.theActorCalled(actor).
                attemptsTo(
                        Open.browserOn().the(RegistroZapatoca.class)
                );
    }
    @When("ingreso los datos de registro")
    public void ingresoLosDatosDeRegistro(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().
                attemptsTo(IngresarCredenciale.creacionUsuario(dataTable)
                );
    }
    @Then("se realiza el registro de forma exitosa")
    public void seRealizaElRegistroDeFormaExitosa() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CuentaCreada.deFormaExitosa(),
                equalTo(true)
        ));
    }
}
