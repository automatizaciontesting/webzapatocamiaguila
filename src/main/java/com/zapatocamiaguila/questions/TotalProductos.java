package com.zapatocamiaguila.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.zapatocamiaguila.ui.HomeZapatoca.LBL_TOTAL_PRODUCTOS;

public class TotalProductos implements Question<String> {

    public static TotalProductos comprados() {
        return new TotalProductos();
    }

    @Override
    public String answeredBy(Actor actor) {
        return LBL_TOTAL_PRODUCTOS.resolveAllFor(actor).get(1).getText();
    }
}
