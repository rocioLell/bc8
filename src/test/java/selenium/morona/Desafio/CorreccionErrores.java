package selenium.morona.Desafio;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;
import java.time.Duration;

public class CorreccionErrores {
    public static WebDriver driver;
    public By localizadorAlojamientosLink = By.xpath("//a[@href=\"//www.viajesfalabella.cl/hoteles\"]");
    public By localizadorBarraDeBusqueda = By.xpath("//input[@type=\"text\"]");
    public By localizadorCalendarioEntrada = By.xpath("//input[@placeholder=\"Entrada\"]");
    public By localizadorResultadoBusqueda = By.xpath("(//ul[contains(li,perú)])[13]");
    public By localizadorFlechaNext = By.xpath("//div[@class=\"_dpmg2--controls-next\"]");
    public By localizadorDia = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div._dpmg2--month._dpmg2--o-1._dpmg2--month-active > div._dpmg2--dates > span:nth-child(1)");
    public By localizadorDiaSalida = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div._dpmg2--month._dpmg2--o-1._dpmg2--month-active > div._dpmg2--dates > span:nth-child(5)");
    public By localizadorCantHabitaciones = By.xpath("(//div[@class=\"input-container\"])[2]");
    public By localizadorCantDeAdultos = By.xpath("(//a[@class=\"steppers-icon-left sbox-3-icon-minus\"])[1]");
    public By localizadorBtnAplicar = By.xpath("//a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"]");
    public By localizadorBtnBuscar = By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");
    public By localizadorOpcion1 = By.xpath("(//em[text()=\"Ver detalle\"])[1]");
    public By localizadorPopUp = By.xpath("//i[@class=\"tooltip-close eva-3-icon-close\"]");
    public By localizadormensajeCookies= By.xpath("//em[@class=\"btn-text\"]");
    public By localizadorHabitaciones = By.xpath("(//aloha-radio-button[@name=\"roompack\"])[1]");
    public By localizadorBtnReservarAhora = By.xpath("//button[@class=\"eva-3-btn -md -secondary -eva-3-fwidth\"]");
    public By localizadorActividad = By.xpath("(//div[@class=\"highlight-card\"])[1]");
    public By localizadorBtnSiguiente = By.xpath("//button[@class=\"eva-3-btn -lg pricebox-sticky-button -secondary\"]");
    public By localizadorAgregarAlViaje= By.xpath("//button[@class=\"-md -eva-3-fwidth -eva-3-pl-sm -eva-3-pr-sm eva-3-btn -primary\"]");
    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        //preparacion de Driver = Navegador
        driver = new ChromeDriver(); //Chrome -> navegador
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void alojamientoMasActividad() throws InterruptedException {
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
        WebElement diaEntrada= driver.findElement(localizadorDia);
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
        js.executeScript("arguments[0].scrollIntoView();",btnAplicar);
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
        for (String actual: handles) {
            if (!actual.equalsIgnoreCase(mainTab)){
                driver.switchTo().window(actual);
            }
        }
        WebElement seleccionHabitacion1 = driver.findElement(localizadorHabitaciones);
        seleccionHabitacion1.click();
        WebElement reservaHabitacion = driver.findElement(localizadorBtnReservarAhora);
        reservaHabitacion.click();
        //Seleccionar actividad
        Thread.sleep(2000);
        WebElement seleccionActividad = driver.findElement(localizadorActividad);
        js.executeScript("arguments[0].scrollIntoView();",seleccionActividad);
        seleccionActividad.click();
        WebElement agregarActividad = driver.findElement(localizadorAgregarAlViaje);
        js.executeScript("arguments[0].scrollIntoView();",agregarActividad);
        agregarActividad.click();
        //Siguiente
        WebElement siguiente = driver.findElement(localizadorBtnSiguiente);
        siguiente.click();
    }
}
