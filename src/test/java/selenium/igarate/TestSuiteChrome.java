package selenium.igarate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestSuiteChrome {

    public static WebDriver driver;
    public By localizadorSearch = By.xpath("//input[@name=\"search_query\"]");
    public By localizadorSearchBtn= By.xpath("//button[@name=\"submit_search\"]");
    public By localizadorSpanBusqueda= By.xpath("//span[@class=\"lighter\"]");
    public By localizadorDress= By.xpath("//a[@title=\"Printed Chiffon Dress\" and @class=\"product-name\"]");
    public By localizadorPresult = By.xpath("//p[@class=\"alert alert-warning\"]");
    public By localizadoraAutoComplete = By.xpath("//li[text()=\"Blouses > \"]");
    public By localizadorBlusa = By.xpath("//p[@id=\"product_reference\"]");
    public By localizadorDropdown = By.xpath("//select[@name=\"group_1\"]");
    public By localizadorColor = By.xpath("//a[@name=\"White\"]");
    public By localizadorAddToCart = By.xpath("//span[text() = \"Add to cart\"]");
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
    }

    @Test public void ACT01(){
        //Abrir la pagina
        driver.get("http://automationpractice.com/index.php");
        WebElement search = driver.findElement(localizadorSearch);
        search.sendKeys("chiffon dress");
        WebElement searchBtn = driver.findElement(localizadorSearchBtn);
        searchBtn.click();
        WebElement spanBusqueda = driver.findElement(localizadorSpanBusqueda);
        String textoSpan = spanBusqueda.getText();
        Assert.assertEquals("\"CHIFFON DRESS\"",textoSpan);
    }

    @Test public void ACT02(){
        //Abrir la pagina
        driver.get("http://automationpractice.com/index.php");
        WebElement search = driver.findElement(localizadorSearch);
        search.sendKeys("chiffon dress");
        WebElement searchBtn = driver.findElement(localizadorSearchBtn);
        searchBtn.click();
        WebElement dress = driver.findElement(localizadorDress);
        dress.click();
    }

    @Test public void ACT03(){
        //Abrir la pagina
        driver.get("http://automationpractice.com/index.php");
        WebElement search = driver.findElement(localizadorSearch);
        search.sendKeys("liquido matapulgas");
        search.sendKeys(Keys.ENTER);
        WebElement result = driver.findElement(localizadorPresult);
        String pResult = result.getText();
        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", pResult);
    }

    @Test public void ACT04() {
        //Abrir la pagina
        driver.get("http://automationpractice.com/index.php");
        WebElement search = driver.findElement(localizadorSearch);
        search.sendKeys("blo");
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(5));
        delay.until(ExpectedConditions.elementToBeClickable(localizadoraAutoComplete));
        WebElement autoComplete = driver.findElement(localizadoraAutoComplete);
        autoComplete.click();
        WebElement blusa = driver.findElement(localizadorBlusa);
        Assert.assertEquals("Model demo_2", blusa.getText());
    }

    @Test public void ACT05() {
        //Abrir la pagina
        driver.get("http://automationpractice.com/index.php");
        WebElement search = driver.findElement(localizadorSearch);
        search.sendKeys("blo");
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(5));
        delay.until(ExpectedConditions.elementToBeClickable(localizadoraAutoComplete));
        WebElement autoComplete = driver.findElement(localizadoraAutoComplete);
        autoComplete.click();
        WebElement dropdown = driver.findElement(localizadorDropdown);
        Select manejoDropdown = new Select (dropdown);
        manejoDropdown.selectByVisibleText("L");
        WebElement color = driver.findElement(localizadorColor);
        color.click();
        WebElement addToCart = driver.findElement(localizadorAddToCart);
        addToCart.click();
    }


    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }


}
