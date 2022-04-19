package selenium.Ecorrea;

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
    //atributo

    public static WebDriver driver;
    public By localizadorDropdown = By.xpath("//select[@id=\"dropdown\"]");
    public By localizadorBtnEnable = By.xpath("//a[text()=\"Enabled\"]");
    public By localizadorBtnPDF = By.id("ui-id-4");
    public By localizadorBtnDownload = By.xpath("//a[@href=\"/download/jqueryui/menu/menu.pdf\"]");
    public By localizadoresCheckBoxes = By.xpath("//form[@id=\"checkboxes\"]//input");
    public By localizadordeIframe = By.tagName("iframe");
    public By localizadorDeEditorTexto = By.id("tinymce");
    public By localizadorDeWebTablas = By.id("table1");
    @BeforeClass
    public static void init(){WebDriverManager.chromedriver().setup();}

    @Before
    public void setUp(){
        //preparacion de Driver = Manager
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }
    @Test
    public void dropdown(){//seleccionar datos de barra esapaciadora

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement WebElementdropdown = driver.findElement(localizadorDropdown);
        Select manejoDropDown = new Select(WebElementdropdown);

        manejoDropDown.selectByValue("1");
        manejoDropDown.selectByValue("2");
        manejoDropDown.selectByVisibleText("option 1");
        manejoDropDown.selectByVisibleText("option 2");
        manejoDropDown.deselectAll();
    }
    @Test
    public void menuUI() throws InterruptedException{//localizador de distintos botones
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
        WebElement elementEnable = driver.findElement(localizadorBtnEnable);
        elementEnable.click();
        Thread.sleep(1000);
        WebElement elementDownload = driver.findElement(localizadorBtnDownload);
        elementDownload.click();
        Thread.sleep(1000);
        WebElement elementoPDF = driver.findElement(localizadorBtnPDF);
        elementoPDF.click();

    }
    @Test
    public  void checkBox() throws InterruptedException{//selector de multiples opciones
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(localizadoresCheckBoxes);
        for (WebElement chk:checkboxes){

            chk.click();
            Thread.sleep(1000);

        }

    }
    @Test
            public void iframes () { //traer elemntos DOM de otra pagina html
        driver.get("https://the-internet.herokuapp.com/tinymce");
        List<WebElement> iframes =driver.findElements(localizadordeIframe);
        driver.switchTo().frame(iframes.get(0));
        WebElement editorTexto = driver.findElement(localizadorDeEditorTexto);
        editorTexto.clear();
        editorTexto.sendKeys("hola, aprendiendo selenium");
    }
    @Test
    public void webTables(){//tablas webs
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> webTable = driver.findElements(localizadorDeWebTablas);
        //cuantas columnas tiene la primera tabla
        List<WebElement> columnas = webTable.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));//encabezado de la tabla
         int tamanioColumna = columnas.size();
         //obtener los click para ordenar la webtable
         if (columnas.get(3).getText().contains("Due")){
             columnas.get(3).click();
              columnas.get(3).click();


         }
         //obtener las filas de webTable
         List<WebElement> filas = webTable.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
         int tamaniofilas = filas.size();
         String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();

        System.out.println("el usuario con mayor deuda es"+nombre+""+apellido+"y su deuda es de"+deuda+"dolares");

    }
    //Tarea tabla clase 19 de abril
    @Test
    public void webTablesejemplo2(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> webTable = driver.findElements(localizadorDeWebTablas);
        List<WebElement> columnas = webTable.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));

        //un click para ordenar nombre alfabeticamente
        if (columnas.get(0).getText().contains("Last Name")){
            columnas.get(0).click();

        }
        List<WebElement> filas = webTable.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        String nombre1 = filas.get(0).findElement(By.xpath("td[1]")).getText();
        String nombre2 = filas.get(1).findElement(By.xpath("td[1]")).getText();
        String nombre3 = filas.get(2).findElement(By.xpath("td[1]")).getText();
        String nombre4 = filas.get(3).findElement(By.xpath("td[1]")).getText();
        System.out.println("nombres ordenados alfabeticamente "+nombre1+" - "+nombre2+" - "+nombre3+" - "+nombre4);
    }
    @After
    public void close(){

        if(driver != null){
            driver.close();
        }



    }

}
