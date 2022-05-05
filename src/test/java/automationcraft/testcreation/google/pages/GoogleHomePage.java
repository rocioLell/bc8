package automationcraft.testcreation.google.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends SeleniumBase {
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    //Atributos de la pagina
    String URLHOME = "http://www.google.com";
    By searchBox = By.name("q");
    By bntK = By.name("bntK");

    //funcionalidad
    public void irAGoogleHome(){
        goToUrl(URLHOME);
    }

    public void insertarTextoEnSearchBox(String text){
        type(text,searchBox);
    }

    public void clickearBtnBusqueda(){
        click(bntK);
    }


}
