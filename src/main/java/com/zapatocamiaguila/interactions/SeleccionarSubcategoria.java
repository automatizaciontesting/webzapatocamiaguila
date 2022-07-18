package com.zapatocamiaguila.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;

public class SeleccionarSubcategoria implements Interaction {
    private String subcategoria;
    public SeleccionarSubcategoria(String subcategoria){
        this.subcategoria=subcategoria;
    }
    public static SeleccionarSubcategoria delProducto(String subcategoria) {
        return Tasks.instrumented(SeleccionarSubcategoria.class,subcategoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target elementosListaProducto = Target.the("Lista de productos").located(By.xpath("//span[normalize-space(text()) = '"+subcategoria+"']"));
        actor.attemptsTo(WaitUntil.the(elementosListaProducto,isCurrentlyEnabled()).forNoMoreThan(18).seconds());
        actor.attemptsTo(JavaScriptClick.on(elementosListaProducto));
    }
}
