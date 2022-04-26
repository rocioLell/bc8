package selenium.equipo2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class PaquetesChromeVersion {

    public static WebDriver driver;


    //Localizadores generales.
    By swithTodaviaNoHeDecididoFecha = By.xpath("//label[@class=\"switch-label sbox-switch-container\"]");

    //Localizadores paquetes.
    By botonPaquetes = By.xpath("//a[@title=\"Paquetes\"]");
    By botonVueloAlojamiento = By.xpath("//input[@value=\"vh\"]");
    By divOrigen = By.xpath("//div[@class=\"input-container\" and label[text()=\"Origen\"]]");
    By divDestino = By.xpath("//div[@class=\"input-container\" and label[text()=\"Destino\"]]");
    By divHabitaciones = By.xpath("//div[@class=\"sbox-distri-input-container sbox-distribution-picker-wrapper\"]");



    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void ATC02PQ(){
    driver.get("https://www.viajesfalabella.cl/");


    }




    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }

    }
}
