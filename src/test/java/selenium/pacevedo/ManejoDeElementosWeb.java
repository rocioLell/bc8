package selenium.pacevedo;

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
    public By localizadorDeIframe= By.tagName("iframe");
    public By localizadorEditorTexto= By.id("tinymce");
    public By localizadorWebTables= By.tagName("table");



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
        List<WebElement> iframe= driver.findElements(localizadorDeIframe);

        //cambiampos de Frame
        driver.switchTo().frame(iframe.get(0));
        WebElement editorTexto= driver.findElement(localizadorEditorTexto);
        editorTexto.clear();
        editorTexto.sendKeys("Hola estamos aprendiendo Selenium");


    }
  @Test
    public void webTables() {
      driver.get("https://the-internet.herokuapp.com/tables");

      // Lista de webTables en pagina
      List<WebElement> webTables = driver.findElements(localizadorWebTables);

      //Cauntas  Columnas Hay

      List<WebElement> columnas = webTables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));
      int tamanioColumnas = columnas.size();
      //2 click para Ordenar de mayor Deuda
      if (columnas.get(3).getText().contains("Due")) {
          columnas.get(3).click();
          columnas.get(3).click();
      }
      //Obtener los Datos de la primera fila
      List<WebElement> filas = webTables.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
      int tamanioFila = filas.size();
      //trabajar en la primera fila
      String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
      String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
      String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();

      System.out.println("el usuario con mayor deuda de la tabla 1 es" + nombre + " " + apellido + ", y su deuda alcanza los " + deuda);


  }
        //ejercicio tabla 2: ordenar por Nombre y entregar datos de deuda de todos los usuarios

      @Test
      public void webTables2(){
          driver.get("https://the-internet.herokuapp.com/tables");


          List<WebElement> webTables= driver.findElements(localizadorWebTables);
          List<WebElement> columnas= webTables.get(1).findElement(By.tagName("thead")).findElements(By.tagName("th"));

          if(columnas.get(1).getText().contains("First Name")) {
              columnas.get(1).click();
          }

          List<WebElement> filas = webTables.get(1).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
          String usuario1 = filas.get(0).findElement(By.xpath("td[4]")).getText();
          String nombre1 = filas.get(0).findElement(By.xpath("td[2]")).getText();
         String usuario2 = filas.get(1).findElement(By.xpath("td[4]")).getText();
         String nombre2 = filas.get(1).findElement(By.xpath("td[2]")).getText();
         String usuario3 = filas.get(2).findElement(By.xpath("td[4]")).getText();
         String nombre3 = filas.get(2).findElement(By.xpath("td[2]")).getText();
         String usuario4 = filas.get(3).findElement(By.xpath("td[4]")).getText();
         String nombre4 = filas.get(3).findElement(By.xpath("td[2]")).getText();


          System.out.println("el usuario " + " "+ nombre1 +" "+ "tiene una deuda de" +" "+ usuario1 );
          System.out.println("el usuario " + " "+ nombre2 +" "+ "tiene una deuda de" +" "+ usuario2 );
          System.out.println("el usuario " + " "+ nombre3 +" "+ "tiene una deuda de" +" "+ usuario3 );
          System.out.println("el usuario " + " "+ nombre4 +" "+ "tiene una deuda de" +" "+ usuario4 );


      }

    }




    /**@After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }*/

