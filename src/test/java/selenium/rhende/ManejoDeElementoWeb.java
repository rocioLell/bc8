package selenium.rhende;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManejoDeElementoWeb {

    //llamamos el DriverManager
    public static WebDriver driver;
    public By localizadorDropDown = By.xpath("//select[contains(@id,\"dropdown\")]");
    public By localizadorBtnEnable = By.xpath("//a[text()=\"Enabled\"]");
    public By localozadorBtnDownload = By.id("ui-id-4");
    public By localizadorBtnPDF = By.xpath("//a[@href=\"/download/jqueryui/menu/menu.pdf\"]");
    public By localizadorCheckBoxes = By.xpath("//form[@id=\"checkboxes\"]//input");


    @BeforeClass
    public static void init(){

        WebDriverManager.chromedriver().setup();
    }

    @Before
    public  void setUp(){
        //preparacion de Driver ====> Navegador
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdown(){
    driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement WebElementDropDown = driver.findElement(localizadorDropDown);

        // Libreria Selenium  webElemento ==> Select
        Select manejoDropDown = new Select(WebElementDropDown);

        //operar el select o dropDown
        manejoDropDown.selectByValue("1");
        manejoDropDown.selectByValue("2");
        manejoDropDown.selectByVisibleText("Option 1");
        manejoDropDown.selectByVisibleText("Option 2");
        //manejoDropDown.deselectAll();

    }

    @Test
    public void menuUi() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
        WebElement elementEnable = driver.findElement(localizadorBtnEnable);
        elementEnable.click();
        Thread.sleep(1000);
        WebElement elementDownloads = driver.findElement(localozadorBtnDownload);
        elementDownloads.click();
        Thread.sleep(1000);
        WebElement elementPDF = driver.findElement(localizadorBtnPDF);
        elementPDF.click();
    }

    @Test
    public void checkbox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(localizadorCheckBoxes);
        for (WebElement chk:checkboxes){
            chk.click();
            Thread.sleep(1000);
        }

    }

    //cerramos la instancia del driver
    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}
