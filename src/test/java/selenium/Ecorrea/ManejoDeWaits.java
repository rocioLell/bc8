package selenium.Ecorrea;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ManejoDeWaits {


    //atributos
    public static WebDriver driver;
    public By localizadorBotonStart = By.id("//*[@id=\"start\"]/button");
    public By localizadorHelloWord = By.id("//*[@id=\"finish\"]");



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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //ciclo de espera de 500ms

    }

    @Test
    public void esperaExplicita() {
        WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btnstart = driver.findElement(localizadorBotonStart);
        btnstart.click();
        exwait.until(ExpectedConditions.elementToBeClickable(localizadorHelloWord));
        WebElement Hello = driver.findElement(localizadorHelloWord);
        assertEquals("Hello World",Hello.getText());


    }
    @Test
    public void esperaFluent(){
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofMillis(100))
                .withMessage("error de timeput fluent 8c8")

                .ignoring(NoSuchElementException.class);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btnstart = driver.findElement(localizadorBotonStart);
        btnstart.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(localizadorHelloWord));
        WebElement Hello = driver.findElement(localizadorHelloWord);
        assertEquals("Hello World",Hello.getText());


    }



    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
