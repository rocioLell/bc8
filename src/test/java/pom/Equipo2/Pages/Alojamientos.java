package pom.Equipo2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Equipo2.Base.SeleniumBasePage;

import java.util.Set;

public class Alojamientos extends SeleniumBasePage {
    public Alojamientos(WebDriver driver) {
        super(driver);
    }
    String textoBusqueda1 = "qqq";
    String textobusqueda2 = "Lima, Lima, Perú";
    By localizadorCalendarioEntrada = By.xpath("//input[@placeholder=\"Entrada\"]");
    By flechaNext = By.xpath("//div[@class=\"_dpmg2--controls-next\"]");
    By localizadorBtnBuscar = By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");
    By localizadorCheckbox = By.xpath("//label[@class=\"checkbox-label\"]");
    By localizadorBarraDeBusqueda = By.xpath("//input[@type=\"text\"]");
    By resultadoBusqueda1 = By.xpath("(//ul[contains(li,perú)])[13]");
    By fechaEntrada2 = By.xpath("//div[@data-month=\"2022-05\"] //descendant:: div[@class=\"_dpmg2--dates\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available\"] //descendant:: span[text()=\"10\"]");
    By fechaSalida2 = By.xpath("//div[@data-month=\"2022-05\"] //descendant:: div[@class=\"_dpmg2--dates\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available\"] //descendant:: span[text()=\"20\"]");
    By fechaEntrada1 = By.xpath("//div[@data-month=\"2022-08\"] //descendant:: div[@class=\"_dpmg2--dates\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available\"] //descendant:: span[text()=\"1\"]");
    By fechaSalida1 = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div._dpmg2--month._dpmg2--o-1._dpmg2--month-active > div._dpmg2--dates > span:nth-child(7)");
    By divHabitaciones = By.xpath("//div[@class=\"sbox-distri-container\"]");
    By cantDeAdultos = By.xpath("(//a[@class=\"steppers-icon-left sbox-3-icon-minus\"])[1]");
    By localizadorMsjCookies = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    By localizadorOpcion1 = By.xpath("(//em[text()=\"Ver detalle\"])[1]");

    public void seleccionBarraBusqueda() {
        click(localizadorBarraDeBusqueda);

    }
    public void ecribirEnBarraBusqueda(){
        type(textoBusqueda1,localizadorBarraDeBusqueda);

    }
    public void escribirEnBarraBusqueda2(){
        type(textobusqueda2,localizadorBarraDeBusqueda);
        click(resultadoBusqueda1);
    }

    public void cerrarMensajeCookies(){
        click(localizadorMsjCookies);
    }
    public void seleccionarCheckbox(){
        click(localizadorCheckbox);
    }
    public void seleccionarCalendario(){
        click(localizadorCalendarioEntrada);
    }
    public void seleccionarFecha1(){
        click(fechaEntrada2);
        click(fechaSalida2);
    }
    public void seleccionarFecha2(){
        click(flechaNext);
        click(flechaNext);
        click(flechaNext);
        click(fechaEntrada1);
        click(fechaSalida1);
    }
    public void cantidadDeHabitaciones(){
        click(divHabitaciones);
    }
    public void cantidadDeAdultos(){
        click(cantDeAdultos);
    }
    public void clickBuscar(){
        click(localizadorBtnBuscar);
    }
    public void seleccionarHotel(){
        click(localizadorOpcion1);
    }
    public void cambioDePestaña(){
        String mainTab = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(mainTab)) {
                driver.switchTo().window(actual);
            }

        }
    }
}



