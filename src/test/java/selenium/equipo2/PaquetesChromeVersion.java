package selenium.equipo2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaquetesChromeVersion {

    public static WebDriver driver;


    By swithTodaviaNoHeDecididoFecha = By.xpath("//label[@class=\"switch-label sbox-switch-container\"]");
    By botonPaquetes = By.xpath("//a[@title=\"Paquetes\"]");
    By botonVueloAlojamiento = By.xpath("//input[@value=\"vh\"]");
    By botonVuelos2Alojamientos = By.xpath("//input[@class=\"sbox-bundle-input sbox-radio-vhh sbox-radio-selected-box\"]");
    By divOrigen = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline\"]");
    By divDestino = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline\"]");
    By desplegable = By.xpath("//ul[@class=\"ac-group-items\"]");
    By divHabitaciones = By.xpath("//div[@class=\"sbox-distri-container\"]");
    By botonMenosHabitaciones = By.xpath("//a[@class=\"steppers-icon-left sbox-3-icon-minus\"]");
    By botonBuscar = By.xpath("//em[@class=\"btn-text\" and text()=\"Buscar\"]");
    By paqueteSantiagoChile = By.xpath("//div[@class=\"offer-card-content\"][1]");
    By contenedorFechaIda = By.xpath("//div[@class=\"sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-dates-input sbox-checkin-container sbox-datein-container\"]");
    By contenedor10del05 = By.xpath("//div[@class=\"_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show\"] //descendant:: div[@data-month=\"2022-05\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available\"] //descendant:: span[text()=\"10\"]");
    By contenedorGeneralFechas = By.xpath("//div[@class=\"_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show\"]");
    By contenedor20del05 = By.xpath("//div[@class=\"_dpmg2--month _dpmg2--o-7 _dpmg2--has-start-range _dpmg2--month-active\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip\"] //descendant:: span[text()=\"20\"]");
    By fechaHastaAlojamiento = By.xpath("//div[@class=\"input-container sbox-hotel-first-date-end-input-container\"]");
    By contenedor19de05 = By.xpath("//div[@class=\"_dpmg2--month _dpmg2--o-7 _dpmg2--has-start-range _dpmg2--has-limit-date _dpmg2--month-active\"] //descendant:: div[@class=\"_dpmg2--dates\"] //descendant::  span[text()=\"19\"]");
    By segundoDestino = By.xpath("//div[@class=\"input-container\"] //descendant:: input[@class=\"input-tag sbox-main-focus sbox-hotel-second-destination sbox-primary undefined\"] ");
    By desplegableSegundoDestino = By.xpath("//div[@class=\"ac-group-title-container\"]");
    By botonContinuarATC04 = By.xpath("//span[@class=\"fare-container fare-container-TOTAL_FARE fare-container-CL fare-HOTELS -has-pricing-points\"] //descendant:: a[@class=\"-md eva-3-btn -primary\"]");
    By mostrarOpcionesAvanzadas = By.xpath("//input[@class=\"sbox-advanced-options\"]");
    By checkboxAlojamientoOtraCiudad = By.xpath("//label[@class=\"checkbox-label sbox-hotel-another-city-label\"]");
    By destinoNuevaCiudada = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-hotel-another-city sbox-primary undefined attr\"]");
    By fechaDesde = By.xpath("//input[@class=\"input-tag sbox-partial-stay-checkin-date\"]");
    By fecha01de05 = By.xpath("/html/body/div[6]/div/div[5]/div[2]/div[4]/span[2]");
    By fecha04de05 = By.xpath("/html/body/div[6]/div/div[5]/div[2]/div[4]/span[4]");
    By fecha25de05 = By.xpath("//div[@class=\"_dpmg2--month _dpmg2--o-7 _dpmg2--has-start-range _dpmg2--month-active\"] //descendant:: div[@class=\"_dpmg2--dates\"] //descendant:: span[text()=\"25\"]");
    By ciudadesDestinoDos = By.xpath("//div[@class=\"ac-group-title-container\"]");
    By checkbox2 = By.xpath("//label[@class=\"checkbox-label\"]");
    By vistaMapaXP = By.xpath("//em[text()=\"Vista Mapa\"]");
    By seleccionHotel = By.xpath("(//div[@class=\"eva-3-marker -eva-3-shadow-1 -eva-3-index-3\"])[1]");
    By botonVerViaje = By.xpath("(//a[@class=\"button -md -eva-3-ml-md eva-3-btn-ghost\"])[1]");

    public By paquete = By.xpath("//i[@title=\"Paquetes\"]");
    public By vueloAlojamiento= By.xpath("//input[@class=\"sbox-bundle-input sbox-radio-vh sbox-radio-selected-box\"]");
    public By origen= By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline\"]\n");
    public By destino= By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline\"]");
    public By resultado=By.xpath("//span[@class=\"item-text\"]");
    public By fechaIda= By.xpath("//input[@class=\"input-tag sbox-checkin-date\"]");
    public By seleccionIda=By.xpath("//div[@class=\"_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show\"] //descendant:: div[@data-month=\"2022-05\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available\"] //descendant:: span[text()=\"10\"]");
    public By aceptarCookie =By.xpath("//em[@class=\"btn-text\"]");
    public By destinoDos = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-hotel-another-city sbox-primary undefined attr\"]");
    public By paqueteMarDelPlata = By.xpath("(//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"])[1]");
    public By paqueteSantiagoChile2 = By.xpath("//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"]");

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void ATC01PQ(){

        // Ingresamos a la Pagina
        driver.get("https://www.viajesfalabella.cl/");
        //Aceptar Cookies
        WebElement webElementAceptarCookie= driver.findElement(aceptarCookie);
        webElementAceptarCookie.click();

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
        WebElement webElementPaqueteChile= driver.findElement(paqueteSantiagoChile2);
        webElementPaqueteChile.click();


    }

    @Test
    public void ATC02PQ(){
        driver.get("https://www.viajesfalabella.cl/");
        //Aceptar Cookies
        WebElement webElementAceptarCookie= driver.findElement(aceptarCookie);
        webElementAceptarCookie.click();
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement bPaquetes = driver.findElement(botonPaquetes);
        bPaquetes.click();
        WebElement bVueloAlojamiento = driver.findElement(botonVueloAlojamiento);
        bVueloAlojamiento.click();

        WebElement origen = driver.findElement(divOrigen);
        origen.click();
        origen.sendKeys("Aeropuerto Buenos Aires Ministro Pistarini Ezeiza, Buenos Aires, Argentina");
        exwait.until(ExpectedConditions.elementToBeClickable(desplegable));
        origen.sendKeys(Keys.ENTER);

        WebElement destino = driver.findElement(divDestino);
        destino.click();
        destino.sendKeys("Santiago de Chile, Santiago, Chile");
        exwait.until(ExpectedConditions.elementToBeClickable(destino));
        exwait.until(ExpectedConditions.elementToBeClickable(desplegable));
        destino.sendKeys(Keys.RETURN);

        WebElement habitaciones = driver.findElement(divHabitaciones);
        habitaciones.click();

        WebElement menosHabitaciones = driver.findElement(botonMenosHabitaciones);
        menosHabitaciones.click();

        WebElement noHeDecididoFecha = driver.findElement(swithTodaviaNoHeDecididoFecha);
        noHeDecididoFecha.click();

        WebElement Buscar = driver.findElement(botonBuscar);
        Buscar.click();


        exwait.until(ExpectedConditions.elementToBeClickable(paqueteSantiagoChile));
        WebElement PaqueteSantChil = driver.findElement(paqueteSantiagoChile);
        PaqueteSantChil.click();
    }


    @Test
    public void ATC03PQ(){
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

    @Test
    public void ATC04PQ(){
        driver.get("https://www.viajesfalabella.cl/");
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement bPaquetes = driver.findElement(botonPaquetes);
        bPaquetes.click();

        WebElement bVueloDosAlojamientos = driver.findElement(botonVuelos2Alojamientos);
        bVueloDosAlojamientos.click();

        WebElement origen = driver.findElement(divOrigen);
        origen.click();
        origen.sendKeys("Aeropuerto Buenos Aires Ministro Pistarini Ezeiza, Buenos Aires, Argentina");
        exwait.until(ExpectedConditions.elementToBeClickable(desplegable));
        origen.sendKeys(Keys.ENTER);

        WebElement destino = driver.findElement(divDestino);
        destino.click();
        destino.sendKeys("Santiago de Chile, Santiago, Chile");
        exwait.until(ExpectedConditions.elementToBeClickable(destino));
        exwait.until(ExpectedConditions.elementToBeClickable(desplegable));
        destino.sendKeys(Keys.RETURN);

        WebElement fechaIda = driver.findElement(contenedorFechaIda);
        fechaIda.click();

        exwait.until(ExpectedConditions.elementToBeClickable(contenedorGeneralFechas));

        exwait.until(ExpectedConditions.elementToBeClickable(contenedor10del05));
        WebElement fecha10del05 = driver.findElement(contenedor10del05);
        fecha10del05.click();

        exwait.until(ExpectedConditions.elementToBeClickable(contenedor20del05));
        WebElement fecha20de05 = driver.findElement(contenedor20del05);
        fecha20de05.click();

        WebElement fechaHasta = driver.findElement(fechaHastaAlojamiento);
        fechaHasta.click();

        WebElement fecha19de05 = driver.findElement(contenedor19de05);
        fecha19de05.click();

        WebElement segunDestino = driver.findElement(segundoDestino);
        segunDestino.click();
        segunDestino.sendKeys("La Paz, La Paz, Bolivia");
        exwait.until(ExpectedConditions.elementToBeClickable(desplegableSegundoDestino));
        segunDestino.sendKeys(Keys.ENTER);

        WebElement habitaciones = driver.findElement(divHabitaciones);
        habitaciones.click();

        WebElement menosHabitaciones = driver.findElement(botonMenosHabitaciones);
        menosHabitaciones.click();

        WebElement Buscar = driver.findElement(botonBuscar);
        Buscar.click();

        WebElement BotonPaquete = driver.findElement(botonContinuarATC04);
        BotonPaquete.click();

    }

    @Test
    public void ATC05PQ(){
        driver.get("https://www.viajesfalabella.cl/");
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement bPaquetes = driver.findElement(botonPaquetes);
        bPaquetes.click();
        WebElement bVueloAlojamiento = driver.findElement(botonVueloAlojamiento);
        bVueloAlojamiento.click();

        WebElement origen = driver.findElement(divOrigen);
        origen.click();
        origen.sendKeys("Aeropuerto Buenos Aires Ministro Pistarini Ezeiza, Buenos Aires, Argentina");
        exwait.until(ExpectedConditions.elementToBeClickable(desplegable));
        origen.sendKeys(Keys.ENTER);

        WebElement destino = driver.findElement(divDestino);
        destino.click();
        destino.sendKeys("Santiago de Chile, Santiago, Chile");
        exwait.until(ExpectedConditions.elementToBeClickable(destino));
        exwait.until(ExpectedConditions.elementToBeClickable(desplegable));
        destino.sendKeys(Keys.RETURN);

        WebElement fechaIda = driver.findElement(contenedorFechaIda);
        fechaIda.click();

        exwait.until(ExpectedConditions.elementToBeClickable(contenedorGeneralFechas));

        exwait.until(ExpectedConditions.elementToBeClickable(contenedor10del05));
        WebElement fecha10del05 = driver.findElement(contenedor10del05);
        fecha10del05.click();

        exwait.until(ExpectedConditions.elementToBeClickable(fecha25de05));
        WebElement f25de05 = driver.findElement(fecha25de05);
        f25de05.click();

        WebElement opcionesAvanzadas = driver.findElement(mostrarOpcionesAvanzadas);
        opcionesAvanzadas.click();

        exwait.until(ExpectedConditions.elementToBeClickable(checkboxAlojamientoOtraCiudad));
        WebElement checkbox = driver.findElement(checkboxAlojamientoOtraCiudad);
        checkbox.click();

        WebElement destinoNueva = driver.findElement(destinoNuevaCiudada);
        destinoNueva.click();

        destinoNueva.sendKeys("Lima, Perú");
        exwait.until(ExpectedConditions.elementToBeClickable(ciudadesDestinoDos));
        destinoNueva.sendKeys(Keys.ENTER);

        WebElement checkboxDos = driver.findElement(checkbox2);
        checkboxDos.click();

        WebElement desde = driver.findElement(fechaDesde);
        desde.click();

        WebElement f01de05 = driver.findElement(fecha01de05);
        f01de05.click();

        WebElement f04de05 = driver.findElement(fecha04de05);
        f04de05.click();

        WebElement Buscar = driver.findElement(botonBuscar);
        Buscar.click();

    }

    @Test
    public void ATC006PQ(){
        driver.get("https://www.viajesfalabella.cl/");
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement bPaquetes = driver.findElement(botonPaquetes);
        bPaquetes.click();
        WebElement bVueloAlojamiento = driver.findElement(botonVueloAlojamiento);
        bVueloAlojamiento.click();

        WebElement origen = driver.findElement(divOrigen);
        origen.click();
        origen.sendKeys("Aeropuerto Buenos Aires Ministro Pistarini Ezeiza, Buenos Aires, Argentina");
        exwait.until(ExpectedConditions.elementToBeClickable(desplegable));
        origen.sendKeys(Keys.ENTER);

        WebElement destino = driver.findElement(divDestino);
        destino.click();
        destino.sendKeys("Santiago de Chile, Santiago, Chile");
        exwait.until(ExpectedConditions.elementToBeClickable(destino));
        exwait.until(ExpectedConditions.elementToBeClickable(desplegable));
        destino.sendKeys(Keys.RETURN);

        WebElement fechaIda = driver.findElement(contenedorFechaIda);
        fechaIda.click();

        exwait.until(ExpectedConditions.elementToBeClickable(contenedorGeneralFechas));

        exwait.until(ExpectedConditions.elementToBeClickable(contenedor10del05));
        WebElement fecha10del05 = driver.findElement(contenedor10del05);
        fecha10del05.click();

        exwait.until(ExpectedConditions.elementToBeClickable(fecha25de05));
        WebElement f25de05 = driver.findElement(fecha25de05);
        f25de05.click();

        WebElement Buscar = driver.findElement(botonBuscar);
        Buscar.click();


        exwait.until(ExpectedConditions.elementToBeClickable(vistaMapaXP));
        WebElement vistaMapa = driver.findElement(vistaMapaXP);
        vistaMapa.click();

        exwait.until(ExpectedConditions.elementToBeClickable(seleccionHotel));
        WebElement hotelVistaMapa = driver.findElement(seleccionHotel);
        hotelVistaMapa.click();

        WebElement verViaje = driver.findElement(botonVerViaje);
        verViaje.click();

    }

}
