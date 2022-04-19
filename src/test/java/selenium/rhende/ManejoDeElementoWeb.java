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

public class ManejoDeElementoWeb {

    //llamamos el DriverManager
    public static WebDriver driver;
    public By localizadorDropDown = By.xpath("//select[contains(@id,\"dropdown\")]");
    public By localizadorBtnEnable = By.xpath("https://the-internet.herokuapp.com/jqueryui/menu#");

    public ManejoDeElementoWeb(WebElement webElementDropDown) {
    }


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

        // Libreria e Selenium  webElemento ==> Select
        Select manejoDropDown = new Select(WebElementDropDown);

        //operar el slect o dropDown
        manejoDropDown.selectByValue("1");
        manejoDropDown.selectByValue("2");
        manejoDropDown.selectByVisibleText("Option 1");
        manejoDropDown.selectByVisibleText("Option 1");
        manejoDropDown.selectByVisibleText("Option 2");
        //manejoDropDown.deselectAll();

    }

    @Test
    public void menuUi(){
        driver.get("");
    }

    @Test
    public void sarasa(){

    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}
