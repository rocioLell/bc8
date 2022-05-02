package selenium.poggioem;
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

    public static WebDriver driver;
    public By localizadorDropDown = By.xpath("//select[@id=\"dropdown\"]");
    public By localizadorButtonInable = By.xpath("//a[text()=\"Enabled\"]");
    public By localizadorButtonDownload = By.id("ui-id-4");
    public By localizadorButtonPDF = By.xpath("//a[text()=\"PDF\"]");
    public By localizadorCheckBoxes = By.xpath("//form[@id=\"checkboxes\"]//input");
    public By localizadorIFrames = By.tagName("iframe");
    public By localizadordeEditorTxt = By.id("tinymce");
    public By localizadorWebTables = By.tagName("table");


    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){ //preparacio driver = navegador
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void dropDown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement Elementdropdown = driver.findElement(localizadorDropDown);

        //Libreria selenium > webElement > Select.
        Select manejoDropDown = new Select (Elementdropdown);

        //ahora podemos operar el select o dropdown
        manejoDropDown.selectByValue("1");
        manejoDropDown.selectByValue("2");
        manejoDropDown.selectByVisibleText("Option 1");
        manejoDropDown.selectByVisibleText("Option 2");
    }

    @Test
    public void menuUI() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
        WebElement elementEnable = driver.findElement(localizadorButtonInable);
        elementEnable.click();
        Thread.sleep(1000); //mala practica, solo para ver el flujo y luego refactorizar
        WebElement elementDownload = driver.findElement(localizadorButtonDownload);
        elementDownload.click();
        Thread.sleep(1000);
        WebElement elementPDF = driver.findElement(localizadorButtonPDF);
        elementPDF.click();
        Thread.sleep(1000);
    }

    @Test
    public void checkBoxes() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(localizadorCheckBoxes);
        for (WebElement chk:checkboxes) {
            chk.click();
            Thread.sleep(1000);
        }
    }

    @Test
    public void iFrames(){
        driver.get("https://the-internet.herokuapp.com/tinymce");
        List<WebElement> iFrames = driver.findElements(localizadorIFrames); //detectamos el o los iframe
        //nos cambiamos de frame
        driver.switchTo().frame(iFrames.get(0)); //lo sacamos de IFrames y lo ponemos en la primer posicion de la lista
        //Aca vemos que al cambiar de frame, ya podemos acceder a localizadordeEditorTxt
        WebElement editorTexto = driver.findElement(localizadordeEditorTxt);
        editorTexto.clear();
        editorTexto.sendKeys("Hola mundo, aca con Selenium");

    }

    @Test
    public void webTables(){
        driver.get("https://the-internet.herokuapp.com/tables");
        //Vamos a ordenar por deuda de menor a mayor y entregar el nombre del mayor deudor.
        //Traemos la lista de webtables de la pagina.
        List<WebElement> tables = driver.findElements(localizadorWebTables);
        //Encontrar la cantidad columnas de la tabla.
        List <WebElement> columnas = tables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th")); //busqueda dentro de una busqueda
        if(columnas.get(3).getText().contains("Due")){
            columnas.get(3).click();
            columnas.get(3).click();    //dos click para ordenar de mayor a menor la webtable
        }
        // Obtenemos las filas de la webtable
        List<WebElement> filas = tables.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        //Ahora que tenemos la primera fila, vamos a obtenner nombre, apellido y deuda.
        String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText(); //aca el valor inicial es 1, no 0.
        String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();

        System.out.println("El usuario con mayor deuda es: " + nombre + apellido + " y su deuda es de: $" + deuda + "USD");
    }
        @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}
