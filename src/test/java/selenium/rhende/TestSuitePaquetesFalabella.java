package selenium.rhende;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class TestSuitePaquetesFalabella {
    public static WebDriver driver;
    public By localizadorOrigin = By.xpath("//input[contains(@class, \"sbox-origin\")]");
    public By localizadorDestination= By.xpath("//input[contains(@class, \"sbox-destination\")]");
    public By localizadorDateStart = By.xpath("//input[contains(@class, \"sbox-checkin-date\" )]");
    public By localizadorDateEnd = By.xpath("//input[contains(@class, \"sbox-checkout-date\" )]");
    public By localizadorAutocomplete = By.xpath("//li[@class=\"item -active\"]");
    public By localizadorBtnNextDate = By.xpath("(//div[@class = \"_dpmg2--controls-next\"]/descendant::i)[3]");
    public By localizadorMonthActive = By.xpath("//div[contains(@class, \"_dpmg2--month-active\")]");
    public By localizadorMonthActiveRange = By.xpath("//div[contains(@class, \"_dpmg2--has-start-range\")]");
    public By localizadorBtnAplicarDate = By.xpath("(//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"])[3]");
    public By localizadorBtnAplicarDate2 = By.xpath("(//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"])[2]");
    public By localizadorPasajeros = By.xpath("(//div[contains(@class, \"sbox-guests-container\")])[1]");
    public By localizadorAumentarAdultos = By.xpath("(//a[@class = \"steppers-icon-right sbox-3-icon-plus\"])[3]");
    public By localizadorBtnAplicarPasajeros = By.xpath("(//a[text() =\"Aplicar\"])[2]");
    public By localizadorBtnBuscar = By.xpath("(//div [@class = \"sbox-button-container\"] )[1]");
    public By localizadorBtnCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    public By localizadorAlojamientosAv = By.xpath("//span[@class=\"checkbox-label sbox-advanced-options-label\"]");
    public By localizadorAlojamientoCiudad = By.xpath("(//i[@class=\"checkbox-check sbox-3-icon-checkmark -mr1\"])[1]");
    public By localizadorSoloFecha = By.xpath("(//i[@class=\"checkbox-check sbox-3-icon-checkmark -mr1\"])[2]");
    public By localizadorFechaInicio = By.xpath("//input[@class=\"input-tag sbox-partial-stay-checkin-date\"]");
    public By localizadorOtroDestino = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-hotel-another-city sbox-primary undefined attr\"]");
    public By localizadorCuatroEstrellas = By.xpath("(//i[@class=\"checkbox-check eva-3-icon-checkmark filters-checkbox-left\"])[4]");
    public By localizadorHotelCosta = By.xpath("(//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"])[2]");
    public By localizadorSuiteEs = By.xpath("(//i[@class=\"radio-circle\"])[4]");
    public By localizadorSiguienteHotel = By.xpath("(//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"])[1]");
    public By localizadorEquipajeBodega = By.xpath("(//i[@class=\"checkbox-check eva-3-icon-checkmark filters-checkbox-left\"])[3]");
    public By localizadorSiguienteVuelo = By.xpath("(//buy-button)[1]");
    public By localizadorBtnNextAuto = By.xpath("(//div [@class=\"eva-3-nav-slider custom-nav-slider-styles -right -md -eva-3-shadow-line-hover -white arrow-right outside-position-navigation\"])[2]");
    public By localizadorAgregarAuto = By.xpath("(//button [@class=\"eva-3-btn -md -primary -eva-3-ml-sm\"])[14]");
    public By localizadorAgregarAutoCompacto = By.xpath("//a[@class=\"eva-3-btn-ghost -lg -primary\"]");
    public By localizadorNextCompra = By.xpath("//button[@class=\"eva-3-btn -lg pricebox-sticky-button -secondary\"]");
    public By localizadorApurate = By.xpath("(//span [@class=\"eva-3-h5 message-title\"])[1]");
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test public void PTC01(){
        int mesViajeIda = 5;
        int mesViajeVuelta = 5;
        int diaViajeIda = 1;
        int diaViajeVuelta = 20;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String origen = "SCL";
        String destino = "VLN";
        //Abrir la pagina
        driver.get("https://www.viajesfalabella.cl/paquetes");
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
        delay.until(ExpectedConditions.elementToBeClickable(localizadorDateStart));
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
        By localizadorDay = By.xpath("(//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::span[text()=\""+diaViajeIda+"\"])[3]");
        WebElement day = driver.findElement(localizadorDay);
        day.click();
        delay.until(ExpectedConditions.elementToBeClickable(localizadorDateEnd));
        WebElement dateEnd = driver.findElement(localizadorDateEnd);
        dateEnd.click();
        WebElement mesActualVuelta = driver.findElement(localizadorMonthActiveRange);
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
        By localizadorDayR = By.xpath("(//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"])[3]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarDate);
        aplicar.click();
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
    }

    @Test public void PTC06()  {
        int mesViajeIda = 6;
        int mesViajeVuelta = 6;
        int diaViajeIda = 1;
        int diaOtraEstadia = 2;
        int diaViajeVuelta = 7;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String origen = "SCL";
        String destino = "AEP";
        String destinoNuevo = "Colonia del Sacramento, Colonia, Uruguay";
        //Abrir la pagina

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(1000))
                .withMessage("Error de timeout BC(")
                .ignoring(NoSuchElementException.class);


        driver.get("https://www.viajesfalabella.cl/paquetes");
        WebElement cookie = driver.findElement(localizadorBtnCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement origin = driver.findElement(localizadorOrigin);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorOrigin));
        origin.sendKeys(origen);
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
        By localizadorDay = By.xpath("(//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::span[text()=\""+diaViajeIda+"\"])[3]");
        WebElement day = driver.findElement(localizadorDay);
        day.click();
        delay.until(ExpectedConditions.elementToBeClickable(localizadorDateEnd));
        WebElement dateEnd = driver.findElement(localizadorDateEnd);
        dateEnd.click();
        WebElement mesActualVuelta = driver.findElement(localizadorMonthActiveRange);
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
        By localizadorDayR = By.xpath("(//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"])[3]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarDate);
        aplicar.click();
        WebElement alojamientoAv = driver.findElement(localizadorAlojamientosAv);
        delay.until(ExpectedConditions.elementToBeClickable(alojamientoAv));
        alojamientoAv.click();
        WebElement alojamientoCiudad = driver.findElement(localizadorAlojamientoCiudad);
        delay.until(ExpectedConditions.elementToBeClickable(alojamientoCiudad));
        alojamientoCiudad.click();
        WebElement alojamientoOtraCiudad = driver.findElement(localizadorSoloFecha);
        delay.until(ExpectedConditions.elementToBeClickable(alojamientoOtraCiudad));
        alojamientoOtraCiudad.click();
        WebElement dateInicio = driver.findElement(localizadorFechaInicio);
        delay.until(ExpectedConditions.elementToBeClickable(dateInicio));
        dateInicio.click();
        By localizadorDayE = By.xpath("(//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::span[text()=\""+diaOtraEstadia+"\"])[4]");
        WebElement dayE = driver.findElement(localizadorDayE);
        dayE.click();
        By localizadorDayRE = By.xpath("(//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"])[4]");
        WebElement dayRE = driver.findElement(localizadorDayRE);
        dayRE.click();
        WebElement aplicar2 = driver.findElement(localizadorBtnAplicarDate2);
        aplicar2.click();
        WebElement nuevoDestino = driver.findElement(localizadorOtroDestino);
        delay.until(ExpectedConditions.elementToBeClickable(nuevoDestino));
        nuevoDestino.click();
        nuevoDestino.sendKeys(destinoNuevo);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        autocomplete.click();
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
        WebElement cuatroEstrellas = driver.findElement(localizadorCuatroEstrellas);
        delay.until(ExpectedConditions.elementToBeClickable(cuatroEstrellas));
        cuatroEstrellas.click();
        WebElement hotelCosta = driver.findElement(localizadorHotelCosta);
        delay.until(ExpectedConditions.elementToBeClickable(hotelCosta));
        hotelCosta.click();
        // ir a otra ventana
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        // ir a otra ventana
        WebElement suiteEs = driver.findElement(localizadorSuiteEs);
        wait.until(ExpectedConditions.elementToBeClickable(suiteEs));
        suiteEs.click();
        WebElement btnReservar = driver.findElement(localizadorSiguienteHotel);
        wait.until(ExpectedConditions.elementToBeClickable(btnReservar));
        btnReservar.click();
        WebElement equipaje = driver.findElement(localizadorEquipajeBodega);
        wait.until(ExpectedConditions.elementToBeClickable(equipaje));
        equipaje.click();
        try {
            WebElement btnVuelo = driver.findElement(localizadorSiguienteVuelo);
            wait.until(ExpectedConditions.elementToBeClickable(btnVuelo));
            btnVuelo.click();
        }
        catch(org.openqa.selenium.ElementClickInterceptedException ex)
        {
            WebElement btnVuelo = driver.findElement(localizadorSiguienteVuelo);
            wait.until(ExpectedConditions.elementToBeClickable(btnVuelo));
            btnVuelo.click();
        }
        try {
            driver.findElement(By.cssSelector("Body")).sendKeys(Keys.END);
            wait.until(ExpectedConditions.visibilityOfElementLocated(localizadorBtnNextAuto));
            WebElement btnNextAuto = driver.findElement(localizadorBtnNextAuto);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();", btnNextAuto);
            WebElement btnAgregarAuto = driver.findElement(localizadorAgregarAuto);
            jse.executeScript("arguments[0].click();", btnAgregarAuto);
            WebElement btnAgregarAutoCom = driver.findElement(localizadorAgregarAutoCompacto);
            jse.executeScript("arguments[0].click();", btnAgregarAutoCom);
            WebElement btnNextComprar = driver.findElement(localizadorNextCompra);
            jse.executeScript("arguments[0].click();", btnNextComprar);

        }
        catch(org.openqa.selenium.ElementClickInterceptedException ex)
        {
            driver.findElement(By.cssSelector("Body")).sendKeys(Keys.END);
            wait.until(ExpectedConditions.visibilityOfElementLocated(localizadorBtnNextAuto));
            WebElement btnNextAuto = driver.findElement(localizadorBtnNextAuto);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();", btnNextAuto);
            WebElement btnAgregarAuto = driver.findElement(localizadorAgregarAuto);
            jse.executeScript("arguments[0].click();", btnAgregarAuto);
            WebElement btnAgregarAutoCom = driver.findElement(localizadorAgregarAutoCompacto);
            jse.executeScript("arguments[0].click();", btnAgregarAutoCom);
            WebElement btnNextComprar = driver.findElement(localizadorNextCompra);
            jse.executeScript("arguments[0].click();", btnNextComprar);
        }
        WebElement apurate = driver.findElement(localizadorApurate);
        wait.until(ExpectedConditions.elementToBeClickable(apurate));
        Assert.assertEquals(apurate.getText(), "¡Apúrate!");

    }

    @After
    public void close(){
      /* if(driver != null){
            driver.close();
        }*/
    }


}
