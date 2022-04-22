package selenium.jvegas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class EjerciciosTcChrome {
    //atributos
    public static WebDriver driver;

    public By search = By.xpath("//input[@class=\"search_query form-control ac_input\"]");
    public By lupa = By.xpath("//button[@class=\"btn btn-default button-search\"]");
    public By vestido = By.xpath("//div[@class=\"product-image-container\"]/descendant::img[@title=\"Printed Chiffon Dress\"]");
    public By autoCompletar = By.xpath("//div[@class=\\\"ac_results\\\"]");

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
    public void home() {
        driver.get("http://automationpractice.com/");
        WebElement WebElementSearch = driver.findElement(search);
        WebElement WebElementLupa = driver.findElement(lupa);
        WebElementSearch.sendKeys("chiffon dress");
        WebElementLupa.click();
        String url = driver.getCurrentUrl();
        assertEquals("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=chiffon+dress&submit_search=", url);

    }

    @Test
    public void home2() {
        driver.get("http://automationpractice.com/");
        WebElement WebElementSearch = driver.findElement(search);
        WebElement WebElementLupa = driver.findElement(lupa);
        WebElementSearch.sendKeys("chiffon dress");
        WebElementLupa.click();
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
    /*
    @Test
    public void home4(){
        driver.get("http://automationpractice.com/");
        WebElement WebElementSearch = driver.findElement(search);
        WebElementSearch.sendKeys("blo");
        WebElement AutoCompletado = driver.findElement(autoCompletar);
        AutoCompletado.click();
    }
    */
}
