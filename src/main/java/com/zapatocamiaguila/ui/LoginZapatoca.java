package com.zapatocamiaguila.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginZapatoca extends PageObject {

    public static final Target TXT_CORREO_ELECTRONICO = Target.the("Ingreso correo electrinico").located(By.xpath("//*[@type='email']"));
    public static final Target TXT_CLAVE = Target.the("Ingreso clave").located(By.xpath("//*[@type='password']"));
    public static final Target BTN_INGRESAR_LOGIN = Target.the("Boton ingresar").located(By.xpath("//*[@data-role='login_button']"));
    public static final Target LBL_EXCEPCIONES_LOGIN = Target.the("Lista excepciones").located(By.xpath("//*[@class='input__error text-left text-medium-negative text-xs']"));

}
