package selenium.morona.Desafio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlojamientosTest {

    public static WebDriver driver;
    public By localizadorAlojamientosLink = By.xpath("//a[@href=\"//www.viajesfalabella.cl/hoteles\"]");
    public By localizadorBarraDeBusqueda = By.xpath("//input[@type=\"text\"]");
    public By localizadorCheckbox = By.xpath("//label[@class=\"checkbox-label\"]");
    public By localizadorBtnBuscar = By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        //preparacion de Driver = Navegador
        driver = new ChromeDriver(); //Chrome -> navegador
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void busquedaConDestinoInexistente() {
        //Ingresamos a la página
        driver.get("https://www.viajesfalabella.cl/");

        //Nos dirigimos al apartado Alojamientos
        WebElement seccionAlojamientos = driver.findElement(localizadorAlojamientosLink);
        seccionAlojamientos.click();

        //Seleccionamos la Checkbox
        WebElement checkBoxTnDF = driver.findElement(localizadorCheckbox);
        checkBoxTnDF.click();

        //Ingresamos la búsqueda
        WebElement barraDeBusqueda = driver.findElement(localizadorBarraDeBusqueda);
        barraDeBusqueda.click();
        barraDeBusqueda.sendKeys("qqq");

        //Click en Buscar
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();

    }


    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
