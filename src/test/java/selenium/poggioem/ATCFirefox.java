package selenium.poggioem;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ATCFirefox {

        public static WebDriver driver;

        //localizadores test1y2
        public By localizadorBusqueda = By.xpath("//input[@class=\"search_query form-control ac_input\"]");
        public By localizadorSearch = By.xpath("//*[@class=\"btn btn-default button-search\"]");
        public By localizadorPrintedChiffonDress = By.xpath("//a[@class=\"product-name\" and @title=\"Printed Chiffon Dress\"]");
        public By localizadorDressName = By.xpath("//div[@class=\"pb-center-column col-xs-12 col-sm-4\"]");

        //localizadores test3
        public By localizadorTextoError = By.xpath("//*[@id=\"center_column\"]/p");


        //localizadores test4
        public By localizadorBlouses = By.xpath("//div[@class=\"ac_results\"]");
        public By localizadorBlousesNombre = By.xpath("//h1[@itemprop=\"name\"]");
        public By localizadorBlouseModelo = By.xpath("//p[@id=\"product_reference\"]");

        //localizadores test5
        public By localizadorBlouseMD2 = By.xpath("//a[@class=\"product-name\" and @title=\"Blouse\"]");
        public By localizadorColorBlanco = By.xpath("//a[@id=\"color_8\" and @name=\"White\"]");
        public By localicadorSelectorTalles = By.xpath("//div[@class=\"selector\"]");
        public By localizadorSelectorTalleL= By.xpath("//option[@value=\"3\"]");
        public By localizadorBotonCarrito = By.xpath("//button[@type=\"submit\" and @class=\"exclusive\"]");
        public By localizadorDatosGeneralesCarrito = By.xpath("//div[@class=\"layer_cart_product col-xs-12 col-md-6\"]");


        @BeforeClass
        public static void init(){
            WebDriverManager.firefoxdriver().setup();}
        @Before
        public void  setUp(){
            driver = new FirefoxDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }

    @Test
    public void ATC01(){
        boolean resultadoT1 = false;
        driver.get("http://automationpractice.com/index.php");
        WebElement elementSRC = driver.findElement(localizadorBusqueda);
        elementSRC.click();
        elementSRC.sendKeys("chiffon dress");
        WebElement elementButton = driver.findElement(localizadorSearch);
        elementButton.click();
        String url = driver.getCurrentUrl();
        if (url.contains("chiffon+dress")){
            resultadoT1=true;
        }
        assertTrue(resultadoT1);
    }

        @Test
        public void ATC02(){
            boolean resultadoT2 = false;
            driver.get("http://automationpractice.com/index.php");
            WebElement elementSRC = driver.findElement(localizadorBusqueda);
            elementSRC.click();
            elementSRC.sendKeys("Printed Chiffon Dress");
            WebElement elementButton = driver.findElement(localizadorSearch);
            elementButton.click();
            WebElement elementDress = driver.findElement(localizadorPrintedChiffonDress);
            elementDress.click();
            WebElement elementName = driver.findElement(localizadorDressName);
            if(elementName.getText().contains("Printed Chiffon Dress")){
                resultadoT2 = true;
            }
            assertTrue(resultadoT2);
        }

    @Test
    public void ATC03(){
        boolean resultado3 = false;
        driver.get("http://automationpractice.com/index.php");
        WebElement elementSRC = driver.findElement(localizadorBusqueda);
        elementSRC.click();
        elementSRC.sendKeys("liquido matapulgas");
        elementSRC.sendKeys(Keys.RETURN);
        WebElement elementError = driver.findElement(localizadorTextoError);
        if (elementError.getText().contains("No results were found for your search")){
            resultado3 = true;
        }
        assertTrue(resultado3);
    }

        @Test
        public void ATC04(){
            boolean resultadoT4=false;
            driver.get("http://automationpractice.com/index.php");
            WebElement elementSRC = driver.findElement(localizadorBusqueda);
            elementSRC.click();
            elementSRC.sendKeys("blo");
            WebElement blouses = driver.findElement(localizadorBlouses);
            blouses.click();
            WebElement blousesname = driver.findElement(localizadorBlousesNombre);
            WebElement blousesmodel = driver.findElement(localizadorBlouseModelo);
            if (blousesname.getText().contains("Blouse") && blousesmodel.getText().contains("Model demo_2")){
                resultadoT4 = true;
            }
            assertTrue(resultadoT4);
        }

        @Test
        public void ATC05(){
            WebDriverWait exwait = new WebDriverWait(driver, Duration.ofSeconds(5));
            boolean resultado5 = false;
            driver.get("http://automationpractice.com/index.php");
            WebElement elementSRC = driver.findElement(localizadorBusqueda);
            elementSRC.click();
            elementSRC.sendKeys("Blouse");
            elementSRC.sendKeys(Keys.RETURN);
            WebElement elementBlouseMD2 = driver.findElement(localizadorBlouseMD2);
            elementBlouseMD2.click();
            WebElement elementColorBlanco = driver.findElement(localizadorColorBlanco);
            elementColorBlanco.click();
            WebElement elementoTalles = driver.findElement(localicadorSelectorTalles);
            elementoTalles.click();
            WebElement elementTalleL = driver.findElement(localizadorSelectorTalleL);
            if (elementTalleL.getText().contains("L")){
                elementTalleL.click();
            }
            WebElement elementCarrito = driver.findElement(localizadorBotonCarrito);
            elementCarrito.click();
            exwait.until(ExpectedConditions.elementToBeClickable(localizadorDatosGeneralesCarrito));
            WebElement elementoDatosAdd = driver.findElement(localizadorDatosGeneralesCarrito);
            if (elementoDatosAdd.getText().contains("Product successfully added to your shopping cart") && elementoDatosAdd.getText().contains("Blouse") && elementoDatosAdd.getText().contains("White, L")){
                resultado5 = true;
            }
            assertTrue(resultado5);
        }

    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
}

