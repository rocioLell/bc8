package selenium.rhende;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Desafio<localizadorCalendario> {

    public static WebDriver driver;
    public By localizadorCalendario = By.xpath("//*[@class=\"_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show\"]");

    //By.ByXPath("//*[@class="_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show"]");

    @BeforeClass
    public static void init() {

        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        //preparacion de Driver ====> Navegador
        ChromeDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
/*
    @Test
    public void Calendario(){
        driver.get("https://www.viajesfalabella.cl/vuelos/");
        WebElement WebElementCalendario = driver.findElement(localizadorCalendario);

        Select manejoCalendario = new Select(WebElementCalendario);

        manejoCalendario.


    }
*/

    //cerramos la instancia del driver
   /* @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }*/

}
