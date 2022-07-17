package com.zapatocamiaguila.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.zapatocamiaguila.ui.HomeZapatoca.LBL_USUARIO;

public class CuentaCreada implements Question<Boolean> {

    public static CuentaCreada deFormaExitosa() {
        return new CuentaCreada();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> usuarioVisible = LBL_USUARIO.resolveAllFor(actor);
        return usuarioVisible.get(1).isVisible();
    }
}
