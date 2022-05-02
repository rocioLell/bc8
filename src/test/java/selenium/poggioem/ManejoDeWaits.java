package selenium.poggioem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class ManejoDeWaits {
    By localizadorButtonStart = By.xpath("//div[@id=\"start\"]//button");
    By localizadorTxtHolMund = By.xpath("//div[@id=\"finish\"]//h4");


    //3 tipos de espera: Implicita, explicita y fluentewait.

    static WebDriver driver;

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //Espera implicita afecta a los metodos findElement y findElements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Ciclo de espera de 500 ms
    }

    //Sincrono cuando pedimos a una pagina algo y nos entrega el DOM completo .
    //Asincrono las cosas que sobre escriben el DOM, que tardan...por asi decirlo wey.

    @Test
    public void waits(){
        //Esperas explicitas, debemos declarar un WebDriverWait
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Esto es un objeto que invocamos y declaramos los Ms.

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement botonStart = driver.findElement(localizadorButtonStart);
        botonStart.click();
        exwait.until(ExpectedConditions.elementToBeClickable(localizadorTxtHolMund));
        //Va a preguntar si se encuentra, despues de que cargue el DOM, cada tantos Ms como declaramos anteriormente.
        WebElement hello = driver.findElement(localizadorTxtHolMund);
        assertEquals("Hello World!", hello.getText());
    }

    @Test
    public void waitsFluent(){
        //FluenteWait :: mayor configuracion > WebElement asinc
        FluentWait<WebDriver> fluenteWait = new FluentWait<>(driver)       //Esto nos permite configurar
                .withTimeout(Duration.ofSeconds(10)) //Que espere 10s
                .pollingEvery(Duration.ofMillis(100)) //que revise cada 100 Ms
                .withMessage("Error de Time Out Fluent BC8") //mande mensaje de error si sale mal
                .ignoring(NoSuchElementException.class); //que tenga excepciones.

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement botonStart = driver.findElement(localizadorButtonStart);
        botonStart.click();
        fluenteWait.until(ExpectedConditions.elementToBeClickable(localizadorTxtHolMund));
        //Va a preguntar si se encuentra, despues de que cargue el DOM, cada tantos Ms como declaramos anteriormente.
        WebElement hello = driver.findElement(localizadorTxtHolMund);
        assertEquals("Hello World!", hello.getText());
    }


    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
