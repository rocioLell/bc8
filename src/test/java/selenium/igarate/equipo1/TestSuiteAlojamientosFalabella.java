package selenium.igarate.equipo1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class TestSuiteAlojamientosFalabella {
    public static WebDriver driver;
    public By localizadorDestination= By.xpath("//input[contains(@class, \"sbox-destination\")]");
    public By localizadorDateStart = By.xpath("//input[contains(@class, \"sbox-checkin-date\" )]");
    public By localizadorDateEnd = By.xpath("//input[contains(@class, \"sbox-checkout-date\" )]");
    public By localizadorAutocomplete = By.xpath("(//span[@class=\"item-text\"])[1]");
    public By localizadorBtnNextDate = By.xpath("(//div[@class = \"_dpmg2--controls-next\"]/descendant::i)");
    public By localizadorMonthActive = By.xpath("//div[contains(@class, \"_dpmg2--month-active\")]");
    public By localizadorMonthActiveRange = By.xpath("//div[contains(@class, \"_dpmg2--has-start-range\")]");
    public By localizadorBtnAplicarDate = By.xpath("//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
    public By localizadorPasajeros = By.xpath("(//div[contains(@class, \"sbox-guests-container\")])[1]");
    public By localizadorAumentarAdultos = By.xpath("(//a[@class = \"steppers-icon-right sbox-3-icon-plus\"])[1]");
    public By localizadorBtnAplicarPasajeros = By.xpath("//a[text() =\"Aplicar\"]");
    public By localizadorBtnBuscar = By.xpath("(//div [@class = \"sbox-button-container\"] )[1]");
    public By localizadorBtnCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    public By localizadorMensajeDeError = By.xpath("//h5[@class =\"message-title eva-3-h5\"]");
    public By localizadorIniciarSesion = By.xpath("//span[@class=\"header-autogestion-title\"]");
    public By localizadorMensajeBienvenida = By.xpath("//h3[@class=\"eva-3-h3 at-title -eva-3-tc-gray-0\"]");
    public By localizadorCuentaGoogle = By.xpath("(//em[@class=\"btn-text\"])[4]");
    public By localizadorIngresoCorreoElectronico = By.id("identifierId");
    public By localizadorHotelChile = By.xpath("//a[@href=\"/hoteles/hl/7466/i1/hoteles-en-torres+del+paine?hotelOid=354844\"]");
    public By localizadorVerDetalle = By.xpath("(//span[@class=\"-md -primary -eva-3-fwidth eva-3-btn\"])[2]");
    public By localizadorElegirFecha = By.xpath("(//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"])");
    public By localizadorFechaEntrada = By.xpath("//input[@placeholder=\"Entrada\"]");
    public By localizadorFechaSalida = By.xpath("//input[@placeholder=\"Salida\"]");
    public By localizadorFechaNext = By.xpath("(//a[@class = \"calendar-arrow-right\"])");
    public By localizadorMesActivo = By.xpath("//div[@class=\"sbox5-monthgrid\"][1]");
    public By localizadorBtnAplicarFecha = By.xpath("//em[text()=\"Aplicar\"]");
    public By localizadorBtnBuscarHotel = By.xpath("//em[text()=\"Buscar\"]");
    public By localizadorHotelAgotado = By.xpath("//p[contains(text(),\"Todas las\")]");
    public By localizadorSiguienteHotel = By.xpath("//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"][1]");
    public By localizadorHabitacion = By.xpath("//button[@class=\"eva-3-btn -md -secondary -eva-3-fwidth\"]");
    public By localizadorSiguienteComprar = By.xpath("(//button[@class=\"eva-3-btn -lg pricebox-sticky-button -secondary\"])");

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

    @Test public void ATC01(){
        int mesViajeIda = 5;
        int mesViajeVuelta = 5;
        int diaViajeIda = 10;
        int diaViajeVuelta = 20;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String destino = "VLN";
        //Abrir la pagina
        driver.get("https://www.viajesfalabella.cl/hoteles");
        WebElement cookie = driver.findElement(localizadorBtnCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement destination = driver.findElement(localizadorDestination);
        destination.sendKeys(destino);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        WebElement autocomplete = driver.findElement(localizadorAutocomplete);
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
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarDate);
        aplicar.click();
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
    }

    @Test public void ATC02(){
        int mesViajeIda = 6;
        int mesViajeVuelta = 6;
        int diaViajeIda = 1;
        int diaViajeVuelta = 16;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String destino = "kiev";
        //Abrir la pagina
        driver.get("https://www.viajesfalabella.cl/hoteles");
        WebElement cookie = driver.findElement(localizadorBtnCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement destination = driver.findElement(localizadorDestination);
        destination.sendKeys(destino);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        WebElement autocomplete = driver.findElement(localizadorAutocomplete);
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
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarDate);
        aplicar.click();
        //pasajeros
        WebElement pasajeros = driver.findElement(localizadorPasajeros);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorPasajeros));
        pasajeros.click();
        WebElement adultos = driver.findElement(localizadorAumentarAdultos);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAumentarAdultos));
        adultos.click();
        WebElement aplicarPasajeros = driver.findElement(localizadorBtnAplicarPasajeros);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorBtnAplicarPasajeros));
        aplicarPasajeros.click();
        //pasajeros
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorBtnBuscar));
        btnBuscar.click();
        Assert.assertEquals(driver.findElement(localizadorMensajeDeError).getText(), "Todos los alojamientos en Kiev están reservados.");

    }

    @Test public void ATC03() throws InterruptedException {
        int mesViajeIda = 5;
        int mesViajeVuelta = 5;
        int diaViajeIda = 1;
        int diaViajeVuelta = 7;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(1000))
                .withMessage("Error de timeout BC(")
                .ignoring(NoSuchElementException.class);

        //Abrir la pagina
        driver.get("https://www.viajesfalabella.cl/hoteles");
        WebElement cookie = driver.findElement(localizadorBtnCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebElement hotelChile = driver.findElement(localizadorHotelChile);
        wait.until(ExpectedConditions.elementToBeClickable(hotelChile));
        hotelChile.click();
        // ir a otra ventana
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        // ir a otra ventana
        try {
            WebElement verDetalle = driver.findElement(localizadorVerDetalle);
            wait.until(ExpectedConditions.elementToBeClickable(verDetalle));
            verDetalle.click();
        }  catch (StaleElementReferenceException ex) {
            WebElement verDetalle = driver.findElement(localizadorVerDetalle);
            wait.until(ExpectedConditions.elementToBeClickable(verDetalle));
            verDetalle.click();
        }
        // ir a otra ventana
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
        // ir a otra ventana
        try {
            WebElement elegirFecha = driver.findElement(localizadorElegirFecha);
            wait.until(ExpectedConditions.elementToBeClickable(elegirFecha));
            elegirFecha.click();
        }  catch (StaleElementReferenceException ex) {
            WebElement elegirFecha = driver.findElement(localizadorElegirFecha);
            wait.until(ExpectedConditions.elementToBeClickable(elegirFecha));
            elegirFecha.click();
        }
        try {
            WebElement dateStart = driver.findElement(localizadorFechaEntrada);
            wait.until(ExpectedConditions.elementToBeClickable(dateStart));
            dateStart.click();
        }  catch (StaleElementReferenceException ex) {
            WebElement dateStart = driver.findElement(localizadorFechaEntrada);
            wait.until(ExpectedConditions.elementToBeClickable(dateStart));
            dateStart.click();
        }
        WebElement btnNextDate = driver.findElement(localizadorFechaNext);
        wait.until(ExpectedConditions.elementToBeClickable(btnNextDate));
        WebElement mesActual = driver.findElement(localizadorMesActivo);
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
        By localizadorDay = By.xpath("//div[contains(@data-month, \"" +  dayDataIda +"\")]/descendant::div[text()=\""+diaViajeIda+"\"]");
        WebElement day = driver.findElement(localizadorDay);
        day.click();
        WebElement dateEnd = driver.findElement(localizadorFechaSalida);
        dateEnd.click();
        WebElement mesActualVuelta = driver.findElement(localizadorMesActivo);
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
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::div[text()=\""+diaViajeVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarFecha);
        aplicar.click();
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscarHotel);
        wait.until(ExpectedConditions.elementToBeClickable(btnBuscar));
        btnBuscar.click();
        try {
            WebElement verAgotado = driver.findElement(localizadorHotelAgotado);
            wait.until(ExpectedConditions.visibilityOf(verAgotado));
            Assert.assertTrue(verAgotado.isDisplayed());
        }  catch (NoSuchElementException ex) {
            WebElement verAgotado = driver.findElement(localizadorHotelAgotado);
            wait.until(ExpectedConditions.visibilityOf(verAgotado));
            Assert.assertTrue(verAgotado.isDisplayed());
        }
        WebElement siguienteHotel = driver.findElement(localizadorSiguienteHotel);
        wait.until(ExpectedConditions.elementToBeClickable(siguienteHotel));
        siguienteHotel.click();
       // ir a otra ventana
        wait.until(ExpectedConditions.numberOfWindowsToBe(4));
        driver.switchTo().window(driver.getWindowHandles().toArray()[3].toString());
        String url = driver.getCurrentUrl();
        // ir a otra ventana
        try {
            WebElement aceptarHotel = driver.findElement(By.xpath("//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"]"));
            wait.until(ExpectedConditions.elementToBeClickable(aceptarHotel));
            aceptarHotel.click();
            WebElement habitacion = driver.findElement(localizadorHabitacion);
            wait.until(ExpectedConditions.elementToBeClickable(habitacion));
            habitacion.click();
        }  catch (NoSuchElementException ex) {
            WebElement aceptarHotel = driver.findElement(By.xpath("//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"]"));
            wait.until(ExpectedConditions.elementToBeClickable(aceptarHotel));
            aceptarHotel.click();
            WebElement habitacion = driver.findElement(localizadorHabitacion);
            wait.until(ExpectedConditions.elementToBeClickable(habitacion));
            habitacion.click();
        }
        try {
            WebElement comprar = driver.findElement(localizadorSiguienteComprar);
            wait.until(ExpectedConditions.elementToBeClickable(comprar));
            comprar.click();
        }  catch (InvalidSelectorException ex) {
            WebElement comprar = driver.findElement(localizadorSiguienteComprar);
            wait.until(ExpectedConditions.elementToBeClickable(comprar));
            comprar.click();
        }

    }

    @Test public void ATC04(){

        int mesViajeIda = 5;
        int mesViajeVuelta = 5;
        int diaViajeIda = 1;
        int diaViajeVuelta = 31;
        int añoViajeIda = 2022;
        int añoViajeVuelta = 2022;
        String destino = "punta cana";

        //Abrir la pagina
        driver.get("https://www.viajesfalabella.cl/hoteles");
        WebElement cookie = driver.findElement(localizadorBtnCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }
        WebDriverWait delay = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement destination = driver.findElement(localizadorDestination);
        destination.sendKeys(destino);
        delay.until(ExpectedConditions.elementToBeClickable(localizadorAutocomplete));
        WebElement autocomplete = driver.findElement(localizadorAutocomplete);
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
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  dayDataVuelta +"\")]/descendant::span[text()=\""+diaViajeVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicar = driver.findElement(localizadorBtnAplicarDate);
        aplicar.click();
        //pasajeros
        WebElement btnBuscar = driver.findElement(localizadorBtnBuscar);
        btnBuscar.click();
        WebElement iniciarSesion = driver.findElement(localizadorIniciarSesion);
        iniciarSesion.click();
        assertTrue(driver.findElement(localizadorMensajeBienvenida).isDisplayed());
        WebElement cuentaGoogle = driver.findElement(localizadorCuentaGoogle);
        cuentaGoogle.click();






    }




    @After
    public void close(){
      /* if(driver != null){
            driver.close();
        }*/
    }


}
