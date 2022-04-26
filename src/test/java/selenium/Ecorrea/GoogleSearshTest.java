package selenium.Ecorrea;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class GoogleSearshTest {

    private WebDriver driver;
    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();


    }

    @Before
    public void setUp(){
        //preparacion de Driver = Manager
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");//es la pagina que abrira el navegador

    }
    @Test

    public void testGooglePage(){

        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("quality-stream Introduccion a la automatizacion de pruebas de software");//es el texto en la barra de busqueda
        searchbox.submit();//es como dar enter
       /* driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//espera implicita */
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ewait.until(ExpectedConditions.titleContains("quakity-stream"));

        assertEquals("quality-stream Introduccion a la automatizacion de pruebas de software",driver.getTitle());

    }
    @After
    public void tearDown(){
        if (driver != null) {
            driver.close();
        }

    }
}
