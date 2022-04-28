package selenium.Ecorrea;

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
    public static WebDriver driver;
    //atributos localizadores
    By localizadorBtnJS = By.xpath("//button[@onclick = \"jsAlert()\"]");
    By localizadorBtnJSConfirmar = By.xpath("//button[@onclick = \"jsConfirm()\"]");
    By localizadorBtnPromp = By.xpath("//button[@onclick = \"jsPrompt()\"]");

    @BeforeClass
    public static void init(){WebDriverManager.chromedriver().setup();}

    @Before
    public void setUp(){
        //preparacion de Driver = Manager
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }
    @Test
    public void JsAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement botonJSAlert = driver.findElement(localizadorBtnJS);
        botonJSAlert.click();
        //movernos al popup = objeto Alert
        Alert jsAlert = driver.switchTo().alert();
        String textoPopUp = jsAlert.getText();
        if(textoPopUp.contains("I am a JS Alert")){
        jsAlert.accept();
        }



    }
    @Test
    public void jsConfrim(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement botonJSConfrim = driver.findElement(localizadorBtnJSConfirmar);
        botonJSConfrim.click();
        //movernos al popup = objeto Alert
        Alert jsAlert = driver.switchTo().alert();
        String textoPopUp = jsAlert.getText();
        if(textoPopUp.contains("I am a JS Confirm")) {
            jsAlert.dismiss();
            botonJSConfrim.click();
            jsAlert.accept();

        }




    }
    @Test
    public void jsPromp(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement botonJSPromp = driver.findElement(localizadorBtnPromp);
        botonJSPromp.click();
        //movernos al popup = objeto Alert
        Alert jsAlert = driver.switchTo().alert();
        String textoPopUp = jsAlert.getText();
        if(textoPopUp.contains("I am a JS prompt")) {
            jsAlert.sendKeys("hola estamos aprendiendo selenium");
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
