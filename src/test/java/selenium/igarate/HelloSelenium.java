package selenium.igarate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSelenium {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // operar con el driver

        driver.get("https://www.google.com"); // Google
        String tituloPagina = driver.getTitle();

        System.out.println(tituloPagina);

        // escribir en el tag input con nombre q
       WebElement barraTextoGoogle = driver.findElement(By.name("q"));
       barraTextoGoogle.sendKeys("Tsoft");
       barraTextoGoogle.submit();
       WebElement linkTsoft = driver.findElement(By.xpath("//h3[text()=\"HOME - TSOFT - Make IT Real\"]"));
       linkTsoft.click();
       String tituloPaginaTsoft = driver.getTitle();
        System.out.println(tituloPaginaTsoft);




    }
}
