package selenium.rhende.equipo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;



public class vuelos {
    public static WebDriver driver;
    public By localizadorOrigin = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-roundtrip-origin-input\" )]");
    public By localizadorDestination= By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-roundtrip-destination-input\" )]");
    public By localizadorDateStart = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-start-date-input\" )]");
    public By localizadorAutocomplete = By.xpath("//li[@class=\"item -active\"]");
    public By localizadorBtnNextDate = By.xpath("//div[@class = \"_dpmg2--controls-next\"]/descendant::i");
    public By localizadorMonthActive = By.xpath("//div[contains(@class, \"_dpmg2--month-active\")]");
    public By localizadorBtnAplicarDate = By.xpath("//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
    public By localizadorPasajeros = By.xpath("(//div[contains(@class, \"sbox-passengers-container\")])[1]");
    public By localizadorAumentarAdultos = By.xpath("(//a[@class = \"steppers-icon-right sbox-3-icon-plus\"])[11]");
    public By localizadorAumentarNinos = By.xpath("(//a[@class = \"steppers-icon-right sbox-3-icon-plus\"])[12]");
    public By localizadorBtnAplicarPasajeros = By.xpath("(//a[text() =\"Aplicar\"])[3]");
    public By localizadorBtnBuscar = By.xpath("(//div [@class = \"sbox-button-container\"] )[1]");
    public By localizadorBtnCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    public By localizadorVolverAPaginaAnterior = By.xpath("//a[@class=\"breadcrumb-text eva-3-link\"]");
    public By localizadorClase = By.xpath("(//select[@class=\"select-tag\"])[43]");
    public By localizadorEquipajeMano = By.xpath("(//i[@class=\"checkbox-check eva-3-icon-checkmark filters-checkbox-left\"])[5]");
    public By localizadorUsd = By.xpath("(//i[@class=\"radio-circle\"])[2]");
    public By localizadorComprarPrimero = By.xpath("(//em[text() =\"Comprar\"])[1]");
    public By localizadorMetodosPago = By.xpath("//div[@class=\"eva-3-card -eva-3-shadow-line frame payment-method\"]/descendant::span[@class=\"payment-method-aligned\"]");

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test public void VTC01(){
        int mesViajeIda = 5;
        int mesViajeVuelta = 5;
        int diaViajeIda = 1;
        int diaViajeVuelta = 5;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String origen = "Buenos Aires, Ciudad de Buenos Aires, Argentina";
        String destino = "Santiago de Chile, Santiago, Chile";
        //Abrir la pagina
        driver.get("https://www.viajesfalabella.cl/vuelos");
        WebElement cookie = driver.findElement(localizadorBtnCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebElement origin = driver.findElement(localizadorOrigin);
        origin.sendKeys(origen);
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(5));
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        WebElement autocomplete = driver.findElement(localizadorAutocomplete);
        autocomplete.click();
        WebElement destination = driver.findElement(localizadorDestination);
        destination.sendKeys(destino);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        autocomplete.click();
        WebElement dateStart = driver.findElement(localizadorDateStart);
        dateStart.click();
        WebElement btnNextDate = driver.findElement(localizadorBtnNextDate);
        WebElement mesActual = driver.findElement(localizadorMonthActive);
        String monthInit = mesActual.getAttribute("data-month").split("-")[1];
        String yearInit = mesActual.getAttribute("data-month").split("-")[0];
        if (Integer.parseInt(yearInit) == añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i <= mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                btnNextDate.click();
            }
        }
        else if (Integer.parseInt(yearInit) < añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i < 12 + mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                btnNextDate.click();
            }
        }
        String dayDataIda = mesViajeIda > 9 ? añoViajeIda + "-"+ mesViajeIda : añoViajeIda+"-"+"0"+mesViajeIda;
        By localizadorDay = By.xpath("//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::span[text()=\""+diaViajeIda+"\"]");
        WebElement day = driver.findElement(localizadorDay);
        day.click();
        WebElement mesActualVuelta = driver.findElement(localizadorMonthActive);
        String monthInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[1];
        String yearInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[0];
        if (mesViajeIda<=mesViajeVuelta || añoViajeIda<=añoViajeVuelta){
            if (Integer.parseInt(yearInitVuelta) == añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i <= mesViajeVuelta  ; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate.click();
                }
            }
            else if (Integer.parseInt(yearInitVuelta) < añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i < 12 + mesViajeVuelta; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate.click();
                }
            }
        }
        String dayDataVuelta = mesViajeVuelta > 9 ? añoViajeVuelta + "-"+ mesViajeVuelta : añoViajeVuelta+"-"+"0"+mesViajeVuelta;
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarDate);
        aplicar.click();
        WebElement pasajeros = driver.findElement(localizadorPasajeros);
        pasajeros.click();
        WebElement adultos = driver.findElement(localizadorAumentarAdultos);
        adultos.click();
        WebElement aplicarPasajeros = driver.findElement(localizadorBtnAplicarPasajeros);
        aplicarPasajeros.click();
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
    }

    @Test public void  TC07(){

        int mesViajeIda = 5;
        int mesViajeVuelta = 6;
        int diaViajeIda = 27;
        int diaViajeVuelta = 22;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String origen = "Buenos Aires, Ciudad de Buenos Aires, Argentina";
        String destino = "París, Ile de France, Francia";

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(1000))
                .withMessage("Error de timeout BC(")
                .ignoring(NoSuchElementException.class);


        //Abrir la pagina
        driver.get("https://www.viajesfalabella.cl/vuelos");
        WebElement cookie = driver.findElement(localizadorBtnCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebElement origin = driver.findElement(localizadorOrigin);
        origin.sendKeys(origen);
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(7));
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        WebElement autocomplete = driver.findElement(localizadorAutocomplete);
        autocomplete.click();
        WebElement destination = driver.findElement(localizadorDestination);
        destination.sendKeys(destino);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        autocomplete.click();
        WebElement dateStart = driver.findElement(localizadorDateStart);
        dateStart.click();
        WebElement btnNextDate = driver.findElement(localizadorBtnNextDate);
        WebElement mesActual = driver.findElement(localizadorMonthActive);
        String monthInit = mesActual.getAttribute("data-month").split("-")[1];
        String yearInit = mesActual.getAttribute("data-month").split("-")[0];
        if (Integer.parseInt(yearInit) == añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i <= mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                btnNextDate.click();
            }
        }
        else if (Integer.parseInt(yearInit) < añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i < 12 + mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                btnNextDate.click();
            }
        }
        String dayDataIda = mesViajeIda > 9 ? añoViajeIda + "-"+ mesViajeIda : añoViajeIda+"-"+"0"+mesViajeIda;
        By localizadorDay = By.xpath("//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::span[text()=\""+diaViajeIda+"\"]");
        WebElement day = driver.findElement(localizadorDay);
        day.click();
        WebElement mesActualVuelta = driver.findElement(localizadorMonthActive);
        String monthInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[1];
        String yearInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[0];
        if (mesViajeIda<=mesViajeVuelta || añoViajeIda<=añoViajeVuelta){
            if (Integer.parseInt(yearInitVuelta) == añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i <= mesViajeVuelta  ; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate.click();
                }
            }
            else if (Integer.parseInt(yearInitVuelta) < añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i < 12 + mesViajeVuelta; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate.click();
                }
            }
        }
        String dayDataVuelta = mesViajeVuelta > 9 ? añoViajeVuelta + "-"+ mesViajeVuelta : añoViajeVuelta+"-"+"0"+mesViajeVuelta;
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarDate);
        aplicar.click();
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
        try {
            WebElement comprar = driver.findElement(localizadorComprarPrimero);
            wait.until(ExpectedConditions.elementToBeClickable(comprar));
            comprar.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement comprar = driver.findElement(localizadorComprarPrimero);
            wait.until(ExpectedConditions.elementToBeClickable(comprar));
            comprar.click();
        }
        WebElement volverPaginaAnterior = driver.findElement(localizadorVolverAPaginaAnterior);
        wait.until(ExpectedConditions.elementToBeClickable(volverPaginaAnterior));
        volverPaginaAnterior.click();
        driver.switchTo().alert().accept();


    }

    @Test public void TC11()  {
        int mesViajeIda = 8;
        int mesViajeVuelta = 8;
        int diaViajeIda = 2;
        int diaViajeVuelta = 8;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String origen = "Atenas, Attica, Grecia";
        String destino = "Barcelona, Cataluña, España";
        String metodoPago = "";
        //Abrir la pagina

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(1000))
                .withMessage("Error de timeout BC(")
                .ignoring(NoSuchElementException.class);

        driver.get("https://www.viajesfalabella.cl/vuelos");
        WebElement cookie = driver.findElement(localizadorBtnCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebElement origin = driver.findElement(localizadorOrigin);
        origin.sendKeys(origen);
        wait.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        WebElement autocomplete = driver.findElement(localizadorAutocomplete);
        autocomplete.click();
        WebElement destination = driver.findElement(localizadorDestination);
        destination.sendKeys(destino);
        wait.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        autocomplete.click();
        WebElement dateStart = driver.findElement(localizadorDateStart);
        dateStart.click();
        WebElement btnNextDate = driver.findElement(localizadorBtnNextDate);
        WebElement mesActual = driver.findElement(localizadorMonthActive);
        String monthInit = mesActual.getAttribute("data-month").split("-")[1];
        String yearInit = mesActual.getAttribute("data-month").split("-")[0];
        if (Integer.parseInt(yearInit) == añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i <= mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                btnNextDate.click();
            }
        }
        else if (Integer.parseInt(yearInit) < añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i < 12 + mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                btnNextDate.click();
            }
        }
        String dayDataIda = mesViajeIda > 9 ? añoViajeIda + "-"+ mesViajeIda : añoViajeIda+"-"+"0"+mesViajeIda;
        By localizadorDay = By.xpath("//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::span[text()=\""+diaViajeIda+"\"]");
        WebElement day = driver.findElement(localizadorDay);
        day.click();
        WebElement mesActualVuelta = driver.findElement(localizadorMonthActive);
        String monthInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[1];
        String yearInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[0];
        if (mesViajeIda<=mesViajeVuelta || añoViajeIda<=añoViajeVuelta){
            if (Integer.parseInt(yearInitVuelta) == añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i <= mesViajeVuelta  ; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate.click();
                }
            }
            else if (Integer.parseInt(yearInitVuelta) < añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i < 12 + mesViajeVuelta; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate.click();
                }
            }
        }
        String dayDataVuelta = mesViajeVuelta > 9 ? añoViajeVuelta + "-"+ mesViajeVuelta : añoViajeVuelta+"-"+"0"+mesViajeVuelta;
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarDate);
        aplicar.click();
        WebElement pasajeros = driver.findElement(localizadorPasajeros);
        pasajeros.click();
        WebElement adultos = driver.findElement(localizadorAumentarAdultos);
        wait.until(ExpectedConditions.elementToBeClickable(localizadorAumentarAdultos));
        adultos.click();
        WebElement ninos = driver.findElement(localizadorAumentarNinos);
        for (int i = 1; i < 4; i++) {
            ninos.click();
            WebElement edad = driver.findElement(By.xpath("(//select[@class=\"select-tag\"])[" + (35+i) + "]"));
            Select manejoEdad = new Select (edad);
            if (i == 1){
                manejoEdad.selectByValue("6");
            }
            if (i == 2){
                manejoEdad.selectByValue("8");
            }
            if (i == 3){
                manejoEdad.selectByValue("17");
            }

        }
        WebElement clase = driver.findElement(localizadorClase);
        Select manejoClase = new Select (clase);
        manejoClase.selectByValue("C");
        WebElement aplicarPasajeros = driver.findElement(localizadorBtnAplicarPasajeros);
        aplicarPasajeros.click();
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
        WebElement equipajeMano = driver.findElement(localizadorEquipajeMano);
        wait.until(ExpectedConditions.elementToBeClickable(equipajeMano));
        equipajeMano.click();
        try {
            WebElement usd = driver.findElement(localizadorUsd);
            wait.until(ExpectedConditions.elementToBeClickable(usd));
            usd.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement usd = driver.findElement(localizadorUsd);
            wait.until(ExpectedConditions.elementToBeClickable(usd));
            usd.click();
        }
        WebElement comprarPrimero = driver.findElement(localizadorComprarPrimero);
        comprarPrimero.click();
        List<WebElement> pagos = driver.findElements(localizadorMetodosPago);
        wait.until(ExpectedConditions.elementToBeClickable(pagos.get(0)));
        if (pagos.size() == 1){
            metodoPago = pagos.get(0).getText();
        }
        Assert.assertEquals(metodoPago, "Tarjeta de crédito");

    }

    @Test public void TC18()  {
        int mesViajeIda = 5;
        int mesViajeVuelta = 5 ;
        int diaViajeIda = 1;
        int diaViajeVuelta = 7;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String origen = "Buenos Aires, Ciudad de Buenos Aires, Argentina";
        String destino = "Florida";
        String metodoPago = "";
        //Abrir la pagina

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(1000))
                .withMessage("Error de timeout BC(")
                .ignoring(NoSuchElementException.class);

        driver.get("https://www.viajesfalabella.cl/vuelos");
        WebElement cookie = driver.findElement(localizadorBtnCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebElement origin = driver.findElement(localizadorOrigin);
        origin.sendKeys(origen);
        wait.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        WebElement autocomplete = driver.findElement(localizadorAutocomplete);
        autocomplete.click();
        WebElement destination = driver.findElement(localizadorDestination);
        destination.sendKeys(destino);
        wait.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        autocomplete.click();
        WebElement dateStart = driver.findElement(localizadorDateStart);
        dateStart.click();
        WebElement btnNextDate = driver.findElement(localizadorBtnNextDate);
        WebElement mesActual = driver.findElement(localizadorMonthActive);
        String monthInit = mesActual.getAttribute("data-month").split("-")[1];
        String yearInit = mesActual.getAttribute("data-month").split("-")[0];
        if (Integer.parseInt(yearInit) == añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i <= mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                btnNextDate.click();
            }
        }
        else if (Integer.parseInt(yearInit) < añoViajeIda){
            for (int i = Integer.parseInt(monthInit); i < 12 + mesViajeIda; i++) {
                if (i == mesViajeIda){
                    break;
                }
                btnNextDate.click();
            }
        }
        String dayDataIda = mesViajeIda > 9 ? añoViajeIda + "-"+ mesViajeIda : añoViajeIda+"-"+"0"+mesViajeIda;
        By localizadorDay = By.xpath("//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::span[text()=\""+diaViajeIda+"\"]");
        WebElement day = driver.findElement(localizadorDay);
        day.click();
        WebElement mesActualVuelta = driver.findElement(localizadorMonthActive);
        String monthInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[1];
        String yearInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[0];
        if (mesViajeIda<=mesViajeVuelta || añoViajeIda<=añoViajeVuelta){
            if (Integer.parseInt(yearInitVuelta) == añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i <= mesViajeVuelta  ; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate.click();
                }
            }
            else if (Integer.parseInt(yearInitVuelta) < añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i < 12 + mesViajeVuelta; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate.click();
                }
            }
        }
        String dayDataVuelta = mesViajeVuelta > 9 ? añoViajeVuelta + "-"+ mesViajeVuelta : añoViajeVuelta+"-"+"0"+mesViajeVuelta;
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarDate);
        aplicar.click();
        WebElement pasajeros = driver.findElement(localizadorPasajeros);
        pasajeros.click();
        WebElement adultos = driver.findElement(localizadorAumentarAdultos);
        wait.until(ExpectedConditions.elementToBeClickable(localizadorAumentarAdultos));
        adultos.click();
        WebElement ninos = driver.findElement(localizadorAumentarNinos);
        for (int i = 1; i < 4; i++) {
            ninos.click();
            WebElement edad = driver.findElement(By.xpath("(//select[@class=\"select-tag\"])[" + (35+i) + "]"));
            Select manejoEdad = new Select (edad);
            if (i == 1){
                manejoEdad.selectByValue("0");
            }
            if (i == 2){
                manejoEdad.selectByValue("11");
            }
            if (i == 3){
                manejoEdad.selectByValue("17");
            }

        }
        WebElement clase = driver.findElement(localizadorClase);
        Select manejoClase = new Select (clase);
        manejoClase.selectByValue("C");
        WebElement aplicarPasajeros = driver.findElement(localizadorBtnAplicarPasajeros);
        aplicarPasajeros.click();
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
        WebElement equipajeMano = driver.findElement(localizadorEquipajeMano);
        wait.until(ExpectedConditions.elementToBeClickable(equipajeMano));
        equipajeMano.click();
        try {
            WebElement usd = driver.findElement(localizadorUsd);
            wait.until(ExpectedConditions.elementToBeClickable(usd));
            usd.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement usd = driver.findElement(localizadorUsd);
            wait.until(ExpectedConditions.elementToBeClickable(usd));
            usd.click();
        }
        WebElement comprarPrimero = driver.findElement(localizadorComprarPrimero);
        comprarPrimero.click();
        List<WebElement> pagos = driver.findElements(localizadorMetodosPago);
        wait.until(ExpectedConditions.elementToBeClickable(pagos.get(0)));
        if (pagos.size() == 1){
            metodoPago = pagos.get(0).getText();
        }
        Assert.assertEquals(metodoPago, "Tarjeta de crédito");

    }



    @After
    public void close(){
        if(driver != null){
            driver.close();

        }
    }


}
