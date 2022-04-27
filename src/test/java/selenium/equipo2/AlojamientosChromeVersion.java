package selenium.equipo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class AlojamientosChromeVersion {

    public By botonAlojamientos = By.xpath("//label[text()=\"Alojamientos\"]");
    public By localizadorCalendarioEntrada = By.xpath("//input[@placeholder=\"Entrada\"]");
    public By localizadorBtnBuscar = By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");

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
    public void ATC06AL(){

        driver.get("https://www.viajesfalabella.cl/");
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean resultadoT6 = false;


        WebElement botonAlojamiento = driver.findElement(botonAlojamientos);
        botonAlojamiento.click();

        WebElement presionarBannerOferta = driver.findElement(bannerOferta);
        presionarBannerOferta.click();

        WebElement presionarHotelCaribe = driver.findElement(hotelCaribe);
        presionarHotelCaribe.click();

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement fechaEntrada = driver.findElement(localizadorCalendarioEntrada);
        fechaEntrada.click();


        WebElement fecha10de05 = driver.findElement(contenedor10del05);
        js.executeScript("arguments[0].scrollIntoView();",fecha10de05 );
        fecha10de05.click();

        WebElement fecha20de05 = driver.findElement(contenedor20del05);
        js.executeScript("arguments[0].scrollIntoView();",fecha20de05 );
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
        js.executeScript("arguments[0].scrollIntoView();",primerHotelDisp);
        primerHotelDisp.click();

        ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs3.get(2));

      //  js.executeScript("window.scrollBy(0,1000)"); Para scrollear por pixel, pero en este caso
        //no nos sirve

        WebElement habitacionesDisponibles = driver.findElement(primerHabitacionDisp);
        js.executeScript("arguments[0].scrollIntoView();",habitacionesDisponibles);
        WebElement resrAhora = driver.findElement(reservarAhora);
        exwait.until(ExpectedConditions.elementToBeClickable(resrAhora));
        resrAhora.click();

        WebElement primerActDisp = driver.findElement(primerActividadDisp);
        js.executeScript("arguments[0].scrollIntoView();",primerActDisp);
        primerActDisp.click();

        WebElement horaLleg = driver.findElement(horaLlegada);
        js.executeScript("arguments[0].scrollIntoView();",horaLleg);
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
        js.executeScript("arguments[0].scrollIntoView();",agregarTraslado);
        agregarTraslado.click();

        WebElement siguiente = driver.findElement(buttonSiguiente);
        siguiente.click();

        WebElement tituloh2 = driver.findElement(tituloH2confirmacion);
        if (tituloh2.getText().contains("¡Falta poco! Completa tus datos y finaliza tu compra")){
            resultadoT6 = true;
        }
        assertTrue(resultadoT6);

    }

}
