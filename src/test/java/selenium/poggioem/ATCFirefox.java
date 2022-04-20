package selenium.poggioem;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class ATCFirefox {

        public static WebDriver driver;
        //localizadores test1
        public By localizadorBusqueda = By.xpath("//input[@class=\"search_query form-control ac_input\"]");
        public By localizadorSearch = By.xpath("//*[@class=\"btn btn-default button-search\"]");
        public By localizadorPrintedChiffonDress = By.xpath("//img[@alt=\"Printed Chiffon Dress\"]");
        public By localizadorDressName = By.xpath("//h1[@itemprop=\"name\"]");

        //localizadores test5
        public By localizadorBlouses = By.xpath("//div[@class=\"ac_results\"]");
        public By localizadorBlousesNombre = By.xpath("//h1[@itemprop=\"name\"]");
        public By localizadorBlouseModelo = By.xpath("//p[@id=\"product_reference\"]");

        @BeforeClass
        public static void init(){
            WebDriverManager.firefoxdriver().setup();}
        @Before
        public void  setUp(){
            driver = new FirefoxDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }

        @Test
        public void ATC01() throws InterruptedException {
            boolean resultadoT1 = false;
            driver.get("http://automationpractice.com/index.php");
            WebElement elementSRC = driver.findElement(localizadorBusqueda);
            elementSRC.click();
            elementSRC.sendKeys("Printed Chiffon Dress");
            WebElement elementButton = driver.findElement(localizadorSearch);
            elementButton.click();
            WebElement elementDress = driver.findElement(localizadorPrintedChiffonDress);
            elementDress.click();
            Thread.sleep(2000);
            WebElement elementName = driver.findElement(localizadorDressName);
            if(elementName.getText().contains("Printed Chiffon Dress")){
                resultadoT1 = true;
            }
            assertEquals(true,resultadoT1);
        }


        @Test
        public void ATC05() throws InterruptedException {
            boolean resultadoT5=false;
            driver.get("http://automationpractice.com/index.php");
            WebElement elementSRC = driver.findElement(localizadorBusqueda);
            elementSRC.click();
            elementSRC.sendKeys("blo");
            Thread.sleep(2000);
            WebElement blouses = driver.findElement(localizadorBlouses);
            blouses.click();
            WebElement blousesname = driver.findElement(localizadorBlousesNombre);
            WebElement blousesmodel = driver.findElement(localizadorBlouseModelo);
            if (blousesname.getText().contains("Blouse") && blousesmodel.getText().contains("Model demo_2")){
                resultadoT5 = true;
            }
            assertEquals(true,resultadoT5);
        }

    }

