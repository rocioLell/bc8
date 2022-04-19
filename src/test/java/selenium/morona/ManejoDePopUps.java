package selenium.morona;

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

public class ManejoDePopUps {
    //atributos
    public static WebDriver driver;
    public By localizadorBtnJs = By.xpath("//button[@onclick=\"jsAlert()\"]");
    public By localizadorBtnJsConfirm = By.xpath("//button[@onclick=\"jsConfirm()\"]");
    public By localizadorBtnJsPromt = By.xpath("//button[@onclick=\"jsPrompt()\"]");
    public By localizadorBtnPDF = By.xpath("//a[@href=\"/download/jqueryui/menu/menu.pdf\"]");
    public By localizadoresCheckBoxes = By.xpath("//form[@id=\"checkboxes\"]//input");
    public By localizadorIframes = By.tagName("iframe");
    public By localizadorDeEditorTexto= By.id("tinymce");
    public By localizadorDeWebTable= By.tagName("table");



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
    public void popUpJsAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement botonJs = driver.findElement(localizadorBtnJs);
        botonJs.click();

        //movernos al popup
        Alert jsAlert = driver.switchTo().alert();
        String textoPopUp = jsAlert.getText();
        if (textoPopUp.contains("I am a JS Alert")){
            jsAlert.accept();
        }

    }
    @Test
    public void popUpJsConfirm(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement botonJsConfirm = driver.findElement(localizadorBtnJsConfirm);
        botonJsConfirm.click();

        //movernos al popup
        Alert jsConfirm = driver.switchTo().alert();
        String textoPopUp = jsConfirm.getText();
        if (textoPopUp.contains("I am a JS Confirm")){
            jsConfirm.dismiss();
            botonJsConfirm.click();
            jsConfirm.accept();

        }
    }
    @Test
    public void popUpJsPromt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement botonJsPrompt = driver.findElement(localizadorBtnJsPromt);
        botonJsPrompt.click();

        //movernos al popup
        Alert jsPrompt = driver.switchTo().alert();
        String textoPopUp = jsPrompt.getText();
        if (textoPopUp.contains("I am a JS prompt")){
            jsPrompt.sendKeys("Hola estamos aprendiendo selenium");
            jsPrompt.accept();
        }
    }



    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }


}
