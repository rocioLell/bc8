package selenium.morona;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ManejoWaits {
    public static WebDriver driver;
    public By localizadorBtn = By.xpath("//button[\"start\"]");
    public By localizadorDeTexto = By.xpath("(//h4[\"Hello World!\"])[2]");
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ciclo de espera de 500ms
    }

    @Test
    public void esperas(){
        WebDriverWait explicita =new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement bTnStart = driver.findElement(localizadorBtn);
        bTnStart.click();
        explicita.until(ExpectedConditions.elementToBeClickable(localizadorDeTexto));
        WebElement texto = driver.findElement(localizadorDeTexto);
        Assert.assertEquals("Hello World!",texto.getText());

    }
    @Test
    public void esperaFluent(){
        //mayor configuración
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .withMessage("Error de timeout Fluent bootcamp")
                .ignoring(NoSuchElementException.class);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement bTnStart = driver.findElement(localizadorBtn);
        bTnStart.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(localizadorDeTexto));
        WebElement texto = driver.findElement(localizadorDeTexto);
        Assert.assertEquals("Hello World!",texto.getText());
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}
