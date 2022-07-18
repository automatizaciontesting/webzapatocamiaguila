package com.zapatocamiaguila.stepsdefinition;

import com.zapatocamiaguila.questions.TotalProductos;
import com.zapatocamiaguila.tasks.AgregarProductos;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static org.hamcrest.Matchers.equalTo;

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
    @When("valido el total de producto agregados al carrito")
    public void validoElTotalDeProductoAgregadosAlCarrito() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TotalProductos.comprados(),
                equalTo(Serenity.sessionVariableCalled("totalItems"))
        ));
    }

}
