package selenium.Ecorrea;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class paginaDePrueba {
    private WebDriver driver;
    By localizadordeLink = By.linkText("REGISTER");
    By localizadordeRegistro = By.xpath("//img[@src =\"images/mast_register.gif\"]");
    By locacionDeNombre = By.id("email");
    By locacionDePasword = By.name("password");
    By locacionDeConfirmacionDePasword = By.name("confirmPassword");
    By registrodeboton = By.xpath("//input[@name=\"submit\"]");
    By inserteNombre = By.name("userName");
    By insertePasword = By.name("password");
    By BtnIngresoDatos = By.name("submit");
    By paginadelogin = By.xpath("//img[@src=\"images/mast_flightfinder.gif\"]");
    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();


    }
    @Before
    public void setUp(){
        //preparacion de Driver = Manager
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/index.php");//es la pagina que abrira el navegador

    }
    @Test
    public void registerUse() throws InterruptedException {
        driver.findElement(localizadordeLink).click();
        Thread.sleep(2000);
        if(driver.findElement(localizadordeRegistro).isDisplayed())
        {
            driver.findElement(locacionDeNombre).sendKeys("Eduardo");
            driver.findElement(locacionDePasword).sendKeys("1234");
            driver.findElement(locacionDeConfirmacionDePasword).sendKeys("1234");
            driver.findElement(BtnIngresoDatos).click();
            Thread.sleep(2000);
            assertTrue(driver.findElement(paginadelogin).isDisplayed());
        }
        else {

            System.out.println("registro no encontrado");
        }
        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        assertEquals("Note: Your user name is qualityadmin.",fonts.get(5).getText());



    }
    @Test
    public void ingresoRegistro() throws InterruptedException {

        if (driver.findElement(inserteNombre).isDisplayed()){
        driver.findElement(inserteNombre).sendKeys("Eduardo");
            driver.findElement(insertePasword).sendKeys("1234");
            driver.findElement(registrodeboton).click();
            Thread.sleep(2000);
            assertTrue(driver.findElement(paginadelogin).isDisplayed());}
        else {

            System.out.println("username textbox was not present");
        }



    }


    @After
    public void tearDown(){
        if (driver != null) {
            driver.close();
        }

    }
}
