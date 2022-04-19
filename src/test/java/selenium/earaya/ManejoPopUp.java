package selenium.earaya;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManejoPopUp {

    WebDriver driver;
    //atributos
    By localizadorBotonJs = By.xpath("//button[@onclick=\"jsAlert()\"]");
    By localizadorBotonJsConfirm = By.xpath("//button[@onclick=\"jsConfirm()\"]");
    By localizadorBotonJsPrompt = By.xpath("//button[@onclick=\"jsPrompt()\"]");

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        //preparacion de Driver = Navegador
        driver = new ChromeDriver(); //Chrome -> navegador
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void popupJsAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement botonJSAlert = driver.findElement(localizadorBotonJs);
        botonJSAlert.click();

        //movernos (switchTo) al popup -> Alert
        Alert jsAlert = driver.switchTo().alert();
        String textoPopup = jsAlert.getText();
        if(textoPopup.contains("I am a JS Alert")){
            jsAlert.accept();
        }

    }

    @Test
    public void popupJsConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement botonJSConfirm = driver.findElement(localizadorBotonJsConfirm);
        botonJSConfirm.click();

        //movernos (switchTo) al popup -> Alert
        Alert jsAlert = driver.switchTo().alert();
        String textoPopup = jsAlert.getText();
        if(textoPopup.contains("I am a JS Confirm")){
            jsAlert.dismiss();
            botonJSConfirm.click();
            jsAlert.accept();
        }

    }
    @Test
    public void popupJsPrompt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement botonJSAlert = driver.findElement(localizadorBotonJsPrompt);
        botonJSAlert.click();

        //movernos (switchTo) al popup -> Alert
        Alert jsAlert = driver.switchTo().alert();
        String textoPopup = jsAlert.getText();
        if(textoPopup.contains("I am a JS prompt")){
            jsAlert.sendKeys("Hola estamos aprendiendo Selenium");
            jsAlert.accept();
        }

    }




    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

}

