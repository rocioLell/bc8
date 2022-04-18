package selenium.igarate;

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

import java.awt.*;
import java.util.List;

public class ManejoDeElementosWeb {

    public static WebDriver driver;
    public By localizadorDropdown = By.xpath("//select[@id=\"dropdown\"]");
    public By localizadorBtnEnabled = By.xpath("//a[text()=\"Enabled\"]");
    public By localizadorBtnDownloads = By.id("ui-id-4");
    public By getLocalizadorBtnPdf = By.xpath("//a[@href=\"/download/jqueryui/menu/menu.pdf\"]");
    public By localizadoresCheckBoxes = By.xpath("//from[@id=\"checkboxes\"]");

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

    @Test
    public void dropdown(){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(localizadorDropdown);

        Select manejoDropdown = new Select (dropdown);

        manejoDropdown.selectByValue("1");
        manejoDropdown.selectByValue("2");
        manejoDropdown.selectByVisibleText("Option 1");
        manejoDropdown.selectByVisibleText("Option 2");
    }

    @Test
    public void menuUi() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
        WebElement elementEnabled = driver.findElement(localizadorBtnEnabled);
        elementEnabled.click();
        Thread.sleep(1000);
        WebElement elementDownload = driver.findElement(localizadorBtnDownloads);
        Thread.sleep(1000);
        elementDownload.click();
        Thread.sleep(1000);
        WebElement elementPdf = driver.findElement(getLocalizadorBtnPdf);
        elementPdf.click();
    }

    @Test
    public void checkBox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(localizadoresCheckBoxes);
        for (WebElement chk:checkboxes) {
            chk.click();
        }
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}
