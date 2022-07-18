package com.zapatocamiaguila.tasks;

import com.zapatocamiaguila.utils.Helpers;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static com.zapatocamiaguila.ui.HomeZapatoca.BTN_INGRESAR;
import static com.zapatocamiaguila.ui.LoginZapatoca.*;
import static com.zapatocamiaguila.ui.RegistroZapatoca.BTN_CERRAR_TIPO_COMPRA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

public class IngresarEnLogueo implements Task {
    Helpers helpers = new Helpers();
    private String usuario;
    private String clave;

    public IngresarEnLogueo (DataTable dataTable){
        List<Map<String, String>> datosFeature = dataTable.asMaps(String.class, String.class);
        this.usuario = datosFeature.get(0).get("Usuario");;
        this.clave = datosFeature.get(0).get("Clave");;
    }

    public static IngresarEnLogueo lasCredencialesDeUsuario(DataTable dataTable) {
        return Tasks.instrumented(IngresarEnLogueo.class,dataTable);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        /*acciones escribir, seleccionar*/

        List<WebElementFacade> elemento = BTN_INGRESAR.resolveAllFor(actor);
        actor.attemptsTo(WaitUntil.the(BTN_INGRESAR,isCurrentlyEnabled()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Click.on(BTN_CERRAR_TIPO_COMPRA));
        actor.attemptsTo(JavaScriptClick.on(elemento.get(0)));
        actor.attemptsTo(WaitUntil.the(TXT_CORREO_ELECTRONICO,isCurrentlyEnabled()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Enter.theValue(usuario).into(TXT_CORREO_ELECTRONICO));
        actor.attemptsTo(Enter.keyValues(clave).into(TXT_CLAVE));
        actor.attemptsTo(JavaScriptClick.on(BTN_INGRESAR_LOGIN));
        helpers.delayElement(8);
    }
}
