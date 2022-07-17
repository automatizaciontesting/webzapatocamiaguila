package com.zapatocamiaguila.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CategoriaProductos extends PageObject {
    public static final Target CONTENEDOR_DIRECCIONES = Target.the("Seleccionar direccion").located(By.xpath("//*[@class='locations-list']/div//p"));
    public static final Target BTN_CERRAR_CARRITO = Target.the("Cerrar ventana carrito compras").located(By.xpath("//*[@aria-label='cancel']"));

}
