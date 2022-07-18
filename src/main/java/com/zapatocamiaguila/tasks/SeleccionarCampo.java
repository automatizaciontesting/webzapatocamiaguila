package com.zapatocamiaguila.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.zapatocamiaguila.ui.HomeZapatoca.BTN_INGRESAR;
import static com.zapatocamiaguila.ui.LoginZapatoca.BTN_INGRESAR_LOGIN;
import static com.zapatocamiaguila.ui.LoginZapatoca.*;
import static com.zapatocamiaguila.ui.RegistroZapatoca.BTN_CERRAR_TIPO_COMPRA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

public class SeleccionarCampo implements Task {

    public static SeleccionarCampo usuario() {
        return Tasks.instrumented(SeleccionarCampo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> elemento = BTN_INGRESAR.resolveAllFor(actor);
        actor.attemptsTo(Click.on(BTN_CERRAR_TIPO_COMPRA));
        actor.attemptsTo(WaitUntil.the(BTN_INGRESAR,isCurrentlyEnabled()).forNoMoreThan(10).seconds());
        actor.attemptsTo(JavaScriptClick.on(elemento.get(0)));
        actor.attemptsTo(Enter.keyValues(Keys.ENTER).into(TXT_CORREO_ELECTRONICO));
        actor.attemptsTo(Click.on(TXT_CLAVE));
        actor.attemptsTo(JavaScriptClick.on(BTN_INGRESAR_LOGIN));
        actor.attemptsTo(Enter.keyValues(Keys.ENTER).into(TXT_CORREO_ELECTRONICO));
    }
}
