package com.zapatocamiaguila.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.zapatocamiaguila.ui.HomeZapatoca.BTN_INGRESAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarCategoria implements Interaction {

    private String categoriaProducto;
    public SeleccionarCategoria(String categoriaProducto){
        this.categoriaProducto=categoriaProducto;
    }

    public static SeleccionarCategoria delaCompra(String categoriaProducto) {
        return Tasks.instrumented(SeleccionarCategoria.class,categoriaProducto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> elementosWeb = BrowseTheWeb.as(actor).findAll("//*[@class='menu-categories bg-white is-fixed']//a[contains(text(),'"+categoriaProducto+"')]");
        for(WebElementFacade elemento : elementosWeb){
            if(elemento.isClickable()){
                elemento.click();
                break;
            }
        }

    }

}
