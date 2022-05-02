package selenium.igarate.equipo1;

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


public class TestSuiteVuelosFalabella {
    public static WebDriver driver;
    public By localizadorOrigin = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-roundtrip-origin-input\" )]");
    public By localizadorDestination= By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-roundtrip-destination-input\" )]");
    public By localizadorOriginM1 = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-segment-1-origin-input\" )]");
    public By localizadorDestinationM1= By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-segment-1-destination-input\" )]");
    public By localizadorDestinationM2= By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-segment-2-destination-input\" )]");
    public By localizadorDateStart = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-start-date-input\" )]");
    public By localizadorDateStartM1 = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-segment-1-start-date-input\" )]");
    public By localizadorDateStartM2 = By.xpath("//input[contains(@class, \"sbox-bind-reference-flight-segment-2-start-date-input\" )]");
    public By localizadorAutocomplete = By.xpath("//li[@class=\"item -active\"]");
    public By localizadorAutocomplete2 = By.xpath("(//li[@class=\"item\"])[5]");
    public By localizadorBtnNextDate = By.xpath("//div[@class = \"_dpmg2--controls-next\"]/descendant::i");
    public By localizadorBtnNextDate2 = By.xpath("(//div[@class = \"_dpmg2--controls-next\"]/descendant::i)[3]");
    public By localizadorBtnNextDateM1 = By.xpath("(//div[@class = \"_dpmg2--controls-next\"]/descendant::i)[2]");
    public By localizadorBtnNextDateM2 = By.xpath("(//div[@class = \"_dpmg2--controls-next\"]/descendant::i)[1]");
    public By localizadorMonthActive = By.xpath("//div[contains(@class, \"_dpmg2--month-active\")]");
    public By localizadorMonthActive2 = By.xpath("(//div[contains(@class, \"_dpmg2--month-active\")])[3]");
    public By localizadorBtnAplicarDate = By.xpath("//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
    public By localizadorBtnAplicarDate2 = By.xpath("(//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"])[2]");
    public By localizadorBtnAplicarDateM = By.xpath("(//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"])[1]");
    public By localizadorPasajeros = By.xpath("(//div[contains(@class, \"sbox-passengers-container\")])[1]");
    public By localizadorPasajerosM = By.xpath("(//div[contains(@class, \"sbox-passengers-container\")])[2]");
    public By localizadorAumentarAdultos = By.xpath("(//a[@class = \"steppers-icon-right sbox-3-icon-plus\"])[11]");
    public By localizadorAumentarNinos = By.xpath("(//a[@class = \"steppers-icon-right sbox-3-icon-plus\"])[12]");
    public By localizadorBtnAplicarPasajeros = By.xpath("(//a[text() =\"Aplicar\"])[3]");
    public By localizadorBtnBuscar = By.xpath("(//div [@class = \"sbox-button-container\"] )[1]");
    public By localizadorBtnBuscarM = By.xpath("(//div [@class = \"sbox-button-container\"] )[2]");
    public By localizadorBtnCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    public By localizadorVolverAPaginaAnterior = By.xpath("//a[@class=\"breadcrumb-text eva-3-link\"]");
    public By localizadorClase = By.xpath("(//select[@class=\"select-tag\"])[43]");
    public By localizadorEquipajeMano = By.xpath("(//i[@class=\"checkbox-check eva-3-icon-checkmark filters-checkbox-left\"])[5]");
    public By localizadorEquipajeBodega = By.xpath("(//i[@class=\"checkbox-check eva-3-icon-checkmark filters-checkbox-left\"])[7]");
    public By localizadorUsd = By.xpath("(//i[@class=\"radio-circle\"])[2]");
    public By localizadorComprarPrimero = By.xpath("(//em[text() =\"Comprar\"])[1]");
    public By localizadorMetodosPago = By.xpath("//div[@class=\"eva-3-card -eva-3-shadow-line frame payment-method\"]/descendant::span[@class=\"payment-method-aligned\"]");
    public By localizadorNoVuelos = By.xpath("//h3[@class=\"eva-3-h3 title-description empty-state-message-title-secondary\"]");
    public By localizadorCheckNoDate = By.xpath("//input[@class=\"checkbox-tag sbox-bind-checked-no-specified-date\"]");
    public By localizadorMultidestino = By.xpath("(//i[@class=\"radio-circle sbox-radio-circle\"])[3]");
    public By localizadorAlianzas = By.xpath("//filter-group[@id=\"filter-alliances\"]");
    public By localizadorOneWorld = By.xpath("(//i[@class=\"checkbox-check eva-3-icon-checkmark filters-checkbox-left\"])[23]");
    public By localizadorDosEscalas = By.xpath("(//i[@class=\"checkbox-check eva-3-icon-checkmark filters-checkbox-left\"])[4]");
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
        String origen = "SCL";
        String destino = "BSB";
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

    @Test public void  VTC02(){

        int mesViajeIda = 5;
        int mesViajeVuelta = 3;
        int diaViajeIda = 2;
        int diaViajeVuelta = 25;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2023;
        String origen = "SCL";
        String destino = "BSB";

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

    @Test public void VTC03(){
        int mesViajeIda = 8;
        int mesViajeVuelta = 8;
        int diaViajeIda = 1;
        int diaViajeVuelta = 6;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String origen1 = "SCl";
        String destino1 = "MAD";
        String destino2 = "AMS";
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
        WebElement multidestino = driver.findElement(localizadorMultidestino);
        wait.until(ExpectedConditions.elementToBeClickable(multidestino));
        multidestino.click();
        WebElement originM1 = driver.findElement(localizadorOriginM1);
        originM1.sendKeys(origen1);
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(5));
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        WebElement autocomplete = driver.findElement(localizadorAutocomplete);
        autocomplete.click();
        WebElement destinationM1 = driver.findElement(localizadorDestinationM1);
        destinationM1.sendKeys(destino1);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        WebElement autocomplete2 = driver.findElement(localizadorAutocomplete2);
        autocomplete2.click();
        WebElement destinationM2 = driver.findElement(localizadorDestinationM2);
        destinationM2.sendKeys(destino2);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        autocomplete.click();
        WebElement dateStartM1 = driver.findElement(localizadorDateStartM1);
        dateStartM1.click();
        WebElement btnNextDate = driver.findElement(localizadorBtnNextDateM1);
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
        By localizadorDay = By.xpath("(//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::span[text()=\""+diaViajeIda+"\"])[2]");
        WebElement day = driver.findElement(localizadorDay);
        day.click();
        WebElement dateEndM1 = driver.findElement(localizadorBtnAplicarDateM);
        dateEndM1.click();
        WebElement dateStartM2 = driver.findElement(localizadorDateStartM2);
        dateStartM2.click();
        WebElement btnNextDate2 = driver.findElement(localizadorBtnNextDateM2);
        WebElement mesActualVuelta = driver.findElement(localizadorMonthActive);
        String monthInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[1];
        String yearInitVuelta = mesActualVuelta.getAttribute("data-month").split("-")[0];
        if (mesViajeIda<=mesViajeVuelta || añoViajeIda<=añoViajeVuelta){
            if (Integer.parseInt(yearInitVuelta) == añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i <= mesViajeVuelta  ; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate2.click();
                }
            }
            else if (Integer.parseInt(yearInitVuelta) < añoViajeVuelta){
                for (int i = Integer.parseInt(monthInitVuelta); i < 12 + mesViajeVuelta; i++) {
                    if (i == mesViajeVuelta){
                        break;
                    }
                    btnNextDate2.click();
                }
            }
        }
        String dayDataVuelta = mesViajeVuelta > 9 ? añoViajeVuelta + "-"+ mesViajeVuelta : añoViajeVuelta+"-"+"0"+mesViajeVuelta;
        By localizadorDayR = By.xpath("(//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"])[1]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement dateEndM2 = driver.findElement(localizadorBtnAplicarDateM);
        dateEndM2.click();
        WebElement pasajeros = driver.findElement(localizadorPasajerosM);
        pasajeros.click();
        WebElement adultos = driver.findElement(localizadorAumentarAdultos);
        adultos.click();
        WebElement aplicarPasajeros = driver.findElement(localizadorBtnAplicarPasajeros);
        aplicarPasajeros.click();
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscarM);
        btnBuscar.click();
        WebElement equipajeBodega = driver.findElement(localizadorEquipajeBodega);
        wait.until(ExpectedConditions.elementToBeClickable(equipajeBodega));
        equipajeBodega.click();
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
        try {
            WebElement alianzas = driver.findElement(localizadorAlianzas);
            wait.until(ExpectedConditions.elementToBeClickable(alianzas));
            alianzas.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement alianzas = driver.findElement(localizadorAlianzas);
            wait.until(ExpectedConditions.elementToBeClickable(alianzas));
            alianzas.click();
        }
        try {
            WebElement oneWolrd = driver.findElement(localizadorOneWorld);
            wait.until(ExpectedConditions.elementToBeClickable(oneWolrd));
            oneWolrd.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement oneWolrd = driver.findElement(localizadorOneWorld);
            wait.until(ExpectedConditions.elementToBeClickable(oneWolrd));
            oneWolrd.click();
        }
        try {
            WebElement dosEscalas = driver.findElement(localizadorDosEscalas);
            wait.until(ExpectedConditions.elementToBeClickable(dosEscalas));
            dosEscalas.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement dosEscalas = driver.findElement(localizadorDosEscalas);
            wait.until(ExpectedConditions.elementToBeClickable(dosEscalas));
            dosEscalas.click();
        }
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


    }

    @Test public void  VTC04() {

        int mesViajeIda = 8;
        int mesViajeVuelta = 8;
        int diaViajeIda = 1;
        int diaViajeVuelta = 6;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        int mesViajeIda2 = 7;
        int mesViajeVuelta2 = 7;
        int diaViajeIda2 = 1;
        int diaViajeVuelta2 = 7;
        int añoViajeIda2 = 2022;
        int añoViajeVuelta2 = 2022;
        String origen = "SCL";
        String destino = "VLN";
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
        WebElement noVuelos = driver.findElement(localizadorNoVuelos);
        wait.until(ExpectedConditions.elementToBeClickable(noVuelos));
        Assert.assertEquals("No hay vuelos disponibles en estas fechas", noVuelos.getText());
        WebElement noFecha = driver.findElement(localizadorCheckNoDate);
        noFecha.click();
        WebElement dateStart2 = driver.findElement(localizadorDateStart);
        dateStart2.click();
        WebElement btnNextDate2 = driver.findElement(localizadorBtnNextDate2);
        WebElement mesActual2 = driver.findElement(localizadorMonthActive2);
        String monthInit2 = mesActual2.getAttribute("data-month").split("-")[1];
        String yearInit2 = mesActual2.getAttribute("data-month").split("-")[0];
        if (Integer.parseInt(yearInit2) == añoViajeIda2){
            for (int i = Integer.parseInt(monthInit2); i <= mesViajeIda2; i++) {
                if (i == mesViajeIda2){
                    break;
                }
                btnNextDate2.click();
            }
        }
        else if (Integer.parseInt(yearInit2) < añoViajeIda2){
            for (int i = Integer.parseInt(monthInit2); i < 12 + mesViajeIda2; i++) {
                if (i == mesViajeIda2){
                    break;
                }
                btnNextDate2.click();
            }
        }
        String dayDataIda2 = mesViajeIda2 > 9 ? añoViajeIda2 + "-"+ mesViajeIda2 : añoViajeIda2+"-"+"0"+mesViajeIda2;
        By localizadorDay2 = By.xpath("(//div[contains(@data-month, \"" +  dayDataIda2 +"\")]/descendant::span[text()=\""+diaViajeIda2+"\"])[3]");
        WebElement day2 = driver.findElement(localizadorDay2);
        day2.click();
        WebElement mesActualVuelta2 = driver.findElement(localizadorMonthActive2);
        String monthInitVuelta2 = mesActualVuelta2.getAttribute("data-month").split("-")[1];
        String yearInitVuelta2 = mesActualVuelta2.getAttribute("data-month").split("-")[0];
        if (mesViajeIda2<=mesViajeVuelta2 || añoViajeIda2<=añoViajeVuelta2){
            if (Integer.parseInt(yearInitVuelta2) == añoViajeVuelta2){
                for (int i = Integer.parseInt(monthInitVuelta2); i <= mesViajeVuelta2  ; i++) {
                    if (i == mesViajeVuelta2){
                        break;
                    }
                    btnNextDate2.click();
                }
            }
            else if (Integer.parseInt(yearInitVuelta2) < añoViajeVuelta2){
                for (int i = Integer.parseInt(monthInitVuelta2); i < 12 + mesViajeVuelta2; i++) {
                    if (i == mesViajeVuelta2){
                        break;
                    }
                    btnNextDate2.click();
                }
            }
        }
        String dayDataVuelta2 = mesViajeVuelta2 > 9 ? añoViajeVuelta2 + "-"+ mesViajeVuelta2 : añoViajeVuelta2+"-"+"0"+mesViajeVuelta2;
        By localizadorDayR2 = By.xpath("(//div[contains(@data-month, \"" +  dayDataVuelta2 +"\")]/descendant::span[text()=\""+diaViajeVuelta2+"\"])[3]");
        WebElement dayR2 = driver.findElement(localizadorDayR2);
        dayR2.click();
        WebElement aplicar2 = driver.findElement(localizadorBtnAplicarDate2);
        aplicar2.click();
        WebElement pasajeros2 = driver.findElement(localizadorPasajeros);
        pasajeros2.click();
        WebElement adultos2 = driver.findElement(localizadorAumentarAdultos);
        adultos2.click();
        WebElement aplicarPasajeros2 = driver.findElement(localizadorBtnAplicarPasajeros);
        aplicarPasajeros2.click();
        WebElement btnBuscar2 = driver.findElement(localizadorBtnBuscar);
        btnBuscar2.click();
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






    }

    @Test public void VTC05()  {
        int mesViajeIda = 7;
        int mesViajeVuelta = 7;
        int diaViajeIda = 1;
        int diaViajeVuelta = 7;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String origen = "SCL";
        String destino = "VLN";
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

    @Test public void VTC06()  {
        int mesViajeIda = 7;
        int mesViajeVuelta = 7;
        int diaViajeIda = 1;
        int diaViajeVuelta = 7;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String origen = "SCL";
        String destino = "MAD";
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
        wait.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete2));
        WebElement autocomplete2 = driver.findElement(localizadorAutocomplete2);
        autocomplete2.click();
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
            WebElement tarifa = driver.findElement(By.xpath("(//span [@class=\"_pnlpk-agePicker__description\"])[" + (35+i) + "]"));
            Select manejoEdad = new Select (edad);
            if (i == 1){
                manejoEdad.selectByValue("0");
                Assert.assertEquals(tarifa.getText(), "Tarifa bebé");
            }
            if (i == 2){
                manejoEdad.selectByValue("11");
                Assert.assertEquals(tarifa.getText(), "Tarifa niño");
            }
            if (i == 3){
                manejoEdad.selectByValue("17");
                Assert.assertEquals(tarifa.getText(), "Tarifa adulto");
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
        /*if(driver != null){
            driver.close();
        }*/
    }


}
