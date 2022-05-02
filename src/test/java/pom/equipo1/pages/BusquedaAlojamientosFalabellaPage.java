package pom.equipo1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo1.base.SeleniumBasePage;

public class BusquedaAlojamientosFalabellaPage extends SeleniumBasePage {

    public BusquedaAlojamientosFalabellaPage(WebDriver driver) {
        super(driver);
    }

    //identificar locators (page object model) o webElements (PageFactory Model)
    String url = "https://www.viajesfalabella.cl/hoteles";
    By localizadorBtnCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    By localizadorDestination= By.xpath("//input[contains(@class, \"sbox-destination\")]");
    By localizadorDateStart = By.xpath("//input[contains(@class, \"sbox-checkin-date\" )]");
    By localizadorDateEnd = By.xpath("//input[contains(@class, \"sbox-checkout-date\" )]");
    By localizadorAutocomplete = By.xpath("(//span[@class=\"item-text\"])[1]");
    By localizadorBtnNextDate = By.xpath("(//div[@class = \"_dpmg2--controls-next\"]/descendant::i)");
    By localizadorMonthActive = By.xpath("//div[contains(@class, \"_dpmg2--month-active\")]");
    By localizadorMonthActiveRange = By.xpath("//div[contains(@class, \"_dpmg2--has-start-range\")]");
    By localizadorBtnAplicarDate = By.xpath("//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
    By localizadorBtnBuscar = By.xpath("(//div [@class = \"sbox-button-container\"] )[1]");

    //funciones o acciones que podemos hacer en la web -> buscar en barra google
    public void irAlojamientosFalabella(){
        goToUrl(url);
    }
    public void aceptarCookies(){
        if(isDisplayed(localizadorBtnCookie)){
            click(localizadorBtnCookie);
        }
    }
    public void ingresarDestino(String destino){
        type(destino,localizadorDestination);
        click(localizadorAutocomplete);
    }
    
    public void ingresarFechaIda(int diaViajeIda, int añoViajeIda, int mesViajeIda ){
        click(localizadorDateStart);
        WebElement mesActual = findElement(localizadorMonthActive);
        String monthInit = mesActual.getAttribute("data-month").split("-")[1];
        String yearInit = mesActual.getAttribute("data-month").split("-")[0];
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

    public void ingresarFechaVuelta(int diaViajeVuelta, int anioViajeVuelta, int mesViajeVuelta, int añoViajeIda, int mesViajeIda ){
        click(localizadorDateEnd);
        WebElement mesActualVuelta = findElement(localizadorMonthActiveRange);
        String monthInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[1];
        String yearInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[0];
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

    public void buscarAlojamiento(){
        click(localizadorBtnBuscar);
    }
    
}
