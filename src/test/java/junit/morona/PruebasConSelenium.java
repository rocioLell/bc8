package junit.morona;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebasConSelenium {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.mercadolibre.com.ar/");

        WebElement barraBusquedaMercadoLibre = driver.findElement(By.cssSelector("#cb1-edit"));
        barraBusquedaMercadoLibre.sendKeys("Esto es una prueba");


    }
}
