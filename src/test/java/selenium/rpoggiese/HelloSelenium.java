package selenium.rpoggiese;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import java.util.concurrent.TimeUnit;


public class HelloSelenium {

    public static void main(String[] args) {

        //Inicializaremos webdrivermanager con setup base
        // y creamos el webDriver que aceptara el ChromeDriver

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //funciones configuracion -> funciones internas
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //funciones de navegacion -> funciones externas
        // operar con el driver

        driver.get("https://www.google.com");
        String tituloPagina = driver.getTitle(); //Google
        System.out.println(tituloPagina);
        driver.close();

        //escribir el el tag input con nombre q

        WebElement barraTextoGoogle = driver.findElement(By.name("q"));
        barraTextoGoogle.sendKeys("TSOFT");
        barraTextoGoogle.submit();

        WebElement linkSitioTsoft = driver.findElement(By.xpath("//*[@id=\"rso\"]div[1]/div/div/div/div"));
        linkSitioTsoft.click();
        String tituloPaginaTsoft = driver.getTitle();
        System.out.println(tituloPaginaTsoft);
        driver.close();

    }
}
