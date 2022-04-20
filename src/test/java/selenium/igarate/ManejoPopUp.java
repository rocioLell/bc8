package selenium.igarate;

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
    public By localizadorBtnJS = By.xpath("//button[@onclick=\"jsAlert()\"]");
    public By LocalizadorBtnJSConfirm = By.xpath("//button[@onclick=\"jsConfirm()\"]");
    public By localizadorBtnPrompt = By.xpath("//button[@onclick=\"jsPrompt()\"]");

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setUp(){
        //preparar el driver
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void popupJsAlert(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnAlert = driver.findElement(localizadorBtnJS);
        btnAlert.click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals("I am a JS Alert")){
            alert.accept();
        }
    }

    @Test
    public void popupJsConfirm(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnConfirm = driver.findElement(LocalizadorBtnJSConfirm);
        btnConfirm.click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals("I am a JS Confirm")){
            alert.dismiss();
            btnConfirm.click();
            alert.accept();
        }
    }

    @Test
    public void popupJsPrompt(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnPrompt = driver.findElement(localizadorBtnPrompt);
        btnPrompt.click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals("I am a JS prompt")){
            alert.sendKeys("hola mundo");
            alert.accept();
        }
    }



    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}
