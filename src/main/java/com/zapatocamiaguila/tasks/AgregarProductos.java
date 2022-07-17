package com.zapatocamiaguila.tasks;

import com.zapatocamiaguila.interactions.SeleccionarCategoria;
import com.zapatocamiaguila.utils.Helpers;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.zapatocamiaguila.ui.CategoriaProductos.BTN_CERRAR_CARRITO;
import static com.zapatocamiaguila.ui.CategoriaProductos.CONTENEDOR_DIRECCIONES;
import static com.zapatocamiaguila.ui.HomeZapatoca.GRILLA_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

public class AgregarProductos implements Task {
    Helpers helpers = new Helpers();
    List<Map<String, String>> datosFeature;

    public AgregarProductos(DataTable dataTable){
        this.datosFeature = dataTable.asMaps(String.class, String.class);
    }
    public static AgregarProductos alCarritoDeCompras(DataTable dataTable) {
        return Tasks.instrumented(AgregarProductos.class,dataTable);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Map<String, String> data : datosFeature) {

            actor.attemptsTo(WaitUntil.the(GRILLA_PRODUCTO,isCurrentlyEnabled()).forNoMoreThan(18).seconds());
            actor.attemptsTo(JavaScriptClick.on(GRILLA_PRODUCTO));
            actor.attemptsTo(SeleccionarCategoria.delaCompra(data.get("Categoria")));
            helpers.delayElement(4);

            Target mostrarTodasCategorias = Target.the("Mas categorias").located(By.xpath("//*[contains(text(),'Más Por categoria')]"));
            actor.attemptsTo(WaitUntil.the(mostrarTodasCategorias,isCurrentlyEnabled()).forNoMoreThan(18).seconds());
            actor.attemptsTo(JavaScriptClick.on(mostrarTodasCategorias));
            helpers.delayElement(4);

            Target elementosListaProducto = Target.the("Lista de productos").located(By.xpath("//span[contains(text(),'"+data.get("Subcategoria")+"')]"));
            actor.attemptsTo(WaitUntil.the(elementosListaProducto,isCurrentlyEnabled()).forNoMoreThan(18).seconds());
            actor.attemptsTo(JavaScriptClick.on(elementosListaProducto));
            helpers.delayElement(4);

            WebElementFacade seleccionarProd = BrowseTheWeb.as(actor).find(By.xpath("//div[contains(text(),'"+data.get("Producto")+"')]//../../../../div//span[contains(text(),'Agregar')]"));
            actor.attemptsTo(JavaScriptClick.on(seleccionarProd));
            helpers.delayElement(4);

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
