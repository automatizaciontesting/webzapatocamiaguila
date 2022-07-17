package com.zapatocamiaguila.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.zapatocamiaguila.ui.HomeZapatoca.BTN_INGRESAR;
import static com.zapatocamiaguila.ui.HomeZapatoca.LBL_USUARIO_LOGUEADO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

public class EstaLogueado implements Question<Boolean> {

    public static EstaLogueado enLaPagina() {
        return new EstaLogueado();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_USUARIO_LOGUEADO.resolveAllFor(actor).get(0).isEnabled();
    }

}
