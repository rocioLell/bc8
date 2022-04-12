package selenium.poggioem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class HelloSelenium {
    public static void main(String[] args) {

        //Inicializamos el webdriver manager con setup base y
        //creamos el webDriver qeu aceptara el ChromeDriver.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Funciones de configuracion o internas.
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Funciones de navegacion o externas, que me ayudan a manejar la pagina
        driver.get("https://www.google.com/");
        String pageTitle = driver.getTitle(); // "Google"
        //Escribir en el tag input con nombre q
        WebElement barraTextoGoogle = driver.findElement(By.name("q"));
        barraTextoGoogle.sendKeys("TSOFT");
        barraTextoGoogle.submit(); //enter

        WebElement linkToTSoft = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        linkToTSoft.click();
        String titleTSoft = driver.getTitle();
        System.out.println(titleTSoft);
        driver.close();
    }
}
