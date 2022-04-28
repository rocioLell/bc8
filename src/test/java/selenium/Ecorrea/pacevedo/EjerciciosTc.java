package selenium.pacevedo;

import com.fasterxml.jackson.databind.util.TypeKey;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Type;
import java.time.Duration;
import java.util.List;

public class EjerciciosTc {

    //atributos
    public static WebDriver driver;




    public By search = By.xpath("//input[@class=\"search_query form-control ac_input\"]");
    public By lupa = By.xpath("//button[@class=\"btn btn-default button-search\"]");
    public By vestido = By.xpath("//div[@class=\"product-image-container\"]/descendant::img[@title=\"Printed Chiffon Dress\"]");
    public By autoCompletar =By.xpath("//div[@class=\"ac_results\"]");
    public By talla= By.id("group_1");
    public By color= By.id("color_8");
    public By carrito=By.xpath("//p[@id=\"add_to_cart\"]");






    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
       // WebDriverManager.edgedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //driver = new EdgeDriver();
        //driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
    }

    @Test
    public void home() {
        driver.get("http://automationpractice.com/");
        WebElement WebElementSearch = driver.findElement(search);
        WebElement WebElementLupa = driver.findElement(lupa);
        WebElementSearch.sendKeys("chiffon dress");
        WebElementLupa.click();
        String url= driver.getCurrentUrl();
        assertEquals("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=chiffon+dress&submit_search=", url);
    }
    @Test
    public void home2() {
        driver.get("http://automationpractice.com/");
        WebElement WebElementSearch = driver.findElement(search);
        WebElement WebElementLupa = driver.findElement(lupa);
        WebElementSearch.sendKeys("chiffon dress");
        WebElementLupa.click();
        String url= driver.getCurrentUrl();
        assertEquals("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=chiffon+dress&submit_search=", url);
        WebElement WebElementVestido = driver.findElement(vestido);
        WebElementVestido.click();
    }
    @Test
    public void home3() {
        driver.get("http://automationpractice.com/");
        WebElement WebElementSearch = driver.findElement(search);
        WebElement WebElementLupa = driver.findElement(lupa);
        WebElementSearch.sendKeys("liquido matapulgas");
        WebElementLupa.submit();
    }
    @Test
    public void home4() {
        WebDriverWait exWait= new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/");
        WebElement WebElementSearch = driver.findElement(search);
        WebElementSearch.sendKeys("blo");
        exWait.until(ExpectedConditions.elementToBeClickable(autoCompletar));
        WebElement webElementAutocompletar= driver.findElement(autoCompletar);
        webElementAutocompletar.click();


        }
    @Test
    public void home5() {
        WebDriverWait exWait= new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("http://automationpractice.com/");
        WebElement WebElementSearch = driver.findElement(search);
        WebElementSearch.sendKeys("blo");
        exWait.until(ExpectedConditions.elementToBeClickable(autoCompletar));
        WebElement webElementAutocompletar= driver.findElement(autoCompletar);
        webElementAutocompletar.click();
        WebElement webElementTalla= driver.findElement(talla);
        Select elecciontalla= new Select(webElementTalla);
        elecciontalla.selectByValue("3");
        WebElement webElementcolor= driver.findElement(color);
        webElementcolor.click();
        WebElement webElementCarro= driver.findElement(carrito);
        webElementCarro.click();

    }



   @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}




