package selenium.morona.Desafio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class AlojamientosChromeVersion {

    public By botonAlojamientos = By.xpath("//label[text()=\"Alojamientos\"]");
    public By localizadorCalendarioEntrada = By.xpath("//input[@placeholder=\"Entrada\"]");
    public By localizadorBtnBuscar = By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");

    public By localizadorCheckbox = By.xpath("//label[@class=\"checkbox-label\"]");
    public By localizadorBarraDeBusqueda = By.xpath("//input[@type=\"text\"]");
    public By localizadorAlojamientosLink = By.xpath("//a[@href=\"//www.viajesfalabella.cl/hoteles\"]");

    public By localizadorMsjEntrada = By.xpath("(//span[@class=\"validation-msg\"])[2]");
    public By localizadorMsjSalida = By.xpath("(//span[@class=\"validation-msg\"])[3]");

    public By localizadorFlechaNext = By.xpath("//div[@class=\"_dpmg2--controls-next\"]");
    public By localizadorDia = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div._dpmg2--month._dpmg2--o-1._dpmg2--month-active > div._dpmg2--dates > span:nth-child(1)");
    public By localizadorDiaSalida = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div._dpmg2--month._dpmg2--o-1._dpmg2--month-active > div._dpmg2--dates > span:nth-child(5)");
    public By localizadorDiaSalida2 = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(7)");
    public By localizadorCantHabitaciones = By.xpath("(//div[@class=\"input-container\"])[2]");
    public By localizadorCantDeAdultos = By.xpath("(//a[@class=\"steppers-icon-left sbox-3-icon-minus\"])[1]");
    public By localizadorBtnAplicar = By.xpath("//a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"]");
    public By localizadorOpcion1 = By.xpath("(//em[text()=\"Ver detalle\"])[1]");
    public By localizadorPopUp = By.xpath("//i[@class=\"tooltip-close eva-3-icon-close\"]");
    public By localizadormensajeCookies = By.xpath("//em[@class=\"btn-text\"]");
    public By localizadorHabitaciones = By.xpath("(//aloha-radio-button[@name=\"roompack\"])[1]");
    public By localizadorBtnReservarAhora = By.xpath("//button[@class=\"eva-3-btn -md -secondary -eva-3-fwidth\"]");
    public By localizadorActividad = By.xpath("(//div[@class=\"highlight-card\"])[1]");
    public By localizadorActividad2 = By.xpath("//button[@class=\"eva-3-btn -eva-3-fwidth -md -primary\"]");
    public By localizadorBtnSiguiente = By.xpath("//button[@class=\"eva-3-btn -lg pricebox-sticky-button -secondary\"]");
    public By localizadorAgregarAlViaje = By.xpath("//button[@class=\"-md -eva-3-fwidth -eva-3-pl-sm -eva-3-pr-sm eva-3-btn -primary\"]");
    public By localizadorResultadoBusqueda = By.xpath("(//ul[contains(li,perú)])[13]");
    public By localizadorDiaEntrada = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(1)");
    public By localizadorHotel = By.xpath("(//span[text()=\"Hotel Club La Serena\"])[1]");
    public By localizadorHabitacion = By.xpath("(//aloha-radio-button[@name=\"roompack\"])[1]");
    public By localizadorMsjCookies = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");

    public By localizadorSelectorMoneda = By.xpath("(//select[@class=\"select-tag\"])[1]");
    public By localizadorAlquileresV = By.xpath("(//div[@class=\"sub-nav-label-content\"])[3]");
    public By localizadorPrecioMin = By.xpath("(//input[@type=\"number\"])[1]");
    public By slider = By.xpath("//div[@class=\"slider-handler -right\"]");
    public By localizadorBtnAplicarPrecio = By.xpath("(//button[@class=\"eva-3-btn -md -primary\"])[1]");
    public By localizadorCheckboxHot = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(4) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(6) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorCheckbox3E = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(6) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(4) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorDesayuno = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(9) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(3) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorBar = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(9) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(2) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorCheckExpress = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(9) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(4) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorWifi = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(9) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(5) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorServicioEquipaje = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(9) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(6) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorResultadoHotel = By.xpath("//div[@class=\"eva-3-cluster-gallery -eva-3-bc-white -eva-3-shadow-line-hover\"]");


    //ATC-6AL
    By bannerOferta = By.xpath("(//a[@class=\"link\"])[3]");
    By hotelCaribe = By.xpath("(//div[@class=\"offer-module-container\"] //descendant:: div[@class=\"offer-cards-container offers-first-row\"] //descendant:: div[@class=\"offer-card-container\"])[1]");
    By contenedor10del05 = By.xpath("//div[@class=\"_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show\"] //descendant:: div[@data-month=\"2022-05\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available\"] //descendant:: span[text()=\"10\"]");
    By contenedor20del05 = By.xpath("//div[@class=\"_dpmg2--month _dpmg2--o-7 _dpmg2--has-start-range _dpmg2--month-active\"] //descendant:: span[@class=\"_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip\"] //descendant:: span[text()=\"20\"]");
    By divHabitaciones = By.xpath("//div[@class=\"sbox-distri-container\"]");
    By botonMenosHabitaciones = By.xpath("//a[@class=\"steppers-icon-left sbox-3-icon-minus\"]");
    By primerHotel = By.xpath("(//div[@class=\"cluster-description cluster-description-top\"])[1]");
    By primerHabitacionDisp = By.xpath("//div[@class=\"rooms-container\"]");
    By reservarAhora = By.xpath("//div[@class=\"col-6 -eva-3-bc-white\"] //descendant:: button[@class=\"eva-3-btn -md -secondary -eva-3-fwidth\"]");
    By primerActividadDisp = By.xpath("(//button[@class=\"eva-3-btn -eva-3-fwidth -md -primary\"])[1]");
    By horaLlegada = By.xpath("//select[@id=\"arrivalTime\"]");
    By horaoptionLlegada = By.xpath("//select[@id=\"arrivalTime\"] //descendant:: option[@value=\"00:00\"]");
    By horaSalida = By.xpath("//select[@id=\"departureTime\"] ");
    By horaoptionSalida = By.xpath("//select[@id=\"departureTime\"]  //descendant:: option[@value=\"06:00\"]");
    By iconX = By.xpath("//i[@class=\"tooltip-close eva-3-icon-close\"]");
    By buscarTraslado = By.xpath("(//button[@type=\"submit\"])[1]");
    By buttonAgregarTraslado = By.xpath("//div[@class=\"pricebox-top-container\"] //descendant:: button[@class=\"eva-3-btn -eva-3-fwidth -md -primary\"]");
    By buttonSiguiente = By.xpath("//div[@class=\"-green -loyalty -with-info eva-3-pricebox-sticky eva-3-shadow pricebox-sticky xs\"] //descendant:: button[@class=\"eva-3-btn -lg pricebox-sticky-button -secondary\"]");
    By tituloH2confirmacion = By.xpath("//h2[@class=\"chk-main-title -eva-3-hide-small -eva-3-hide-medium\"]");


    public static WebDriver driver;


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
    public void ATC01AL() {
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

    @Test
    public void ATC02AL() {
        //Ingresamos a la página
        driver.get("https://www.viajesfalabella.cl/");

        //Nos dirigimos al apartado Alojamientos
        WebElement seccionAlojamientos = driver.findElement(localizadorAlojamientosLink);
        seccionAlojamientos.click();
        //Ingresamos la búsqueda
        WebElement barraDeBusqueda = driver.findElement(localizadorBarraDeBusqueda);
        barraDeBusqueda.click();
        barraDeBusqueda.sendKeys("La Serena,Coquimbo,Chile");

        //Click en Buscar
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();

        //Validamos la aparición de los mensajes
        WebElement msjEntrada = driver.findElement(localizadorMsjEntrada);
        if (msjEntrada.getText().contains("Ingresa una fecha de entrada.")) {
            System.out.println("El mensaje Ingresa una fecha de entrada se muestra correctamente.");

        }

        WebElement msjSalida = driver.findElement(localizadorMsjSalida);
        if (msjSalida.getText().contains("Ingresa una fecha de salida.")) {
            System.out.println("El mensaje Ingresa una fecha de salida se muestra correctamente.");

        }
    }

    @Test
    public void ATC05AL() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Ingresamos a la página
        driver.get("https://www.viajesfalabella.cl/");

        //Nos dirigimos al apartado Alojamientos
        WebElement seccionAlojamientos = driver.findElement(localizadorAlojamientosLink);
        seccionAlojamientos.click();
        //Ingresamos la búsqueda
        WebElement barraDeBusqueda = driver.findElement(localizadorBarraDeBusqueda);
        barraDeBusqueda.click();
        barraDeBusqueda.sendKeys("Lima, Lima, Perú");
        WebElement resultadoBusqueda = driver.findElement(localizadorResultadoBusqueda);
        resultadoBusqueda.click();

        //Seleccionar Fechas de entrada y salida
        WebElement calendarioEntrada = driver.findElement(localizadorCalendarioEntrada);
        calendarioEntrada.click();

        WebElement flechanext = driver.findElement(localizadorFlechaNext);
        flechanext.click();
        flechanext.click();
        flechanext.click();
        flechanext.click();

        WebElement diaEntrada = driver.findElement(localizadorDia);
        diaEntrada.click();
        WebElement diaSalida = driver.findElement(localizadorDiaSalida);
        diaSalida.click();

        //Seleccionar Habitaciones y cantidad de personas
        WebElement habitaciones = driver.findElement(localizadorCantHabitaciones);
        habitaciones.click();
        WebElement cantidadAdultos = driver.findElement(localizadorCantDeAdultos);
        cantidadAdultos.click();

        //aplicamos Cambios
        WebElement btnAplicar = driver.findElement(localizadorBtnAplicar);
        js.executeScript("arguments[0].scrollIntoView();", btnAplicar);
        btnAplicar.click();
        //Click en buscar
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
        //Eliminar Mensajes innecesarios
        WebElement popUp = driver.findElement(localizadorPopUp);
        popUp.click();
        WebElement mensajeCoockies = driver.findElement(localizadormensajeCookies);
        mensajeCoockies.click();


        //seleccionar la opcion 1
        WebElement seleccionOpcion1 = driver.findElement(localizadorOpcion1);
        seleccionOpcion1.click();

        //Seleccionar habitacion
        String mainTab = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(mainTab)) {
                driver.switchTo().window(actual);
            }

        }
        WebElement seleccionHabitacion1 = driver.findElement(localizadorHabitaciones);
        seleccionHabitacion1.click();

        WebElement reservaHabitacion = driver.findElement(localizadorBtnReservarAhora);
        reservaHabitacion.click();

        //Seleccionar actividad

        WebElement seleccionActividad = driver.findElement(localizadorActividad);
        js.executeScript("arguments[0].scrollIntoView();", seleccionActividad);
        seleccionActividad.click();
        WebElement agregarActividad = driver.findElement(localizadorAgregarAlViaje);
        js.executeScript("arguments[0].scrollIntoView();", agregarActividad);
        agregarActividad.click();

        //Siguiente

        WebElement siguiente = driver.findElement(localizadorBtnSiguiente);
        siguiente.click();


    }

    @Test
    public void ATC03AL() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Ingresamos a la página
        driver.get("https://www.viajesfalabella.cl/");

        //Nos dirigimos al apartado Alojamientos
        WebElement seccionAlojamientos = driver.findElement(localizadorAlojamientosLink);
        seccionAlojamientos.click();

        //Ingresamos la búsqueda
        WebElement barraDeBusqueda = driver.findElement(localizadorBarraDeBusqueda);
        barraDeBusqueda.click();
        barraDeBusqueda.sendKeys("La Serena, Coquimbo, Chile");
        WebElement resultadoBusqueda = driver.findElement(localizadorResultadoBusqueda);
        resultadoBusqueda.click();

        //Seleccionar Fechas de entrada y salida
        WebElement calendarioEntrada = driver.findElement(localizadorCalendarioEntrada);
        calendarioEntrada.click();

        WebElement diaEntrada = driver.findElement(localizadorDiaEntrada);
        diaEntrada.click();

        WebElement diaSalida = driver.findElement(localizadorDiaSalida2);
        diaSalida.click();

        //Seleccionar Habitaciones y cantidad de personas
        WebElement habitaciones = driver.findElement(localizadorCantHabitaciones);
        habitaciones.click();
        WebElement cantidadAdultos = driver.findElement(localizadorCantDeAdultos);
        cantidadAdultos.click();

        WebElement btnAplicar = driver.findElement(localizadorBtnAplicar);
        js.executeScript("arguments[0].scrollIntoView();", btnAplicar);
        btnAplicar.click();

        //Click en buscar
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();

        //Seleccionar Hotel
        WebElement seleccionHotel = driver.findElement(localizadorHotel);
        js.executeScript("arguments[0].scrollIntoView();", seleccionHotel);
        seleccionHotel.click();

        //Seleccionar habitacion
        String mainTab = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(mainTab)) {
                driver.switchTo().window(actual);
            }
        }
        WebElement msjCookies = driver.findElement(localizadorMsjCookies);
        msjCookies.click();

        WebElement habitacion = driver.findElement(localizadorHabitacion);
        habitacion.click();
        WebElement reservarAhora = driver.findElement(localizadorBtnReservarAhora);
        reservarAhora.click();

        //Seleccionar Tour/actividad

        WebElement actividad = driver.findElement(localizadorActividad2);
        js.executeScript("arguments[0].scrollIntoView();", actividad);
        actividad.click();

        //Click en siguiente
        WebElement siguiente = driver.findElement(localizadorBtnSiguiente);

        siguiente.click();


    }

    @Test
    public void ATC04AL() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait explicita = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Ingresamos a la página
        driver.get("https://www.viajesfalabella.cl/");

        //Nos dirigimos al apartado Alojamientos
        WebElement seccionAlojamientos = driver.findElement(localizadorAlojamientosLink);
        seccionAlojamientos.click();

        //Ingresamos la búsqueda
        WebElement barraDeBusqueda = driver.findElement(localizadorBarraDeBusqueda);
        barraDeBusqueda.click();
        barraDeBusqueda.sendKeys("La Serena, Coquimbo, Chile");
        WebElement resultadoBusqueda = driver.findElement(localizadorResultadoBusqueda);
        resultadoBusqueda.click();

        //Seleccionar Fechas de entrada y salida
        WebElement calendarioEntrada = driver.findElement(localizadorCalendarioEntrada);
        calendarioEntrada.click();

        WebElement diaEntrada = driver.findElement(localizadorDiaEntrada);
        diaEntrada.click();
        WebElement diaSalida = driver.findElement(localizadorDiaSalida2);
        diaSalida.click();

        //Seleccionar Habitaciones y cantidad de personas
        WebElement habitaciones = driver.findElement(localizadorCantHabitaciones);
        habitaciones.click();
        WebElement cantidadAdultos = driver.findElement(localizadorCantDeAdultos);
        cantidadAdultos.click();

        WebElement btnAplicar = driver.findElement(localizadorBtnAplicar);
        js.executeScript("arguments[0].scrollIntoView();", btnAplicar);
        btnAplicar.click();

        //Click en buscar
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
        Thread.sleep(3000);

        //Cambiamos Moneda a Dolar
        WebElement selecionMoneda = driver.findElement(localizadorSelectorMoneda);
        Select manejoSeleccionMoneda = new Select(selecionMoneda);
        manejoSeleccionMoneda.selectByVisibleText("Dólar");

        //Seccion Alquileres Vacacionales
        WebElement seleccionAlquileresV = driver.findElement(localizadorAlquileresV);
        seleccionAlquileresV.click();


        //Seleccion rango de precio

        WebElement precioMin = driver.findElement(localizadorPrecioMin);
        precioMin.clear();
        precioMin.sendKeys("155");

        WebElement sliderMax = driver.findElement(slider);
        Actions action = new Actions(driver);
        action.dragAndDropBy(sliderMax, -199, 0).perform();

        WebElement btnAplicarPrecio = driver.findElement(localizadorBtnAplicarPrecio);
        btnAplicarPrecio.click();


        //Seleccionar Filtros

        WebElement checkboxHot = driver.findElement(localizadorCheckboxHot);
        js.executeScript("arguments[0].scrollIntoView();", checkboxHot);
        checkboxHot.click();

        WebElement estrellas = driver.findElement(localizadorCheckbox3E);
        js.executeScript("arguments[0].scrollIntoView();", estrellas);
        estrellas.click();

        Thread.sleep(1000);
        WebElement desayuno = driver.findElement(localizadorDesayuno);
        js.executeScript("arguments[0].scrollIntoView();", desayuno);
        desayuno.click();

        Thread.sleep(1000);

        WebElement bar = driver.findElement(localizadorBar);
        js.executeScript("arguments[0].scrollIntoView();", bar);
        bar.click();

        Thread.sleep(1000);

        WebElement checkExpress = driver.findElement(localizadorCheckExpress);
        js.executeScript("arguments[0].scrollIntoView();", checkExpress);
        checkExpress.click();

        Thread.sleep(1000);

        WebElement wifi = driver.findElement(localizadorWifi);
        js.executeScript("arguments[0].scrollIntoView();", wifi);
        wifi.click();

        Thread.sleep(1000);

        WebElement servicioDeEquipaje = driver.findElement(localizadorServicioEquipaje);
        js.executeScript("arguments[0].scrollIntoView();", servicioDeEquipaje);
        servicioDeEquipaje.click();

        //Seleccionamos Hotel

        WebElement resultadoHotel = driver.findElement(localizadorResultadoHotel);
        js.executeScript("arguments[0].scrollIntoView();", resultadoHotel);
        resultadoHotel.click();

    }


    @Test
    public void ATC06AL() {

        driver.get("https://www.viajesfalabella.cl/");
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean resultadoT6 = false;


        WebElement botonAlojamiento = driver.findElement(botonAlojamientos);
        botonAlojamiento.click();

        WebElement presionarBannerOferta = driver.findElement(bannerOferta);
        js.executeScript("arguments[0].scrollIntoView();", presionarBannerOferta);
        presionarBannerOferta.click();

        WebElement presionarHotelCaribe = driver.findElement(hotelCaribe);
        presionarHotelCaribe.click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement fechaEntrada = driver.findElement(localizadorCalendarioEntrada);
        fechaEntrada.click();


        WebElement fecha10de05 = driver.findElement(contenedor10del05);
        js.executeScript("arguments[0].scrollIntoView();", fecha10de05);
        fecha10de05.click();

        WebElement fecha20de05 = driver.findElement(contenedor20del05);
        js.executeScript("arguments[0].scrollIntoView();", fecha20de05);
        fecha20de05.click();

        WebElement habitaciones = driver.findElement(divHabitaciones);
        habitaciones.click();

        WebElement menosHabitaciones = driver.findElement(botonMenosHabitaciones);
        menosHabitaciones.click();

        WebElement buscar = driver.findElement(localizadorBtnBuscar);
        buscar.click();

        WebElement botonX = driver.findElement(iconX);
        botonX.click();


        WebElement primerHotelDisp = driver.findElement(primerHotel);
        js.executeScript("arguments[0].scrollIntoView();", primerHotelDisp);
        primerHotelDisp.click();

        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs3.get(2));

        //  js.executeScript("window.scrollBy(0,1000)"); Para scrollear por pixel, pero en este caso
        //no nos sirve

        WebElement habitacionesDisponibles = driver.findElement(primerHabitacionDisp);
        js.executeScript("arguments[0].scrollIntoView();", habitacionesDisponibles);
        WebElement resrAhora = driver.findElement(reservarAhora);
        exwait.until(ExpectedConditions.elementToBeClickable(resrAhora));
        resrAhora.click();

        WebElement primerActDisp = driver.findElement(primerActividadDisp);
        js.executeScript("arguments[0].scrollIntoView();", primerActDisp);
        primerActDisp.click();

        WebElement horaLleg = driver.findElement(horaLlegada);
        js.executeScript("arguments[0].scrollIntoView();", horaLleg);
        horaLleg.click();

        WebElement horaChrLle = driver.findElement(horaoptionLlegada);
        horaChrLle.click();

        WebElement horaSal = driver.findElement(horaSalida);
        horaSal.click();

        WebElement horaChSal = driver.findElement(horaoptionSalida);
        horaChSal.click();

        WebElement trasladoBuscar = driver.findElement(buscarTraslado);
        trasladoBuscar.click();

        WebElement agregarTraslado = driver.findElement(buttonAgregarTraslado);
        js.executeScript("arguments[0].scrollIntoView();", agregarTraslado);
        agregarTraslado.click();

        WebElement siguiente = driver.findElement(buttonSiguiente);
        siguiente.click();

        WebElement tituloh2 = driver.findElement(tituloH2confirmacion);
        if (tituloh2.getText().contains("¡Falta poco! Completa tus datos y finaliza tu compra")) {
            resultadoT6 = true;
        }
        assertTrue(resultadoT6);

    }

    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}

