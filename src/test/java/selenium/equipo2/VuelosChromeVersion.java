package selenium.equipo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VuelosChromeVersion {
    public static WebDriver driver;


    public By vuelo = By.xpath("//a[@class=\"shifu-3-button-circle FLIGHTS paint-circle \"]");
    public By multidestino = By.xpath("//span[@class=\"sbox-3-radio -md sbox-radio-button -ml5\"][2]");
    public By soloIda= By.xpath("//span[@class=\"sbox-3-radio -md sbox-radio-button -ml5\"][1]");
    public  By origen= By.xpath("//input[@placeholder=\"Ingresa desde dónde viajas\"]");
    public  By destino= By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-destination-input sbox-secondary sbox-places-second places-inline\"]");
    public By resultado=By.xpath("//span[@class=\"item-text\"]");
    public By sinFecha= By.xpath("//i[@class=\"checkbox-check sbox-3-icon-checkmark -mr1 sbox-ui-icon\"]");
    public By buscar= By.xpath("//div[@class=\"sbox-button-container\"]");
    public By siguiente= By.xpath("//div[@class=\"container-next-step -eva-3-bold text-next -eva-3-pt-sm -eva-3-pr-sm -eva-3-pb-sm -eva-3-pl-lg\"]");





    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void ATC01() {
        //ingresar a la Pagina
        driver.get("https://www.viajesfalabella.cl/");
        // Ingresar al Apartado  Vuelo
        WebElement webElementVuelo = driver.findElement(vuelo);
        webElementVuelo.click();
        // Seleccionar Multidestino
        WebElement webElementMultidestino= driver.findElement(multidestino);
        webElementMultidestino.click();

    }
    @Test
    public void ATC02() {

        //ingresar a la Pagina
        driver.get("https://www.viajesfalabella.cl/");

        //Seleccionar el Apartado Vuelo
        WebElement webElementVuelo = driver.findElement(vuelo);
        webElementVuelo.click();

        //Seleccionar Solo Ida
        WebElement webElementSoloIda= driver.findElement(soloIda);
        webElementSoloIda.click();

        //Ingresaer Origen
        WebElement webElementOrigen= driver.findElement(origen);
        webElementOrigen.sendKeys("Santiago de Chile, Chile");
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));
        WebElement webElementResultado= driver.findElement(resultado);
        webElementResultado.click();

        // Ingresar Destino
        WebElement webElementDestino= driver.findElement(destino);
        webElementDestino.sendKeys("Buenos Aires, Argentina");
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));
        webElementResultado.click();

        //Seleccionar Fecha
        WebElement webElementSinFecha= driver.findElement(sinFecha);
        webElementSinFecha.click();

        //buscar Vuelo
        WebElement webElementBuscar= driver.findElement(buscar);
        webElementBuscar.click();

        // Seleccionar Vuelo
        WebElement webElementSiguiente= driver.findElement(siguiente);
        webElementSiguiente.click();


    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}

