package selenium.rhende;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;

public class ActividadesSeleniumFireFox {

    //atributos
    public static WebDriver driver;
    public By localizadorBarradebusqueda = By.id("search_query_top");
    public By localizadordropdown1 = By.xpath("//div[@ class=\"ac_results\"]");
    public By localizadorBtnSearch = By.xpath("//button[@type=\"submit\"]");
    public By localizadorImgProducto = By.xpath("//img[@alt=\"Printed Chiffon Dress\"]");
    public By localizadordropdown2 = By.xpath("//select[@name=\"group_1\"]");
    public By localizadorColor = By.xpath("//a[@name=\"White\"]");
    public By localizadorBtnCarrito = By.xpath("//button[@ class=\"exclusive\"]");


    @BeforeClass
    public static void init() {
      //  WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @Before
    public void setUp() {
        //preparacion de Driver = Navegador
        driver = new EdgeDriver();
        //driver = new FirefoxDriver(); //Firefox -> navegador
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @Test
    public void busquedaDirecta1() {
        driver.get("http://automationpractice.com/index.php");
        WebElement barraDeBusqueda = driver.findElement(localizadorBarradebusqueda);
        barraDeBusqueda.sendKeys("chiffon dress");
        barraDeBusqueda.click();
        WebElement btnSearch = driver.findElement(localizadorBtnSearch);
        btnSearch.click();


        assertEquals("Search - My Store", driver.getTitle());

    }

    @Test
    public void busquedaDirecta2()  {
        driver.get("http://automationpractice.com/index.php");
        WebElement barraDeBusqueda = driver.findElement(localizadorBarradebusqueda);
        barraDeBusqueda.sendKeys("chiffon dress");
        WebElement btnSearch = driver.findElement(localizadorBtnSearch);
        btnSearch.click();

        WebElement imagenProducto = driver.findElement(localizadorImgProducto);

        imagenProducto.click();
    }

    @Test
    public void tiendaEmiteError() {
        driver.get("http://automationpractice.com/index.php");
        WebElement barraDeBusqueda = driver.findElement(localizadorBarradebusqueda);
        barraDeBusqueda.sendKeys("liquido matapulgas");
        barraDeBusqueda.submit();

    }

    @Test
    public void listaDinamica() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement barraDeBusqueda = driver.findElement(localizadorBarradebusqueda);
        barraDeBusqueda.sendKeys("blo");
        barraDeBusqueda.click();
        Thread.sleep(5000);
        WebElement webElementDropdown = driver.findElement(localizadordropdown1);
        webElementDropdown.click();

    }

    @Test
    public void cambiarTallayColor() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement barraDeBusqueda = driver.findElement(localizadorBarradebusqueda);
        barraDeBusqueda.sendKeys("blo");
        barraDeBusqueda.click();

        Thread.sleep(5000);
        WebElement webElementDropdown = driver.findElement(localizadordropdown1);
        webElementDropdown.click();

        WebElement webElementDropdown2 = driver.findElement(localizadordropdown2);
        Select dropdown = new Select(webElementDropdown2);
        dropdown.selectByValue("3");

        WebElement btnColor = driver.findElement(localizadorColor);
        btnColor.click();

        WebElement btnCarrito = driver.findElement(localizadorBtnCarrito);
        btnCarrito.click();

    }

    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}
