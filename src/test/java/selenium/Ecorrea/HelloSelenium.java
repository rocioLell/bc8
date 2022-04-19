package selenium.Ecorrea;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium {
    public static void main(String[]args){
        //inicializamos webdriver manager con setup y creamos el webDriver que aceptara el ChromeDrver
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();

        //funciones configuracion (funciones internas)
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //funciones de navegacion  (funciones externas)
        driver.get("https://www.google.com");
        String tituloPagina = driver.getTitle(); //"Google"
        Assert.assertEquals("Google",tituloPagina);

       WebElement barraTextoGoogle = driver.findElement(By.name("q"));
       barraTextoGoogle.sendKeys("TSOFT");
       barraTextoGoogle.submit();
        WebElement linkSitioTsoft = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"));
        linkSitioTsoft.click();
       String tituloPaginaTsoft = driver.getTitle();
       System.out.println(tituloPaginaTsoft);
    }
}
