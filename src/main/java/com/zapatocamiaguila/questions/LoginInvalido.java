package com.zapatocamiaguila.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.ArrayList;
import java.util.List;

import static com.zapatocamiaguila.ui.HomeZapatoca.BTN_INGRESAR;
import static com.zapatocamiaguila.ui.LoginZapatoca.LBL_EXCEPCIONES_LOGIN;

public class LoginInvalido implements Question<List<String>> {

    private static List<String> listadoExcepciones = new ArrayList<>();

    public static LoginInvalido camposRequeridos() {
        return new LoginInvalido();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        List<WebElementFacade> elemento = LBL_EXCEPCIONES_LOGIN.resolveAllFor(actor);
        for(WebElementFacade iteraDato:elemento){
            listadoExcepciones.add(iteraDato.getText());
        }
        return listadoExcepciones;
    }
}
