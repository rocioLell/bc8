package pom.equipo1.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class JunitBaseTest {
    /*aca trabajaremos todos los setup de configuracion inicial de los test a ejecutar*/
    public WebDriver driver;
    @BeforeClass
    public static void initTesting(){
        WebDriverManager.edgedriver().setup();
    }

    @Before
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


}
