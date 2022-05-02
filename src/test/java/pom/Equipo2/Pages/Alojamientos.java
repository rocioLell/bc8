package pom.Equipo2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Equipo2.Base.SeleniumBasePage;

public class Alojamientos extends SeleniumBasePage {
    public Alojamientos(WebDriver driver) {
        super(driver);
    }
    String textoBusqueda = "qqq";
    By localizadorCalendarioEntrada = By.xpath("//input[@placeholder=\"Entrada\"]");
    By localizadorBtnBuscar = By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");
    By localizadorCheckbox = By.xpath("//label[@class=\"checkbox-label\"]");
    By localizadorBarraDeBusqueda = By.xpath("//input[@type=\"text\"]");
    By contenedor10del05 = By.xpath("//div[@data-month=\"2022-05\"] //descendant:: div[@class=\"_dpmg2--dates\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available\"] //descendant:: span[text()=\"10\"]");
    By contenedor20del05 = By.xpath("//div[@data-month=\"2022-05\"] //descendant:: div[@class=\"_dpmg2--dates\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available\"] //descendant:: span[text()=\"20\"]");
    By divHabitaciones = By.xpath("//div[@class=\"sbox-distri-container\"]");
    By localizadorMsjCookies = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");

    public void seleccionBarraBusqueda() {
        click(localizadorBarraDeBusqueda);
        type(textoBusqueda,localizadorBarraDeBusqueda);
    }
    public void mensajeCookies(){
        click(localizadorMsjCookies);
    }
    public void seleccionarCheckbox(){
        click(localizadorCheckbox);
    }
    public void seleccionarCalendario(){
        click(localizadorCalendarioEntrada);
    }
    public void seleccionarFecha1(){
        click(contenedor10del05);
    }
    public void seleccionarFecha2(){
        click(contenedor20del05);
    }
    public void clickBuscar(){
        click(localizadorBtnBuscar);
    }
}



