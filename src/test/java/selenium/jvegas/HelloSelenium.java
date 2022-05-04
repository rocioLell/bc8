package selenium.jvegas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
    public static void main(String[] args) {

        // inicializamos webdrivermanager con setup base y creamos el webdriver que aceptara el chromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //funciones configuracion -> funciones internas
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //funciones de navegacion -> funciones externas
        driver.get("https://www.google.com");
        String tituloPagina = driver.getTitle();
        //Assert.assertEquals("google", tituloPagina);

        //escribir en el tag input con nombre q
        WebElement barraBusquedaGoogle = driver.findElement(By.name("q"));
        barraBusquedaGoogle.sendKeys("TSOFT");
        barraBusquedaGoogle.submit();

        WebElement linkSitioTsoft = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        linkSitioTsoft.click();
        String tituloPaginaTsoft = driver.getTitle();
        System.out.println(tituloPaginaTsoft);

        driver.close();
    }
}
