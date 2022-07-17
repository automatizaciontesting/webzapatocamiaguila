package com.zapatocamiaguila.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.zapatocamiaguila.ui.HomeZapatoca.BTN_INGRESAR;
import static com.zapatocamiaguila.ui.LoginZapatoca.BTN_INGRESAR_LOGIN;
import static com.zapatocamiaguila.ui.LoginZapatoca.TXT_CORREO_ELECTRONICO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

public class SeleccionarCampo implements Task {

    public static SeleccionarCampo usuario() {
        return Tasks.instrumented(SeleccionarCampo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> elemento = BTN_INGRESAR.resolveAllFor(actor);
        actor.attemptsTo(WaitUntil.the(BTN_INGRESAR,isCurrentlyEnabled()).forNoMoreThan(10).seconds());
        actor.attemptsTo(JavaScriptClick.on(elemento.get(0)));
        actor.attemptsTo(Click.on(TXT_CORREO_ELECTRONICO));
        actor.attemptsTo(JavaScriptClick.on(BTN_INGRESAR_LOGIN));
    }
}
