package pom.earaya.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class CucumberBaseTest {
    /*aca trabajaremos todos los setup de configuracion inicial de los test a ejecutar*/
    private static WebDriver driver;
    @Before(order = 1)
    public static void initTesting(){
        WebDriverManager.edgedriver().setup();
    }

    @Before(order = 2)
    public void setUp(){
        System.out.println("before");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void close(){
        System.out.println("after");
        if(driver != null){
            driver.close();
        }
    }

    //funcion obtener el driver
    public static WebDriver getDriver(){
        return driver;
    }


}
