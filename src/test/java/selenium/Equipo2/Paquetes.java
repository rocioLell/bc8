package selenium.Equipo2;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

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


public class Paquetes {
    //atributos
    public static WebDriver driver;


    public By paquete = By.xpath("//i[@title=\"Paquetes\"]");
    public By vueloAlojamiento= By.xpath("//input[@class=\"sbox-bundle-input sbox-radio-vh sbox-radio-selected-box\"]");
    public By origen= By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline\"]\n");
    public By destino= By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline\"]");
    public By resultado=By.xpath("//span[@class=\"item-text\"]");
    public By fechaIda= By.xpath("//input[@class=\"input-tag sbox-checkin-date\"]");
    public By seleccionIda=By.xpath("//div[@class=\"_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show\"] //descendant:: div[@data-month=\"2022-05\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available\"] //descendant:: span[text()=\"10\"]");
    public By contenedor20del05 = By.xpath("//div[@class=\"_dpmg2--month _dpmg2--o-7 _dpmg2--has-start-range _dpmg2--month-active\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip\"] //descendant:: span[text()=\"20\"]");
    public By aceptarCookie =By.xpath("//em[@class=\"btn-text\"]");
    public By botonBuscar = By.xpath("//em[@class=\"btn-text\" and text()=\"Buscar\"]");
    public By divHabitaciones = By.xpath("//div[@class=\"sbox-distri-container\"]");
    public By botonMenosHabitaciones = By.xpath("//a[@class=\"steppers-icon-left sbox-3-icon-minus\"]");
    public By paqueteSantiagoChile = By.xpath("//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"]");
    public By mostrarOpcionesAvanzadas = By.xpath("//input[@class=\"sbox-advanced-options\"]");
    public By checkboxAlojamientoOtraCiudad = By.xpath("//label[@class=\"checkbox-label sbox-hotel-another-city-label\"]");
    public By destinoDos = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-hotel-another-city sbox-primary undefined attr\"]");
    public By paqueteMarDelPlata = By.xpath("(//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"])[1]");
    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.edgedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }


    @Test
    public void ATC01PQ()throws InterruptedException{

        driver.get("https://www.viajesfalabella.cl/");
        WebElement webElementPaquete= driver.findElement(paquete);
        webElementPaquete.click();
        WebElement webElementVueloAlojamiento= driver.findElement(vueloAlojamiento);
        webElementVueloAlojamiento.click();
        WebElement webElementOrigen= driver.findElement(origen);
        webElementOrigen.sendKeys("Chile");
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));
        WebElement webElementResultado= driver.findElement(resultado);
        webElementResultado.click();
        WebElement webElementDestino= driver.findElement(destino);
        webElementDestino.sendKeys("Buenos Aires");
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));
        webElementResultado.click();

        WebElement webElementAceptarCookie= driver.findElement(aceptarCookie);
        webElementAceptarCookie.click();

        WebElement webElementFechaIda=driver.findElement(fechaIda);
        webElementFechaIda.click();
        WebElement webElementSeleccionIda= driver.findElement(seleccionIda);
        webElementSeleccionIda.click();//hasta aca perfecto
        WebElement webElementcontenedor20del05= driver.findElement(contenedor20del05);
        webElementcontenedor20del05.click();
        WebElement webElementHabitaciones= driver.findElement(divHabitaciones);
        webElementHabitaciones.click();

        WebElement webElementBotonMenosHabitaciones=driver.findElement(botonMenosHabitaciones);
        webElementBotonMenosHabitaciones.click();

        WebElement webElementBotonBuscar= driver.findElement(botonBuscar);
        webElementBotonBuscar.click();
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));
        WebElement webElementPaqueteChile= driver.findElement(paqueteSantiagoChile);
        webElementPaqueteChile.click();




    }

    @Test
    public void ATC03PQ()throws InterruptedException{

        driver.get("https://www.viajesfalabella.cl/");
        WebElement webElementAceptarCookie= driver.findElement(aceptarCookie);
        webElementAceptarCookie.click();
        WebElement webElementPaquete= driver.findElement(paquete);
        webElementPaquete.click();
        WebElement webElementVueloAlojamiento= driver.findElement(vueloAlojamiento);
        webElementVueloAlojamiento.click();
        WebElement webElementOrigen= driver.findElement(origen);
        webElementOrigen.sendKeys("Chile");
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));
        WebElement webElementResultado= driver.findElement(resultado);
        webElementResultado.click();
        WebElement webElementDestino= driver.findElement(destino);
        webElementDestino.sendKeys("Buenos Aires");
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));
        webElementResultado.click();
        WebElement webElementFechaIda=driver.findElement(fechaIda);
        webElementFechaIda.click();
        WebElement webElementSeleccionIda= driver.findElement(seleccionIda);
        webElementSeleccionIda.click();//hasta aca perfecto
        WebElement webElementcontenedor20del05= driver.findElement(contenedor20del05);
        webElementcontenedor20del05.click();


        WebElement webElementMostrarOpcionesAvanzadas= driver.findElement(mostrarOpcionesAvanzadas);
        webElementMostrarOpcionesAvanzadas.click();
        WebElement webElementCkeckOtraCiudad= driver.findElement(checkboxAlojamientoOtraCiudad);
        webElementCkeckOtraCiudad.click();
        WebElement webElementDestinoDos=driver.findElement(destinoDos);
        webElementDestinoDos.sendKeys("Mar del Plata, Buenos Aires, Argentina");
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));
        webElementResultado.click();
        WebElement webElementBotonBuscar= driver.findElement(botonBuscar);
        webElementBotonBuscar.click();
        WebElement webElementPaqueteMarDelPlata= driver.findElement(paqueteMarDelPlata);
        webElementPaqueteMarDelPlata.click();

    }
    @After public void close(){
        if(driver != null){
            driver.close();
        }
    }

}
