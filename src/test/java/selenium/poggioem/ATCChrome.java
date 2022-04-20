package selenium.poggioem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ATCChrome {

    public static WebDriver driver;

    //localizadores test1y2
    public By localizadorBusqueda = By.xpath("//input[@class=\"search_query form-control ac_input\"]");
    public By localizadorSearch = By.xpath("//*[@class=\"btn btn-default button-search\"]");
    public By localizadorPrintedChiffonDress = By.xpath("//a[@class=\"product-name\" and @title=\"Printed Chiffon Dress\"]");
    public By localizadorDressName = By.xpath("//div[@class=\"pb-center-column col-xs-12 col-sm-4\"]");

    //localizador test3
    public By localizadorTextoError = By.xpath("//*[@id=\"center_column\"]/p");

    //localizadores test4
    public By localizadorBlouses = By.xpath("//div[@class=\"ac_results\"]");
    public By localizadorBlousesNombre = By.xpath("//h1[@itemprop=\"name\"]");
    public By localizadorBlouseModelo = By.xpath("//p[@id=\"product_reference\"]");

    //localizadores test5
    public By localizadorBlouseMD2 = By.xpath("//a[@class=\"product-name\" and @title=\"Blouse\"]");
    public By localizadorColorBlanco = By.xpath("//a[@id=\"color_8\" and @name=\"White\"]");
    public By localicadorSelectorTalles = By.xpath("//div[@class=\"selector\"]");
    public By localizadorSelectorTalleL = By.xpath("//option[@value=\"3\"]");
    public By localizadorBotonCarrito = By.xpath("//button[@type=\"submit\" and @class=\"exclusive\"]");
    public By localizadorDatosGeneralesCarrito = By.xpath("//div[@class=\"layer_cart_product col-xs-12 col-md-6\"]");


    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void ATC01() throws InterruptedException {
        boolean resultadoT1 = false;
        driver.get("http://automationpractice.com/index.php");
        WebElement elementSRC = driver.findElement(localizadorBusqueda);
        elementSRC.click();
        Thread.sleep(1000);
        elementSRC.sendKeys("chiffon dress");
        Thread.sleep(1000);
        WebElement elementButton = driver.findElement(localizadorSearch);
        elementButton.click();
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        if (url.contains("chiffon+dress")){
            resultadoT1=true;
        }
        assertTrue(resultadoT1);
    }

    @Test
    public void ATC02() throws InterruptedException {
        boolean resultadoT2 = false;
        driver.get("http://automationpractice.com/index.php");
        WebElement elementSRC = driver.findElement(localizadorBusqueda);
        elementSRC.click();
        elementSRC.sendKeys("Printed Chiffon Dress");
        WebElement elementButton = driver.findElement(localizadorSearch);
        elementButton.click();
        Thread.sleep(2000);
        WebElement elementDress = driver.findElement(localizadorPrintedChiffonDress);
        elementDress.click();
        Thread.sleep(10000);
        WebElement elementName = driver.findElement(localizadorDressName);
        Thread.sleep(2000);
        if (elementName.getText().contains("Printed Chiffon Dress")) {
            resultadoT2 = true;
        }
        assertTrue(resultadoT2);
    }

    @Test
    public void ATC03() throws InterruptedException {
        boolean resultadoT3 = false;
        driver.get("http://automationpractice.com/index.php");
        WebElement elementSRC = driver.findElement(localizadorBusqueda);
        elementSRC.click();
        Thread.sleep(1000);
        elementSRC.sendKeys("liquido matapulgas");
        Thread.sleep(1000);
        elementSRC.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        WebElement elementError = driver.findElement(localizadorTextoError);
        if (elementError.getText().contains("No results were found for your search")){
            resultadoT3 = true;
        }
        assertTrue(resultadoT3);
    }

    @Test
    public void ATC04() throws InterruptedException {
        boolean resultadoT4 = false;
        driver.get("http://automationpractice.com/index.php");
        WebElement elementSRC = driver.findElement(localizadorBusqueda);
        elementSRC.click();
        elementSRC.sendKeys("blo");
        Thread.sleep(4000);
        WebElement blouses = driver.findElement(localizadorBlouses);
        blouses.click();
        WebElement blousesname = driver.findElement(localizadorBlousesNombre);
        WebElement blousesmodel = driver.findElement(localizadorBlouseModelo);
        if (blousesname.getText().contains("Blouse") && blousesmodel.getText().contains("Model demo_2")) {
            resultadoT4 = true;
        }
        assertTrue(resultadoT4);
    }

    @Test
    public void ATC05() throws InterruptedException {
        boolean resultadoT5 = false;
        driver.get("http://automationpractice.com/index.php");
        WebElement elementSRC = driver.findElement(localizadorBusqueda);
        elementSRC.click();
        elementSRC.sendKeys("Blouse");
        elementSRC.sendKeys(Keys.RETURN);
        Thread.sleep(1000);
        WebElement elementBlouseMD2 = driver.findElement(localizadorBlouseMD2);
        elementBlouseMD2.click();
        Thread.sleep(3000);
        WebElement elementColorBlanco = driver.findElement(localizadorColorBlanco);
        elementColorBlanco.click();
        Thread.sleep(1000);
        WebElement elementoTalles = driver.findElement(localicadorSelectorTalles);
        elementoTalles.click();
        Thread.sleep(1000);
        WebElement elementTalleL = driver.findElement(localizadorSelectorTalleL);
        if (elementTalleL.getText().contains("L")) {
            elementTalleL.click();
            Thread.sleep(1000);
        }
        WebElement elementCarrito = driver.findElement(localizadorBotonCarrito);
        elementCarrito.click();
        Thread.sleep(7000);
        WebElement elementoDatosAdd = driver.findElement(localizadorDatosGeneralesCarrito);
        if (elementoDatosAdd.getText().contains("Product successfully added to your shopping cart") && elementoDatosAdd.getText().contains("Blouse") && elementoDatosAdd.getText().contains("White, L")) {
            resultadoT5 = true;
        }
        assertTrue(resultadoT5);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}