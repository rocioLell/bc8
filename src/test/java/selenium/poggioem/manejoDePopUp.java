package selenium.poggioem;
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


public class manejoDePopUp {

    public static WebDriver driver;
    By localizadorButtonJSalert1 = By.xpath("//button[@onclick=\"jsAlert()\"]");
    By LocalizadorButtonJSalert2 = By.xpath("//button[@onclick=\"jsConfirm()\"]");
    By LocalizadorButtonJSalert3 = By.xpath("//button[@onclick=\"jsPrompt()\"]");

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){ //preparacio driver = navegador
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void popUp1(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buttonAlertJS = driver.findElement(localizadorButtonJSalert1);
        buttonAlertJS.click();

        //Alert de selenium para acceder a los popUp y movernos en el.
        Alert jsAlert =  driver.switchTo().alert();
        String textPopUp = jsAlert.getText();
        if (textPopUp.contains("I am a JS Alert")){
            jsAlert.accept();
        }
    }
    @Test
    public void popUp2(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buttonAlertJSConfirm = driver.findElement(LocalizadorButtonJSalert2);
        buttonAlertJSConfirm.click();

        Alert jsAlert =  driver.switchTo().alert();
        String textPopUp = jsAlert.getText();
        if (textPopUp.contains("I am a JS Confirm")){
            jsAlert.dismiss();
            buttonAlertJSConfirm.click();
            jsAlert.accept();
        }
    }
    @Test
    public void popUp3(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buttonAlertJSPrompt= driver.findElement(LocalizadorButtonJSalert3);
        buttonAlertJSPrompt.click();
        Alert jsAlert =  driver.switchTo().alert();
        String textPopUp = jsAlert.getText();
        if (textPopUp.contains("I am a JS prompt")){
            jsAlert.sendKeys("Hola mundo, desde un pop up");
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
