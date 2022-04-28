package selenium.igarate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
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

public class ManejoDeWaits {

    public static WebDriver driver;
    public By localizadorBtnStart = By.xpath("//div[@id=\"start\"]//button");
    public By localizadorTextoHolaMundo = By.xpath("//div[@id=\"finish\"]//h4");

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
        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
    }

    @Test
    public void esperas(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btnStart = driver.findElement(localizadorBtnStart);
        btnStart.click();
        wait.until(ExpectedConditions.elementToBeClickable(localizadorTextoHolaMundo));
        WebElement textoHolaMundo = driver.findElement(localizadorTextoHolaMundo);
        String texto = textoHolaMundo.getText();
        Assert.assertEquals("Hello World!", texto);
    }
    @Test
    public void esperaFluent(){
        FluentWait <WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(100))
            .withMessage("Error de timeout BC(")
            .ignoring(NoSuchElementException.class);

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement btnStart = driver.findElement(localizadorBtnStart);
        btnStart.click();
        wait.until(ExpectedConditions.elementToBeClickable(localizadorTextoHolaMundo));
        WebElement textoHolaMundo = driver.findElement(localizadorTextoHolaMundo);
        String texto = textoHolaMundo.getText();
        Assert.assertEquals("Hello World!", texto);
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}
