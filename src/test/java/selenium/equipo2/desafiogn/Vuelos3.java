package selenium.equipo2.desafiogn;

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

public class Vuelos3 {
    //atributos
    public static WebDriver driver;
    public By aceptarCookie =By.xpath("//em[@class=\"btn-text\"]");
    public By vuelo = By.xpath("//a[@class=\"shifu-3-button-circle FLIGHTS paint-circle \"]");
    public By origen= By.xpath("//input[@placeholder=\"Ingresa desde dónde viajas\"]");
    public By resultado=By.xpath("//span[@class=\"item-text\"]");
    public By destino= By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-destination-input sbox-secondary sbox-places-second places-inline\"]");
    public By calendario = By.xpath("(//input[@placeholder=\"Ida\"])[1]");
    public By fechaIda = By.cssSelector("body > div.datepicker-flights-main.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(10)");
    public By fechaVuelta = By.cssSelector("body > div.datepicker-flights-main.sbox-v4-components > div > div._dpmg2--months > div:nth-child(2) > div._dpmg2--dates > span:nth-child(20)");
    //public By aplicar = By.xpath("//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
    public By personas = By.xpath("//div[@class=\"input-tag sbox-distribution-container-input -rooms\"]");
    public By sumaradulto = By.xpath("(//div[@class=\"_pnlpk-panel-scroll\"]//descendant:: div[@class=\"_pnlpk-itemRow__item _pnlpk-stepper-adults -medium-down-to-lg\"] //descendant:: a[@class=\"steppers-icon-right sbox-3-icon-plus\"])[6]");
    public By sumarnino = By.xpath("(//div[@class=\"_pnlpk-panel-scroll\"]  //descendant:: div[@class=\"_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg\"] //descendant:: a[@class=\"steppers-icon-right sbox-3-icon-plus\"])[6]");
    public By clase = By.xpath("//div[@class=\"_pnlpk-itemRow _pnlpk-select-flight-class-type-container\"] // descendant:: div[@class=\"sbox-3-select -md\"]");
    public By ejecutivo = By.xpath("//div[@class=\"_pnlpk-itemRow _pnlpk-select-flight-class-type-container\"] // descendant:: div[@class=\"sbox-3-select -md\"] // descendant:: option[@value=\"C\"]");
    public By buscar = By.xpath("(//a[@class=\\\"sbox-3-btn -primary -md sbox-search\\\"])[1]");
    public By edadnino = By.cssSelector("body > div.distpicker.distpicker-flights.sbox-v4-components > div > div._pnlpk-panel-scroll > div._pnlpk-panel__blocks > div > div._pnlpk-itemBlock__itemRows._pnlpk-dynamicContent > div > div._pnlpk-minors-age-select-wrapper > div._pnlpk-itemRow._pnlpk-minor-age-select._pnlpk-minor-age-select-last-item > div._pnlpk-itemRow__item._pnlpk-select-minor-age > div > div > select");
    public By edaduno = By.xpath("(//div[@class=\"_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item\"]//descendant::div[@class=\"_pnlpk-itemRow__item _pnlpk-select-minor-age\"]//descendant::select[@class=\"select-tag\"]//descendant::option[@value=\"1\"])[1]");


    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void ATC03V(){
        driver.get("https://www.viajesfalabella.cl");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement webElementCookies = driver.findElement(aceptarCookie);
        webElementCookies.click();
        WebElement webElementVuelo = driver.findElement(vuelo);
        webElementVuelo.click();
        WebElement webElementOrigen= driver.findElement(origen);
        webElementOrigen.sendKeys("Ezeiza");
        WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        exWait.until(ExpectedConditions.elementToBeClickable(resultado));
        WebElement webElementResultado = driver.findElement(resultado);
        webElementResultado.click();
        WebElement webElementDestino = driver.findElement(destino);
        webElementDestino.sendKeys("Arturo Merino Benitez");
        exWait.until(ExpectedConditions.elementToBeClickable(resultado));
        webElementResultado.click();
        WebElement webElementCalendario = driver.findElement(calendario);
        webElementCalendario.click();
        WebElement webElementFechaIda = driver.findElement(fechaIda);
        webElementFechaIda.click();
        WebElement webElementFechaVuelta = driver.findElement(fechaVuelta);
        js.executeScript("arguments[0].scrollIntoView();",webElementFechaVuelta );
        webElementFechaVuelta.click();
        //WebElement webElementAplicarFecha = driver.findElement(aplicar);
        //webElementAplicarFecha.click();
        WebElement webElementPersonas = driver.findElement(personas);
        webElementPersonas.click();
        WebElement webElementSumarAdulto = driver.findElement(sumaradulto);
        webElementSumarAdulto.click();
        WebElement webElementSumarNino = driver.findElement(sumarnino);
        webElementSumarNino.click();
        WebElement webElementEdadNino = driver.findElement(edadnino);
        js.executeScript("arguments[0].scrollIntoView();",webElementEdadNino );
        webElementEdadNino.click();
        WebElement webElementEdadUno = driver.findElement(edaduno);
        js.executeScript("arguments[0].scrollIntoView();",webElementEdadUno );
        webElementEdadUno.click();
        WebElement webElementClase = driver.findElement(clase);
        js.executeScript("arguments[0].scrollIntoView();",webElementClase );
        webElementClase.click();
        WebElement webElementEjecutivo = driver.findElement(ejecutivo);
        js.executeScript("arguments[0].scrollIntoView();",webElementEjecutivo );
        webElementEjecutivo.click();
        WebElement webElementBuscar = driver.findElement(buscar);
        webElementBuscar.click();




    }
}
