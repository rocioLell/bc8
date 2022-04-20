package selenium.poggioem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class EjercicioOrdenarNombres {

    public static WebDriver driver;
    public By localizadorWebTables = By.tagName("table");

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void webTablesOrdenarPorNombre() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tables = driver.findElements(localizadorWebTables);
        List <WebElement> columnas = tables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th")); //busqueda dentro de una busqueda
        if(columnas.get(1).getText().contains("First Name")){
            columnas.get(1).click();
        }
        List<WebElement> filas = tables.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for (WebElement fila : filas) {
            System.out.println(fila.findElement(By.xpath("td[2]")).getText());
        }
    }

        @After
        public void close(){
            if(driver != null){
                driver.close();
            }
        }
    }
