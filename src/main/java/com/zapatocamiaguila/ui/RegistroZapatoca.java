package com.zapatocamiaguila.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegistroZapatoca extends PageObject {

    public static final Target TXT_NOMBRE = Target.the("Nombre ingresado").located(By.xpath("//*[@placeholder='Escribe tu nombre']"));
    public static final Target TXT_PRIMER_APELLIDO = Target.the("Nombre apellido").located(By.xpath("//*[@placeholder='Escribe tu primer apellido']"));
    public static final Target TXT_SEGUNDO_APELLIDO = Target.the("Nombre segundo apellido").located(By.xpath("//*[@placeholder='Escribe tu segundo apellido']"));
    public static final Target CMB_TIPO_DOCUMENTO = Target.the("Tipo de documento").located(By.xpath("//*[contains(text(),'Tipo de documento')]/following::select[@aria-label='select-field']"));
    public static final Target TXT_DOCUMENTO = Target.the("Numero de documento").located(By.xpath("//*[@placeholder='1234567890']"));
    public static final Target TXT_CORREO_ELECTRONICO = Target.the("Ingreso email").located(By.xpath("//*[@placeholder='Escribe tu correo electrónico']"));
    public static final Target TXT_TELEFONO_CONTACTO = Target.the("Ingreso telefono contacto").located(By.xpath("//*[@placeholder='Escribe tu teléfono de contacto']"));
    public static final Target TXT_CLAVE = Target.the("Ingreso clave").located(By.xpath("//*[@placeholder='Escribe tu contraseña' and contains(@class,'controller__input')]"));
    public static final Target TXT_CONFIRMAR_CLAVE = Target.the("Ingreso confirmar clave").located(By.xpath("//*[@placeholder='Confirma tu contraseña' and contains(@class,'controller__input')]"));
    public static final Target CHK_ACEPTAR_POLITICAS = Target.the("Ingreso confirmar clave").located(By.xpath("//*[contains(text(),' Acepto la política de tratamientos de datos y términos de uso ')]"));
    public static final Target BTN_CREAR_CUENTA = Target.the("Ingreso confirmar clave").located(By.xpath("//button[@aria-label='Crear Cuenta']"));
    public static final Target BTN_CERRAR_TIPO_COMPRA = Target.the("Cerrar ventana tipo compra").located(By.xpath("//*[@class='overlay-delivery-panel max-w-full bottom']/div//*[name()='svg']"));
    public static final Target TXT_UBUCACION1_CASA = Target.the("Ubicacion de casa").located(By.xpath("//*[@placeholder='23A Sur']"));
    public static final Target TXT_UBUCACION2_CASA = Target.the("Numero manzana casa").located(By.xpath("//*[@placeholder='# 00']"));
    public static final Target TXT_UBUCACION3_CASA = Target.the("Numero de casa").located(By.xpath("//*[@placeholder='-00']"));
    public static final Target BTN_BUSCAR_DIRECCION = Target.the("Buscar direccion").located(By.xpath("//*[@aria-label='BUSCAR']"));
    public static final Target BTN_GUARDAR_DIRECCION = Target.the("Guardar direccion").located(By.xpath("//*[@aria-label='Guardar']"));

}
