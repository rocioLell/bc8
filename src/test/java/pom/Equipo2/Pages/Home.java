package pom.Equipo2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Equipo2.Base.SeleniumBasePage;

public class Home extends SeleniumBasePage {
    public Home(WebDriver driver) {
        super(driver);
    }

    String url = "https://www.viajesfalabella.cl/";
    By alojamientos = By.xpath("//label[text()=\"Alojamientos\"]");
    By paquetes = By.xpath("//label[text()=\"Paquetes\"]");
    By vuelos = By.xpath("//label[text()=\"Vuelos\"]");

 public void irAHome(){
     goToUrl(url);
 }
 public void irAAlojamientos(){
     click(alojamientos);
 }
 public void irAPaquetes(){
     click(paquetes);
 }
 public void irAVuelos(){
     click(vuelos);
 }

}
