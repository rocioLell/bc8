package selenium.rpoggiese;

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

public class ManejoDeElementosWeb {

    //atributo necesario
    public static WebDriver driver;
    public By localizadorDropdown = By.xpath("//select[@id=\"dropdown\"]");
    public By localizadorBtnEnabled = By.xpath("//a[text()=\"Enabled\"]");
    public By localizadorDownload = By.xpath("ui-id-4");
    public By localizadorPDF = By.xpath("//a[@href=\"/download/jqueryui/menu/menu.pdf\"]");


    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before

    public void setUp(){

        //preparacion de Driver = Navegador
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement WebElementDropdown = driver.findElement(localizadorDropdown);

        //libreria Selenium -> webElement -> Select
        Select manejoDropDown = new Select(WebElementDropdown);

        //operar el select o dropdown
        manejoDropDown.selectByValue("1");
        manejoDropDown.selectByValue("2");
        manejoDropDown.selectByVisibleText("Option 1");
        manejoDropDown.selectByVisibleText("Option 2");

    }
    @Test
    public void menuUI(){
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
        WebElement elementEnabled = driver.findElement(localizadorBtnEnabled);
        elementEnabled.click();
        //Thread.sleep(1000); //mala practica
        WebElement elementDownload = driver.findElement(localizadorDownload);
        elementDownload.click();
        //Thread.sleep(1000); //mala practica
        WebElement elementPDF = driver.findElement(localizadorPDF);
        elementPDF.click();
    }

    /*@Test
    public void checkbox(){
        driver.get("");
        List<WebElement> checkboxes = driver.findElement(localizadoresCheckBoxes);
        for (WebElement chk: checkboxes){
            chk.click();
            //Thread.sleep(1000); //mala practica

        }

    }*/

    @After
    public void close(){
        if (driver != null){
            driver.close();
        }
    }






}
