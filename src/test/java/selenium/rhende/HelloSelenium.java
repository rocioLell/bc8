package selenium.rhende;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HelloSelenium {

    public static void main(String[] args) {
        //inicializamos webDriverManager con setup y creamos webDriver que aceptara el ChromeDriver

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // funciones configiracion -> funciones internas

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //funciones de navegación  -> funciones externas

        driver.get("https://google.com");
        String tituloPagina = driver.getTitle();
        //Escribir en el TAG input con nombre q
        WebElement barraTextoGoogle = driver.findElement(By.name("q"));
        barraTextoGoogle.sendKeys("TSOFT");
        barraTextoGoogle.submit();

        WebElement linkSitioTsoft = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        linkSitioTsoft.click();
        String tituloPaginaTsoft = driver.getTitle();
        System.out.println("tituloPaginaTsoft = " + tituloPaginaTsoft);
        driver.close();
    }
}
