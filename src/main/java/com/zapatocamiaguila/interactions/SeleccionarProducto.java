package com.zapatocamiaguila.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.zapatocamiaguila.ui.HomeZapatoca.GRILLA_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

public class SeleccionarProducto implements Interaction {
    private String categoria;
    public SeleccionarProducto(String categoria){
        this.categoria=categoria;
    }

    public static SeleccionarProducto deLaCategoria(String categoria) {
        return Tasks.instrumented(SeleccionarProducto.class,categoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(GRILLA_PRODUCTO,isCurrentlyEnabled()).forNoMoreThan(18).seconds());
        actor.attemptsTo(JavaScriptClick.on(GRILLA_PRODUCTO));
        actor.attemptsTo(SeleccionarCategoria.delaCompra(categoria));
    }
}
