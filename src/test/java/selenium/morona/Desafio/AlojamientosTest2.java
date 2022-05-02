package selenium.morona.Desafio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlojamientosTest2 {
    //Atributos
    public static WebDriver driver;
    public By localizadorAlojamientosLink = By.xpath("//a[@href=\"//www.viajesfalabella.cl/hoteles\"]");
    public By localizadorBarraDeBusqueda = By.xpath("//input[@type=\"text\"]");
    public By localizadorBtnBuscar = By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");
    public By localizadorMsjEntrada = By.xpath("(//span[@class=\"validation-msg\"])[2]");
    public By localizadorMsjSalida = By.xpath("(//span[@class=\"validation-msg\"])[3]");


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
    }
    @Test
    public void mensajeAlnoSelecionarFecha(){
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
        if (msjEntrada.getText().contains("Ingresa una fecha de entrada.")){
            System.out.println("El mensaje Ingresa una fecha de entrada se muestra correctamente.");

        }

        WebElement msjSalida = driver.findElement(localizadorMsjSalida);
        if (msjSalida.getText().contains("Ingresa una fecha de salida.")){
            System.out.println("El mensaje Ingresa una fecha de salida se muestra correctamente.");

        }
    }
    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
