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
import java.util.List;

public class ManejoCalendario {

    public static WebDriver driver;
    public By localizadorAlojamientosLink = By.xpath("//a[@href=\"//www.viajesfalabella.cl/hoteles\"]");
    public By localizadorCalendarioEntrada = By.xpath("//input[@placeholder=\"Entrada\"]");

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
    public void Calendario() {
        //Ingresamos a la página
        driver.get("https://www.viajesfalabella.cl/");

        //Nos dirigimos al apartado Alojamientos
        WebElement seccionAlojamientos = driver.findElement(localizadorAlojamientosLink);
        seccionAlojamientos.click();

        String mes = "Julio2022";
        String dia = "1";
        String diaSA = "8";

        WebElement calendario = driver.findElement(localizadorCalendarioEntrada);
        calendario.click();

        List<WebElement> meses = driver.findElements(By.xpath("//div[@class=\"_dpmg2--month-title\"]"));
        for (int i = 0; i < meses.size(); i++) {
            String mesActual = meses.get(i).getText();
            driver.findElement(By.xpath("//div[@class=\"_dpmg2--controls-next\"]")).click();
            if (mesActual.equalsIgnoreCase(mes)) {
                break;
            }
        }

        List<WebElement> dias = driver.findElements(By.xpath("//span[@class=\"_dpmg2--date _dpmg2--available\"]"));
        for (WebElement elemento : dias) {
            String diaEntrada = elemento.getText();
            if (diaEntrada.equals(dia)) {
                elemento.click();
            }
            break;
        }
    }
}

