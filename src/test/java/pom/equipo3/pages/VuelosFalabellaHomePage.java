package pom.equipo3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo3.base.SeleniumBasePage;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.getAttribute;


public class VuelosFalabellaHomePage extends SeleniumBasePage {

    public void VuelosFalabellaTest(WebDriver driver){ super(driver);}
//identificar locators (page object model) o webElements (PageFactory Model)
    String url = "https://www.viajesfalabella.cl/vuelos/";
    By localizadorBtnCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    By localizadorOrigin = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-roundtrip-origin-input\" )]");
    By localizadorDestination= By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-roundtrip-destination-input\" )]");
    By localizadorDateStart = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-start-date-input\" )]");
    By localizadorAutocomplete = By.xpath("//li[@class=\"item -active\"]");
    By localizadorBtnNextDate = By.xpath("//div[@class = \"_dpmg2--controls-next\"]/descendant::i");
    By localizadorMonthActive = By.xpath("//div[contains(@class, \"_dpmg2--month-active\")]");
    By localizadorBtnAplicarDate = By.xpath("//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
    By localizadorDateEnd = By.xpath("//input[contains(@class, \"sbox-checkout-date\" )]");
    By localizadorMonthActiveRange = By.xpath("//div[contains(@class, \"_dpmg2--has-start-range\")]");

//funciones o acciones que podemos hacer en la web -> buscar en barra google

    public void irAHomePage(){
        goToUrl(url);
    }
    public void btnCookies(){
        click("BotonCookie");
    }
    public void ingresarDestino("París, Ile de France, Francia")
  {
      String destino;
      type(destino,localizadorDestination);
        click(localizadorAutocomplete);
    }
    public void ingresarFechaIda(int diaViajeIda, int añoViajeIda, int mesViajeIda ){
        click(localizadorDateStart);
        String monthInit = getAttribute(localizadorMonthActive,"data-month").split("-")[1];
        String yearInit = getAttribute(localizadorMonthActive,"data-month").split("-")[0];
        if (Integer.parseInt(yearInit) == añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i <= mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                click(localizadorBtnNextDate);
            }
        }
        else if (Integer.parseInt(yearInit) < añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i < 12 + mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                click(localizadorBtnNextDate);
            }
        }
        String dayDataIda = mesViajeIda > 9 ? añoViajeIda + "-"+ mesViajeIda : añoViajeIda+"-"+"0"+mesViajeIda;
        By localizadorDay = By.xpath("//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::span[text()=\""+diaViajeIda+"\"]");
        click(localizadorDay);
    }
    public void ingresarFechaVuelta(int diaViajeVuelta, int anioViajeVuelta, int mesViajeVuelta, int añoViajeIda, int mesViajeIda ) throws IOException {
        click(localizadorDateEnd);
        String monthInitVuelta = getAttribute((Path) localizadorMonthActiveRange,"data-month").split("-")[1];
        String yearInitVuelta = getAttribute((Path) localizadorMonthActiveRange,"data-month").split("-")[0];
        if (mesViajeIda<=mesViajeVuelta || añoViajeIda<=anioViajeVuelta){
            if (Integer.parseInt(yearInitVuelta) == anioViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i <= mesViajeVuelta  ; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    click(localizadorBtnNextDate);
                }
            }
            else if (Integer.parseInt(yearInitVuelta) < anioViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i < 12 + mesViajeVuelta; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    click(localizadorBtnNextDate);
                }
            }
        }
        String dayDataVuelta = mesViajeVuelta > 9 ? anioViajeVuelta + "-"+ mesViajeVuelta : anioViajeVuelta+"-"+"0"+mesViajeVuelta;
        By localizadorDay = By.xpath("//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"]");
        click(localizadorDay);
    }

    public void aplicarFecha(){
        click(localizadorBtnAplicarDate);
    }

    public void btnBuscar(); {
    }


}

