package com.zapatocamiaguila.stepsdefinition;

import com.zapatocamiaguila.tasks.AgregarProductos;
import com.zapatocamiaguila.tasks.IngresarEnLogueo;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class RealizarCompraStepsDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("realizo la compra de los productos")
    public void realizoLaCompraDeLosProductos(io.cucumber.datatable.DataTable dataTable) {
        OnStage.theActorInTheSpotlight().
                attemptsTo(AgregarProductos.alCarritoDeCompras(dataTable)
                );
    }
}
