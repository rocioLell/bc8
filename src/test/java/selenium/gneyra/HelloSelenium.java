package selenium.gneyra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HelloSelenium {
    public static void main(String[] args){
        //inicializamos webdrivermanager con setup base y creamos el webDriver que aceptara el FirefoxDriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //funciones de configuracion --> funciones internas
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //operar con el driver --> funciones externas

        driver.get("https://www.google.com");
        //driver.getTitle();
        String tituloPagina = driver.getTitle(); //"Google"
        //Assert.assertEquals("Google",tituloPagina);
        //escribir el tag input con nombre q
        WebElement barraTextoGoogle = driver.findElement(By.name("q"));
        barraTextoGoogle.sendKeys("TSOFT");
        barraTextoGoogle.submit();

        WebElement linkSitioTsoft = driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        linkSitioTsoft.click();
        String tituloPaginaTsoft = driver.getTitle(); //"Google"
        System.out.println(tituloPaginaTsoft);
    }
}
