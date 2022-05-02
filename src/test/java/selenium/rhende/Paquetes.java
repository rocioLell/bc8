package selenium.rhende;

import io.github.bonigarcia.wdm.WebDriverManager;
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

    public static WebDriver driver;

    public By localizadorCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    //public By localizadorOrigenPaquetes = By.xpath("//input[contains(@class, \"input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container\")]");
    public By localizadorOrigenPaquetes = By.xpath("//input[contains(@class, \"sbox-origin\")]");
    public By localizadorAutocompletadoOrigen = By.xpath("//li[@class=\"item -active\"]");
    public By localizadorDestinoVuelos = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-roundtrip-destination-input sbox-secondary\")]");
    public By localizadorFechaSalida = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-start-date-input\")]");
    public By localizadorMesActivo = By.xpath("//div[contains(@class, \"_dpmg2--month-active\")]");
    public By localizadorFlechaProximaFecha = By.xpath("//div[@class = \"_dpmg2--controls-next\"]/descendant::i");

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setUp(){
        //preparar el driver
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void busquedaDePaquetes(){

        // fecha de ida -> 09/05/2022
        int diaIda = 9;
        int mesIda = 5;
        int anioIda = 2022;

        // fecha de vuelta -> 23/05/2022
        int diaVuelta = 23;
        int mesVuelta = 5;
        int anioVuelta = 2022;

        //Cargamos origen "Santiago de Chile, Chile"
        String origen = "bue";

        //Cargamos destino "Miami, Estados Unidos"
        String destino = "esp";

        driver.get("https://www.viajesfalabella.cl/paquetes");
        WebElement cookie = driver.findElement(localizadorCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebElement origenn = driver.findElement(localizadorOrigenPaquetes);
        origenn.click();
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(2));
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocompletadoOrigen));
        WebElement autocompletar = driver.findElement(localizadorAutocompletadoOrigen);
        autocompletar.click();

        WebElement destinoo = driver.findElement(localizadorDestinoVuelos);
        destinoo.sendKeys(destino);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocompletadoOrigen));
        autocompletar.click();

        WebElement fechaSalida = driver.findElement(localizadorFechaSalida);
        fechaSalida.click();
        WebElement flechaProximaFecha = driver.findElement(localizadorFlechaProximaFecha);
        WebElement mesActivo = driver.findElement(localizadorMesActivo);
        String mes = mesActivo.getAttribute("data-month").split("-")[1];//toma el segundo parametro -> mes
        String anio = mesActivo.getAttribute("data-month").split("-")[0];//toma el primer parametro -> año


    }



/*
    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
*/

}
