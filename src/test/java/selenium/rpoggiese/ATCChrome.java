package selenium.rpoggiese;

/*
1. Cargar Home
2. Introducir "chiffon dress" en el campo de búsqueda
3. Hacer clic en botón "Search"
4. Esperar a que cargue la página de Resultados.
5. Seleccionar el producto "Printed Chiffon Dress"
 */


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ATCChrome {

    public static WebDriver driver;
    public By localizadorBusqueda = By.xpath("//input[@class=\"search_query form-control ac_input\"]");
    public By localizadorSearch = By.xpath("//*[@class=\"btn btn-default button-search\"]");
    public By localizadorPrintedChiffonDress = By.xpath("//img[@alt=\"Printed Chiffon Dress\"]");

    @BeforeClass
    public static void init(){WebDriverManager.chromedriver().setup();}
    @Before
    public void  setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @Test
    public void chromeSession() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php");
        WebElement elementSRC = driver.findElement(localizadorBusqueda);
        elementSRC.click();
        Thread.sleep(1000);
        elementSRC.sendKeys("Printed Chiffon Dress");
        Thread.sleep(1000);
        WebElement elementButton = driver.findElement(localizadorSearch);
        elementButton.click();
        Thread.sleep(1000);
        WebElement elementDress = driver.findElement(localizadorPrintedChiffonDress);
        elementDress.click();
        Thread.sleep(3000);
    }
 /*
    @Test
    public void firefoxSession() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        WebElement elementSRC = driver.findElement(localizadorBusqueda);
        elementSRC.click();
        Thread.sleep(1000);
        elementSRC.sendKeys("Printed Chiffon Dress");
        Thread.sleep(1000);
        WebElement elementButton = driver.findElement(localizadorSearch);
        elementButton.click();
        Thread.sleep(1000);
        WebElement elementDress = driver.findElement(localizadorPrintedChiffonDress);
        elementDress.click();
        Thread.sleep(3000);
        driver.quit();
    } */
}
