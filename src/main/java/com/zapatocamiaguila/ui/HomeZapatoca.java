package com.zapatocamiaguila.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomeZapatoca extends PageObject {
    
    public static final Target BTN_INGRESAR = Target.the("Botón ingresar").located(By.xpath("//*[contains(text(),'Ingresar')]"));
    public static final Target LBL_USUARIO_LOGUEADO = Target.the("Logueado").located(By.xpath("//*[@class='text-sm font-semi-bold leading-tight']"));
    public static final Target GRILLA_PRODUCTO = Target.the("Logueado").located(By.xpath("//*[name()='svg']/following::span[contains(text(),'Categorías')]"));
    public static final Target LBL_USUARIO = Target.the("Usuario creado").located(By.xpath("//*[@class='text-sm font-semi-bold leading-tight hidden lg:flex' and contains(text(),'Hola')]"));

}
