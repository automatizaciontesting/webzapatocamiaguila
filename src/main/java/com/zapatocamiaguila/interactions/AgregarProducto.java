package com.zapatocamiaguila.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;

public class AgregarProducto implements Interaction {

    private String producto;
    public AgregarProducto(String producto){
        this.producto=producto;
    }
    public static AgregarProducto alCarritoDeCompras(String producto) {
        return Tasks.instrumented(AgregarProducto.class,producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade seleccionarProd = BrowseTheWeb.as(actor).find(By.xpath("//div[normalize-space(text()) = '"+producto+"']//../../../../div//span[contains(text(),'Agregar')]"));
        actor.attemptsTo(Scroll.to(seleccionarProd).andAlignToBottom());
        actor.attemptsTo(JavaScriptClick.on(seleccionarProd));
    }
}
