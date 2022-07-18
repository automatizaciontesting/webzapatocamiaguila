package com.zapatocamiaguila.tasks;

import com.zapatocamiaguila.interactions.*;
import com.zapatocamiaguila.utils.Helpers;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;


import java.util.List;
import java.util.Map;

import static com.zapatocamiaguila.ui.CategoriaProductos.BTN_CERRAR_CARRITO;
import static com.zapatocamiaguila.ui.CategoriaProductos.CONTENEDOR_DIRECCIONES;

public class AgregarProductos implements Task {
    Helpers helpers = new Helpers();
    List<Map<String, String>> datosFeature;

    public AgregarProductos(DataTable dataTable){
        this.datosFeature = dataTable.asMaps(String.class, String.class);
        Serenity.setSessionVariable("totalItems").to(String.valueOf(this.datosFeature.size()));
    }
    public static AgregarProductos alCarritoDeCompras(DataTable dataTable) {
        return Tasks.instrumented(AgregarProductos.class,dataTable);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Map<String, String> data : datosFeature) {

            actor.attemptsTo(SeleccionarProducto.deLaCategoria(data.get("Categoria")));
            helpers.delayElement(4);
            actor.attemptsTo(MostarMas.porCategoria());
            helpers.delayElement(4);
            actor.attemptsTo(SeleccionarSubcategoria.delProducto(data.get("Subcategoria")));
            helpers.delayElement(3);
            actor.attemptsTo(AgregarProducto.alCarritoDeCompras(data.get("Producto")));
            helpers.delayElement(3);

            List<WebElementFacade> seleccionarDireccion = CONTENEDOR_DIRECCIONES.resolveAllFor(actor);
            WebElementFacade cerrarVentana = BTN_CERRAR_CARRITO.resolveFor(actor);
            for(WebElementFacade elemento : seleccionarDireccion){
                if(elemento.getText().compareToIgnoreCase("152a")>0){
                    elemento.click();
                    helpers.delayElement(3);
                    break;
                }
            }
            actor.attemptsTo(Check.whether(cerrarVentana.isVisible()).andIfSo(Click.on(BTN_CERRAR_CARRITO)));
            helpers.delayElement(3);

        }






    }


}
