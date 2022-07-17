package com.zapatocamiaguila.tasks;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

import static com.zapatocamiaguila.ui.RegistroZapatoca.*;

public class IngresarCredenciale implements Task {

    List<Map<String, String>> datosFeature;
    private String nombre;
    private String primerNombre;
    private String segundoNombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String correoElectrinico;
    private String numeroContacto;
    private String clave;
    private String ciudad;
    private String ubicacionCasa;
    private String numeroUbicacionCasa;
    private String numeroManzana;
    private String numeroCasa;



    public IngresarCredenciale(DataTable dataTable){

        datosFeature = dataTable.asMaps(String.class, String.class);
        this.nombre=datosFeature.get(0).get("Nombre");
        this.primerNombre = datosFeature.get(0).get("Apellido");
        this.segundoNombre = datosFeature.get(0).get("SegundoApellido");
        this.tipoDocumento = datosFeature.get(0).get("Documento");
        this.numeroDocumento = datosFeature.get(0).get("NumeroDocumento");
        this.correoElectrinico = datosFeature.get(0).get("CorreoElectronico");
        this.numeroContacto = datosFeature.get(0).get("TelContacto");
        this.clave = datosFeature.get(0).get("Clave");
        this.ciudad=datosFeature.get(0).get("Ciudad");
        this.ubicacionCasa=datosFeature.get(0).get("Ubicacion");
        this.numeroUbicacionCasa=datosFeature.get(0).get("Dato1Ubicacion");
        this.numeroManzana=datosFeature.get(0).get("Dato2Ubicacion");
        this.numeroCasa=datosFeature.get(0).get("Dato3Ubicacion");
    }
    public static IngresarCredenciale creacionUsuario(DataTable dataTable) {
        return Tasks.instrumented(IngresarCredenciale.class,dataTable);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade elemento = CMB_TIPO_DOCUMENTO.resolveFor(actor);

        actor.attemptsTo(Click.on(BTN_CERRAR_TIPO_COMPRA),
                Enter.theValue(nombre).into(TXT_NOMBRE),
                Enter.theValue(primerNombre).into(TXT_PRIMER_APELLIDO),
                Enter.theValue(segundoNombre).into(TXT_SEGUNDO_APELLIDO)
                );
        actor.attemptsTo(Scroll.to(TXT_DOCUMENTO).andAlignToBottom());
        elemento.click();
        elemento.selectByVisibleText(tipoDocumento).click();
        actor.attemptsTo(
                Enter.theValue(numeroDocumento).into(TXT_DOCUMENTO),
                Enter.theValue(correoElectrinico).into(TXT_CORREO_ELECTRONICO),
                Enter.theValue(numeroContacto).into(TXT_TELEFONO_CONTACTO),
                Enter.theValue(clave).into(TXT_CLAVE),
                Enter.theValue(clave).into(TXT_CONFIRMAR_CLAVE),
                JavaScriptClick.on(CHK_ACEPTAR_POLITICAS),
                JavaScriptClick.on(BTN_CREAR_CUENTA)
        );

        WebElementFacade cmbCiudad = BrowseTheWeb.as(actor).find(By.xpath("//*[@placeholder='Seleccione una ciudad']"));
        cmbCiudad.sendKeys(ciudad,Keys.ARROW_DOWN,Keys.ENTER);

        List<WebElementFacade> cmbUbicacion1 = BrowseTheWeb.as(actor).findAll(By.xpath("//*[@aria-label='select-field']/option[@value='Calle']//.."));
        cmbUbicacion1.get(0).click();
        cmbUbicacion1.get(0).selectByVisibleText(ubicacionCasa).click();
        actor.attemptsTo(
                Enter.theValue(numeroUbicacionCasa).into(TXT_UBUCACION1_CASA),
                Enter.theValue(numeroManzana).into(TXT_UBUCACION2_CASA),
                Enter.theValue(numeroCasa).into(TXT_UBUCACION3_CASA),
                Click.on(BTN_BUSCAR_DIRECCION),
                Click.on(BTN_GUARDAR_DIRECCION)
        );
        actor.attemptsTo(
                Click.on(BTN_CREAR_CUENTA)
        );
    }
}
