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

    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }


    @Test
    public void ATC01PQ()throws InterruptedException{

        // Ingresamos a la Pagina
        driver.get("https://www.viajesfalabella.cl/");

        // Seleccionamos el Apartados Paquetes
        WebElement webElementPaquete= driver.findElement(paquete);
        webElementPaquete.click();

        //Seleccionar Vuelo + Alojamiento
        WebElement webElementVueloAlojamiento= driver.findElement(vueloAlojamiento);
        webElementVueloAlojamiento.click();

        //Seleccion de Origen y Destino
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

        //Aceptar Cookie
        WebElement webElementAceptarCookie= driver.findElement(aceptarCookie);
        webElementAceptarCookie.click();
        // Seleccion de Fecha Ida y Vuelta
        WebElement webElementFechaIda=driver.findElement(fechaIda);
        webElementFechaIda.click();
        WebElement webElementSeleccionIda= driver.findElement(seleccionIda);
        webElementSeleccionIda.click();
        WebElement webElementcontenedor20del05= driver.findElement(contenedor20del05);
        webElementcontenedor20del05.click();


        // Seleccion de Habitaciones
        WebElement webElementHabitaciones= driver.findElement(divHabitaciones);
        webElementHabitaciones.click();
        WebElement webElementBotonMenosHabitaciones=driver.findElement(botonMenosHabitaciones);
        webElementBotonMenosHabitaciones.click();

        // Seleccionar Realizar la Busqueda
        WebElement webElementBotonBuscar= driver.findElement(botonBuscar);
        webElementBotonBuscar.click();
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));

        //Elegir Paquete
        WebElement webElementPaqueteChile= driver.findElement(paqueteSantiagoChile);
        webElementPaqueteChile.click();




    }

    @Test
    public void ATC03PQ()throws InterruptedException{
        // Ingresamos a la Pagina
        driver.get("https://www.viajesfalabella.cl/");
        // Aceptar las Cookie
        WebElement webElementAceptarCookie= driver.findElement(aceptarCookie);
        webElementAceptarCookie.click();
        // Seleccionamos el Apartados Paquetes
        WebElement webElementPaquete= driver.findElement(paquete);
        webElementPaquete.click();
        // Seleccionar Vuelo + Alojamiento
        WebElement webElementVueloAlojamiento= driver.findElement(vueloAlojamiento);
        webElementVueloAlojamiento.click();
        // Elegir Origen y Destino
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
        // Seleccionar Fecha
        WebElement webElementFechaIda=driver.findElement(fechaIda);
        webElementFechaIda.click();
        WebElement webElementSeleccionIda= driver.findElement(seleccionIda);
        webElementSeleccionIda.click();
        WebElement webElementcontenedor20del05= driver.findElement(contenedor20del05);
        webElementcontenedor20del05.click();

       // Seleccionar Opciones Avanzadas
        WebElement webElementMostrarOpcionesAvanzadas= driver.findElement(mostrarOpcionesAvanzadas);
        webElementMostrarOpcionesAvanzadas.click();

        // Seleccionar Alojamiento en otra Ciudad
        WebElement webElementCkeckOtraCiudad= driver.findElement(checkboxAlojamientoOtraCiudad);
        webElementCkeckOtraCiudad.click();

        //Elegir Destino en Otra Ciudad
        WebElement webElementDestinoDos=driver.findElement(destinoDos);
        webElementDestinoDos.sendKeys("Mar del Plata, Buenos Aires, Argentina");
        exwait.until(ExpectedConditions.elementToBeClickable(resultado));
        webElementResultado.click();

        //Buscar
        WebElement webElementBotonBuscar= driver.findElement(botonBuscar);
        webElementBotonBuscar.click();

        // Seleccionar Paquete
        WebElement webElementPaqueteMarDelPlata= driver.findElement(paqueteMarDelPlata);
        webElementPaqueteMarDelPlata.click();

    }
    @After public void close(){
        if(driver != null){
            driver.close();
        }
    }

    public static class Vuelo {



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

        @After public void close(){
        if(driver != null){
        driver.close();
        }
        }
    }
}
