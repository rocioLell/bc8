
package selenium.rhende;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;


import java.time.Duration;

public class ManejoDeWaits {

    static WebDriver driver;
    By localizadorBotonStart = By.xpath("//div[@id=\"start\"]//button");
    By localizadorTextoHolaMundo = By.xpath("//div[@id=\"finish\"]//h4");

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
        // espera implicita efecta a los findelement y findelements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void esperas(){
        // Esperas explicias debemos declarar un WebDriverWait
        WebDriverWait exwait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement botonStart = driver.findElement((localizadorBotonStart));
        botonStart.click();

        exwait.until(ExpectedConditions.elementToBeClickable(localizadorTextoHolaMundo));//consulta si se encuantra -> cada 500 ms

        WebElement hello = driver.findElement(localizadorTextoHolaMundo);
        Assert.assertEquals("Hello World!",hello.getText());
    }

    @Test
    public void esperaFluent(){
        //FluentWait :: Mayor configuracion -> trabaja con elementos async
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .withMessage("Error de TimeOut Fluent BC8")
                .ignoring(NoSuchElementException.class);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement botonStart = driver.findElement((localizadorBotonStart));
        botonStart.click();

        fluentWait.until(ExpectedConditions.elementToBeClickable(localizadorTextoHolaMundo));

        WebElement hello = driver.findElement(localizadorTextoHolaMundo);
        Assert.assertEquals("Hello World!",hello.getText());


    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}
