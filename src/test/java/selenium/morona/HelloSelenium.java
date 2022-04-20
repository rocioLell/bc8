package selenium.morona;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert.*;

public class HelloSelenium {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.google.com.ar/");
        String titulo = driver.getTitle();
        System.out.println(titulo);

        WebElement barraTextoGoogle = driver.findElement(By.name("q"));
        barraTextoGoogle.sendKeys("TSOFT");
        barraTextoGoogle.submit();

        WebElement linkSitioTsoft = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        linkSitioTsoft.click();
        String tituloTsoft = driver.getTitle();
        System.out.println(tituloTsoft);

        driver.close();

    }
}
