package selenium.morona.Desafio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class AlojamientosTest4 {
    public static WebDriver driver;
    public By localizadorAlojamientosLink = By.xpath("//a[@href=\"//www.viajesfalabella.cl/hoteles\"]");
    public By localizadorBarraDeBusqueda = By.xpath("//input[@type=\"text\"]");
    public By localizadorResultadoBusqueda = By.xpath("//li [@class=\"item -active\"]");
    public By localizadorCalendarioEntrada = By.xpath("//input[@placeholder=\"Entrada\"]");
    public By localizadorDiaEntrada = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(1)");
    public By localizadorDiaSalida = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(7)");
    public By localizadorCantHabitaciones = By.xpath("(//div[@class=\"input-container\"])[2]");
    public By localizadorCantDeAdultos = By.xpath("(//a[@class=\"steppers-icon-left sbox-3-icon-minus\"])[1]");
    public By localizadorBtnAplicar = By.xpath("//a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"]");
    public By localizadorBtnBuscar = By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");
    public By localizadorHotel = By.xpath("(//span[text()=\"Hotel Club La Serena\"])[1]");
    public By localizadorHabitacion = By.xpath("(//aloha-radio-button[@name=\"roompack\"])[1]");
    public By localizadorBtnReservarAhora = By.xpath("//button[@class=\"eva-3-btn -md -secondary -eva-3-fwidth\"]");
    public By localizadorMsjCookies = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    public By localizadorActividad = By.xpath("//button[@class=\"eva-3-btn -eva-3-fwidth -md -primary\"]");
    public By localizadorBtnSiguiente = By.xpath("//button[@class=\"eva-3-btn -lg pricebox-sticky-button -secondary\"]");


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
    public void sumaDePrecios(){
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
        WebElement diaSalida = driver.findElement(localizadorDiaSalida);
        diaSalida.click();

        //Seleccionar Habitaciones y cantidad de personas
        WebElement habitaciones = driver.findElement(localizadorCantHabitaciones);
        habitaciones.click();
        WebElement cantidadAdultos = driver.findElement(localizadorCantDeAdultos);
        cantidadAdultos.click();

        WebElement btnAplicar = driver.findElement(localizadorBtnAplicar);
        js.executeScript("arguments[0].scrollIntoView();",btnAplicar);
        btnAplicar.click();

        //Click en buscar
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();

        //Seleccionar Hotel
        WebElement seleccionHotel = driver.findElement(localizadorHotel);
        js.executeScript("arguments[0].scrollIntoView();",seleccionHotel);
        seleccionHotel.click();

        //Seleccionar habitacion
        String mainTab = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual: handles) {
            if (!actual.equalsIgnoreCase(mainTab)){
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

        WebElement actividad = driver.findElement(localizadorActividad);
        js.executeScript("arguments[0].scrollIntoView();",actividad);
        actividad.click();

        //Click en siguiente
        WebElement siguiente = driver.findElement(localizadorBtnSiguiente);
        siguiente.click();


    }


}
