package com.zapatocamiaguila.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.zapatocamiaguila.ui.CategoriaProductos.LBL_MOSTRAR_CATEGORIAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

public class MostarMas implements Interaction {

    public static MostarMas porCategoria() {
        return Tasks.instrumented(MostarMas.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LBL_MOSTRAR_CATEGORIAS,isCurrentlyEnabled()).forNoMoreThan(18).seconds());
        actor.attemptsTo(JavaScriptClick.on(LBL_MOSTRAR_CATEGORIAS));
    }
}
