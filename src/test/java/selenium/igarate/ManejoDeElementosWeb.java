package selenium.igarate;

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
    public By localizadorDropdown = By.xpath("//select[@id=\"dropdown\"]");
    public By localizadorBtnEnabled = By.xpath("//a[text()=\"Enabled\"]");
    public By localizadorBtnDownloads = By.id("ui-id-4");
    public By getLocalizadorBtnPdf = By.xpath("//a[@href=\"/download/jqueryui/menu/menu.pdf\"]");
    public By localizadoresCheckBoxes = By.xpath("//form[@id=\"checkboxes\"]//input");
    public By localizadorIframes = By.tagName("iframe");
    public By localizadorEditorTexto = By.id("tinymce");
    public By localizadorWebTables = By.tagName("table");


    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setUp(){
        //preparar el driver
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdown(){

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(localizadorDropdown);

        Select manejoDropdown = new Select (dropdown);

        manejoDropdown.selectByValue("1");
        manejoDropdown.selectByValue("2");
        manejoDropdown.selectByVisibleText("Option 1");
        manejoDropdown.selectByVisibleText("Option 2");
    }

    @Test
    public void menuUi() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/jqueryui/menu#");
        WebElement elementEnabled = driver.findElement(localizadorBtnEnabled);
        elementEnabled.click();
        Thread.sleep(1000);
        WebElement elementDownload = driver.findElement(localizadorBtnDownloads);
        Thread.sleep(1000);
        elementDownload.click();
        Thread.sleep(1000);
        WebElement elementPdf = driver.findElement(getLocalizadorBtnPdf);
        elementPdf.click();
    }

    @Test
    public void checkBox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(localizadoresCheckBoxes);
        for (WebElement chk:checkboxes) {
            chk.click();
        }
    }

    @Test
    public void iframes(){
        driver.get("https://the-internet.herokuapp.com/tinymce");
        List<WebElement> iframes = driver.findElements(localizadorIframes);
        //cambiar de frame
        driver.switchTo().frame(iframes.get(0));
        WebElement editorTexto = driver.findElement(localizadorEditorTexto);
        editorTexto.clear();
        editorTexto.sendKeys("Hola mundo");
    }

    @Test
    public void webTable(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List <WebElement> webTables = driver.findElements(localizadorWebTables);
        //cuantas columnas tiene la tabla 1
        List<WebElement> columns = webTables.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));

        // 2 clicks para ordenar por mayor deuda
        if(columns.get(3).getText().equals("Due")){
            columns.get(3).click();
            columns.get(3).click();
        }
        // obtener los datos de la primera fila ordenada
        List <WebElement> rows = webTables.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        String name = rows.get(0).findElements(By.tagName("td")).get(1).getText();
        String lastname = rows.get(0).findElements(By.tagName("td")).get(0).getText();
        String due = rows.get(0).findElements(By.tagName("td")).get(2).getText();
        System.out.println("La deuda mayor es de Nombre: " + name + " Apellido: " + lastname+ " Deuda: " + due);
    }

    @Test
    public void webTable2(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List <WebElement> webTables = driver.findElements(localizadorWebTables);
        //cuantas columnas tiene la tabla 2
        List<WebElement> columns = webTables.get(1).findElement(By.tagName("thead")).findElements(By.tagName("th"));

        // 2 clicks para ordenar por mayor deuda
        if(columns.get(1).getText().equals("First Name")){
            columns.get(1).click();
        }
        List <WebElement> rows = webTables.get(1).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        String name1= rows.get(0).findElements(By.tagName("td")).get(1).getText();
        String name2= rows.get(1).findElements(By.tagName("td")).get(1).getText();
        String name3= rows.get(2).findElements(By.tagName("td")).get(1).getText();
        String name4= rows.get(3).findElements(By.tagName("td")).get(1).getText();
        System.out.println("Los nombres de los deudores ordenado alfabeticamente es : " + name1 + " " + name2 + " " + name3 + " " + name4);

    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}
