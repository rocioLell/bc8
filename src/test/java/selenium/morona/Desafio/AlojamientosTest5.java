package selenium.morona.Desafio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlojamientosTest5 {
    public static WebDriver driver;
    public By localizadorAlojamientosLink = By.xpath("//a[@href=\"//www.viajesfalabella.cl/hoteles\"]");
    public By localizadorBarraDeBusqueda = By.xpath("//input[@type=\"text\"]");
    public By localizadorResultadoBusqueda = By.xpath("//li [@class=\"item -active\"]");
    public By localizadorCalendarioEntrada = By.xpath("//input[@placeholder=\"Entrada\"]");
    public By localizadorDiaEntrada = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(1)");
    public By localizadorDiaSalida = By.cssSelector("body > div.sbox-ui-datepicker-container.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(7)");
    public By localizadorCantHabitaciones = By.xpath("(//div[@class=\"input-container\"])[2]");
    public By localizadorCantDeAdultos = By.xpath("(//a[@class=\"steppers-icon-left sbox-3-icon-minus\"])[1]");
    public By localizadorSelectorMoneda = By.xpath("(//select[@class=\"select-tag\"])[1]");
    public By localizadorBtnAplicar = By.xpath("//a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"]");
    public By localizadorBtnBuscar = By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");
    public By localizadorAlquileresV = By.xpath("(//div[@class=\"sub-nav-label-content\"])[3]");
    public By localizadorPrecioMin =  By.xpath("(//input[@type=\"number\"])[1]");
    public By slider = By.xpath("//div[@class=\"slider-handler -right\"]");
    public By localizadorBtnAplicarPrecio = By.xpath("(//button[@class=\"eva-3-btn -md -primary\"])[1]");
    public By localizadorCheckboxHot= By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(4) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(6) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorCheckbox3E = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(6) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(4) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorDesayuno = By.xpath("(//i[@class=\"checkbox-check eva-3-icon-checkmark filters-checkbox-left\"])[35]");
    public By localizadorBar= By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(10) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(2) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorCheckExpress = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(10) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(4) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorWifi = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(10) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(5) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorServicioEquipaje = By.cssSelector("body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(10) > aloha-filter > aloha-checkbox-filter > ul > li:nth-child(6) > span > span.filters-checkbox > aloha-checkbox > span > label > i");
    public By localizadorResultadoHotel = By.xpath("//div[@class=\"eva-3-cluster-gallery -eva-3-bc-white -eva-3-shadow-line-hover\"]");

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
    public void busquedaConFiltros() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait explicita =new WebDriverWait(driver,Duration.ofSeconds(5));
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
        Thread.sleep(3000);

        //Cambiamos Moneda a Dolar
        WebElement selecionMoneda = driver.findElement(localizadorSelectorMoneda);
        Select manejoSeleccionMoneda = new Select(selecionMoneda);
        manejoSeleccionMoneda.selectByVisibleText("Dólar");

        //Seccion Alquileres Vacacionales
        WebElement seleccionAlquileresV= driver.findElement(localizadorAlquileresV);
        seleccionAlquileresV.click();


        //Seleccion rango de precio

        WebElement precioMin = driver.findElement(localizadorPrecioMin);
        precioMin.clear();
        precioMin.sendKeys("155");

        WebElement sliderMax = driver.findElement(slider);
        Actions action = new Actions(driver);
        action.dragAndDropBy(sliderMax,-199,0).perform();

        WebElement btnAplicarPrecio = driver.findElement(localizadorBtnAplicarPrecio);
        btnAplicarPrecio.click();


        //Seleccionar Filtros

        WebElement checkboxHot = driver.findElement(localizadorCheckboxHot);
        js.executeScript("arguments[0].scrollIntoView();",checkboxHot);
        checkboxHot.click();

        WebElement estrellas = driver.findElement(localizadorCheckbox3E);
        js.executeScript("arguments[0].scrollIntoView();",estrellas);
        estrellas.click();

        Thread.sleep(1000);
        WebElement desayuno= driver.findElement(localizadorDesayuno);
        explicita.until(ExpectedConditions.elementToBeClickable(desayuno));
        js.executeScript("arguments[0].scrollIntoView();",desayuno);
       desayuno.click();

       Thread.sleep(1000);

        WebElement bar = driver.findElement(localizadorBar);
        js.executeScript("arguments[0].scrollIntoView();",bar);
        bar.click();

        Thread.sleep(1000);

        WebElement checkExpress = driver.findElement(localizadorCheckExpress);
        js.executeScript("arguments[0].scrollIntoView();",checkExpress);
        checkExpress.click();

        Thread.sleep(1000);

        WebElement wifi= driver.findElement(localizadorWifi);
        js.executeScript("arguments[0].scrollIntoView();",wifi);
        wifi.click();

        Thread.sleep(1000);

        WebElement servicioDeEquipaje = driver.findElement(localizadorServicioEquipaje);
        js.executeScript("arguments[0].scrollIntoView();",servicioDeEquipaje);
        servicioDeEquipaje.click();

        //Seleccionamos Hotel

        WebElement resultadoHotel = driver.findElement(localizadorResultadoHotel);
        js.executeScript("arguments[0].scrollIntoView();",resultadoHotel);
        resultadoHotel.click();






    }
}