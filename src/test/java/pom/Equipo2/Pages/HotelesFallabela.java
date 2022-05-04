package pom.Equipo2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pom.Equipo2.Base.SeleniumBasePage;

public class HotelesFallabela extends SeleniumBasePage {
    public HotelesFallabela(WebDriver driver) {
        super(driver);
    }
    By habitaciones = By.xpath("(//aloha-radio-button[@name=\"roompack\"])[1]");
    By btnReservarAhora = By.xpath("//button[@class=\"eva-3-btn -md -secondary -eva-3-fwidth\"]");
    By actividad1 = By.xpath("(//button[@class=\"eva-3-btn -eva-3-fwidth -md -primary\"])[1]");
    By btnSiguiente = By.xpath("//button[@class=\"eva-3-btn -lg pricebox-sticky-button -secondary\"]");
    By preciototal = By.xpath("//span[@upaconceptname=\"priceboxContent-totalPrice-moneyTag\"]");




    public void seleccionarHabitaciones(){
        click(habitaciones);
    }
    public void reservarHabitacion(){
        click(btnReservarAhora);
    }
    public void seleccionarActividad(){
        scrollear(actividad1);
        click(actividad1);

    }

    public void clickBtnSiguiente(){
        click(btnSiguiente);
    }



}
