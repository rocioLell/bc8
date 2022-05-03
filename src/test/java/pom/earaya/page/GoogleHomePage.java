package pom.earaya.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.earaya.base.SeleniumBasePage;

public class GoogleHomePage extends SeleniumBasePage{

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    //identificar locators (page object model) o webElements (PageFactory Model)
    String url = "https://www.google.com";
    By barraGoogle = By.xpath("//*[@name='q']");
    By btnGoogle = By.xpath("//*[@name='btnK']");

    //funciones o acciones que podemos hacer en la web -> buscar en barra google
    public void irAHomePage(){
        goToUrl(url);
    }
    public void buscarTexto(String texto){
        type(texto,barraGoogle);
    }
    public void clickBtnBarraGoogle(){
        click(btnGoogle);
    }

}
