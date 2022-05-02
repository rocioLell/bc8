package selenium.morona;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManejoDeElementosWeb {

    //atributos
    public static WebDriver driver;
    public By localizadorDropdown = By.xpath("//select[@id=\"dropdown\"]");
    public By localizadorBtnEnabled = By.xpath("//a[text()=\"Enabled\"]");
    public By localizadorBtnDownload = By.id("ui-id-4");
    public By localizadorBtnPDF = By.xpath("//a[@href=\"/download/jqueryui/menu/menu.pdf\"]");
    public By localizadoresCheckBoxes = By.xpath("//form[@id=\"checkboxes\"]//input");
    public By localizadorIframes = By.tagName("iframe");
    public By localizadorDeEditorTexto= By.id("tinymce");
    public By localizadorDeWebTable= By.tagName("table");



    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        //preparacion de Driver = Navegador
        driver = new ChromeDriver(); //Chrome -> navegador
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement WebElementDropdown = driver.findElement(localizadorDropdown);

        //libreria Selenium -> webElement -> Select
        Select manejoDropDown = new Select(WebElementDropdown);

        //operar el select o dropdown
        manejoDropDown.selectByValue("1");
        manejoDropDown.selectByValue("2");
        manejoDropDown.selectByVisibleText("Option 1");
        manejoDropDown.selectByVisibleText("Option 2");

    }

    @Test
    public void menuUi() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
        WebElement elementEnabled = driver.findElement(localizadorBtnEnabled);
        elementEnabled.click();
        Thread.sleep(1000);
        WebElement elementDownloads = driver.findElement(localizadorBtnDownload);
        elementDownloads.click();
        Thread.sleep(1000);
        WebElement elementPDF = driver.findElement(localizadorBtnPDF);
        elementPDF.click();
    }

    @Test
    public void checkbox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(localizadoresCheckBoxes);
        for (WebElement chk:checkboxes) {
            chk.click();
            Thread.sleep(1000);
        }

    }
    @Test
    public void iframes(){
        driver.get("https://the-internet.herokuapp.com/tinymce");
        List<WebElement> iframes = driver.findElements(localizadorIframes);
        //cambiamos el driver

        driver.switchTo().frame(iframes.get(0));
        WebElement editorTexto= driver.findElement(localizadorDeEditorTexto);
        editorTexto.clear();
        editorTexto.sendKeys("Hola estamos aprendiendo selenium");
    }
    @Test
    public void tablasWeb() {
        driver.get("https://the-internet.herokuapp.com/tables");


        //lista de tablas web
        List<WebElement> webTables = driver.findElements(localizadorDeWebTable);

        //cuantas  columnas tiene la tabla 1?
        List<WebElement> columnas = webTables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));
        int tamanioDeColumnas = columnas.size();


        //2 clicks para ordenar por mayor deuda
        if(columnas.get(3).getText().contains("Due")){
            columnas.get(3).click();
            columnas.get(3).click();
        }
        //obtener datos de las filas
        List<WebElement> filas = webTables.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        int tamaniofilas = filas.size();

        //trabajamos en la fila
        String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();

        System.out.println("El usuario con mayor deuda es "+ nombre+" "+apellido+", y su deuda es de "+deuda+" dolares");

    }
    //Ejercicio 2 ordenar la tabla por Nombres
    @Test
    public void tablasWeb2() {
        driver.get("https://the-internet.herokuapp.com/tables");


        //lista de tablas web
        List<WebElement> webTables = driver.findElements(localizadorDeWebTable);

        //cuantas  columnas tiene la tabla 2?
        List<WebElement> columnas = webTables.get(1).findElement(By.tagName("thead")).findElements(By.tagName("th"));
        int tamanioDeColumnas = columnas.size();

        if(columnas.get(1).getText().contains("First Name")){
            columnas.get(1).click();
        }
        List<WebElement> filas = webTables.get(1).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        int tamaniofilas = filas.size();

        for (int i = 0; i <tamaniofilas ; i++) {
            String nombre = filas.get(i).findElement(By.xpath("td[2]")).getText();
            String apellido= filas.get(i).findElement(By.xpath("td[1]")).getText();
            System.out.println(nombre+" "+apellido);
        }

        /*String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        System.out.println(nombre);
        String nombre2 = filas.get(1).findElement(By.xpath("td[2]")).getText();
        System.out.println(nombre2);
        String nombre3 = filas.get(2).findElement(By.xpath("td[2]")).getText();
        System.out.println(nombre3);
        String nombre4 = filas.get(3).findElement(By.xpath("td[2]")).getText();
        System.out.println(nombre4);*/




    }



   /* @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }*/

}
