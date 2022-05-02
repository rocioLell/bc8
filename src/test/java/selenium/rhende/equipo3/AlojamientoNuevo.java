package selenium.rhende.equipo3;
import io.github.bonigarcia.wdm.WebDriverManager;
//import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlojamientoNuevo {
    public static WebDriver driver;

    //localizadores
    //tc09
    By BotonCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    By botonAlojamiento = By.xpath("//li[@class=\"header-product-item \"]/descendant::a[@class=\"shifu-3-button-circle HOTELS paint-circle \"]");
    By barraBuscarDestino = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-destination sbox-primary undefined\"]");
    By AutoCompletadoTc09 = By.xpath("(//span[@class=\"item-text\"])[6]");
    By fechasIda = By.xpath("//input[@class=\"input-tag sbox-checkin-date\"]");
    By fechasVuelta = By.xpath("//input[@class=\"input-tag sbox-checkout-date\"]");
    By botonMesSiguiente = By.xpath("(//i[@class=\"_dpmg2--icon-ico-arrow\"])[2]");
    By MonthActive = By.xpath("//div[@class=\"_dpmg2--month _dpmg2--o-5 _dpmg2--month-active\"]");
    By MonthActiveRange = By.xpath("//div[contains(@class, \"_dpmg2--has-start-range\")]");
    By botonAplicarFechas = By.xpath("//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
    By botonBuscar = By.xpath("//div[@class=\"sbox-button-container\"]");
    //TC16
    By AutoCompletadoTc16 = By.xpath("//li[@class=\"item -active\"]");

    By btnHabitaciones = By.xpath("(//div[contains(@class, \"sbox-guests-container\")])[1]");
    By añadirHabitacion = By.xpath("(//div[@class=\"_pnlpk-panel__footer -medium-down-to-lg\"]/descendant::a)[2]");
    By añadirAdulto = By.xpath("(//a[@class = \"steppers-icon-right sbox-3-icon-plus\"])[1]");
    By btnAplicarAñadidos = By.xpath("//a[text() =\"Aplicar\"]");

    By checkboxDesayuno = By.xpath("(//ul[@class=\"dropdown-subcontent\"]/descendant::li[@class=\"dropdown-subitem\"])[2]");
    By checkboxCuatroEstrellas = By.xpath("(//ul[@class=\"dropdown-subcontent\"]/descendant::li[@class=\"dropdown-subitem\"])[4]");
    By hiltonVerDetalles = By.xpath("(//div[@class=\"cluster-description cluster-description-top\"])[9]");
    By verHabitaciones = By.xpath("//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"]/descendant::em");


    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        //preparacion de driver = navegador
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void TC09(){
        int añoIda = 2022;
        int añoVuelta = 2022;
        int mesIda = 5;
        int mesVuelta = 5;
        int diaIda = 20;
        int diaVuelta = 30;
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.viajesfalabella.cl/");
        WebElement cookie = driver.findElement(BotonCookie);
        if(cookie.isDisplayed()){
            cookie.click();
        }

        WebElement alojamiento = driver.findElement(botonAlojamiento);
        alojamiento.click();
        WebElement buscarDestino = driver.findElement(barraBuscarDestino);
        buscarDestino.sendKeys("Rio de");
        espera.until(ExpectedConditions.elementToBeClickable(AutoCompletadoTc09));
        WebElement completado = driver.findElement(AutoCompletadoTc09);
        completado.click();
        WebElement fechaIda = driver.findElement(fechasIda);
        fechaIda.click();
        WebElement mesSiguiente = driver.findElement(botonMesSiguiente);
        WebElement mesActual = driver.findElement(MonthActive);
        String mesInt = mesActual.getAttribute("data-month").split("-")[1];
        String añoInt = mesActual.getAttribute("data-month").split("-")[0];

        if (Integer.parseInt(añoInt) == añoIda){
            for (int i = Integer.parseInt(mesInt); i <= mesVuelta; i++){
                if (i == mesIda){
                    break;
                }
                mesSiguiente.click();
            }
        }else if (Integer.parseInt(añoInt) < añoIda){
            for (int i = Integer.parseInt(mesInt); i < 12 + mesIda; i++){
                if (i == mesIda){
                    break;
                }
                mesSiguiente.click();
            }
        }
        String diaIdaData = mesIda > 9 ? añoIda + "-" + mesIda : añoIda + "-" + "0" + mesIda;
        By localizadorDelDia = By.xpath("//div[contains(@data-month, \"" +  diaIdaData + "\")]/descendant::span[text()=\"" + diaIda + "\"]");
        WebElement dia = driver.findElement(localizadorDelDia);
        dia.click();
        WebElement fechaVuelta = driver.findElement(fechasVuelta);
        fechaVuelta.click();
        WebElement mesActualVuelta = driver.findElement(MonthActiveRange);
        String mesIntVuelta = mesActualVuelta.getAttribute("data-month").split("-")[1];
        String añoIntVuelta = mesActualVuelta.getAttribute("data-month").split("-")[0];
        if (mesIda <= mesVuelta || añoIda <= añoVuelta){
            if (Integer.parseInt(añoIntVuelta) == añoVuelta){
                for (int i = Integer.parseInt(mesIntVuelta); i <= mesVuelta; i++){
                    if (i == mesVuelta){
                        break;
                    }
                    mesSiguiente.click();
                }
            }else if (Integer.parseInt(añoIntVuelta) < añoVuelta){
                for (int i = Integer.parseInt(mesIntVuelta); i < 12 + mesVuelta; i++){
                    if (i == mesVuelta){
                        break;
                    }
                    mesSiguiente.click();
                }
            }
        }
        String diaVueltaData = mesVuelta > 9 ? añoIda + "-" + mesVuelta : añoVuelta + "-" + "0" + mesVuelta;
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  diaVueltaData +"\")]/descendant::span[text()=\""+diaVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicarFechas = driver.findElement(botonAplicarFechas);
        aplicarFechas.click();
        WebElement btnBuscar = driver.findElement(botonBuscar);
        btnBuscar.click();
    }



    @Test
    public void reservaHotelIrlanda(){

        int añoIda = 2022;
        int añoVuelta = 2022;
        int mesIda = 5;
        int mesVuelta = 5;
        int diaIda = 7;
        int diaVuelta = 14;

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.viajesfalabella.cl/");
        WebElement cookie = driver.findElement(BotonCookie);
        cookie.click();

        WebElement alojamiento = driver.findElement(botonAlojamiento);
        alojamiento.click();
        WebElement buscarDestino = driver.findElement(barraBuscarDestino);
        buscarDestino.sendKeys("Dublín, Leinster, Irlanda");
        espera.until(ExpectedConditions.elementToBeClickable(AutoCompletadoTc16));
        WebElement completado = driver.findElement(AutoCompletadoTc16);
        completado.click();

        WebElement fechaIda = driver.findElement(fechasIda);
        fechaIda.click();
        WebElement mesSiguiente = driver.findElement(botonMesSiguiente);
        WebElement mesActual = driver.findElement(MonthActive);
        String mesInt = mesActual.getAttribute("data-month").split("-")[1];
        String añoInt = mesActual.getAttribute("data-month").split("-")[0];

        if (Integer.parseInt(añoInt) == añoIda){
            for (int i = Integer.parseInt(mesInt); i <= mesVuelta; i++){
                if (i == mesIda){
                    break;
                }
                mesSiguiente.click();
            }
        }else if (Integer.parseInt(añoInt) < añoIda){
            for (int i = Integer.parseInt(mesInt); i < 12 + mesIda; i++){
                if (i == mesIda){
                    break;
                }
                mesSiguiente.click();
            }
        }
        String diaIdaData = mesIda > 9 ? añoIda + "-" + mesIda : añoIda + "-" + "0" + mesIda;
        By localizadorDelDia = By.xpath("//div[contains(@data-month, \"" +  diaIdaData + "\")]/descendant::span[text()=\"" + diaIda + "\"]");
        WebElement dia = driver.findElement(localizadorDelDia);
        dia.click();
        WebElement fechaVuelta = driver.findElement(fechasVuelta);
        fechaVuelta.click();
        WebElement mesActualVuelta = driver.findElement(MonthActiveRange);
        String mesIntVuelta = mesActualVuelta.getAttribute("data-month").split("-")[1];
        String añoIntVuelta = mesActualVuelta.getAttribute("data-month").split("-")[0];
        if (mesIda <= mesVuelta || añoIda <= añoVuelta){
            if (Integer.parseInt(añoIntVuelta) == añoVuelta){
                for (int i = Integer.parseInt(mesIntVuelta); i <= mesVuelta; i++){
                    if (i == mesVuelta){
                        break;
                    }
                    mesSiguiente.click();
                }
            }else if (Integer.parseInt(añoIntVuelta) < añoVuelta){
                for (int i = Integer.parseInt(mesIntVuelta); i < 12 + mesVuelta; i++){
                    if (i == mesVuelta){
                        break;
                    }
                    mesSiguiente.click();
                }
            }
        }
        String diaVueltaData = mesVuelta > 9 ? añoIda + "-" + mesVuelta : añoVuelta + "-" + "0" + mesVuelta;
        By localizadorDayR = By.xpath("//div[contains(@data-month, \"" +  diaVueltaData +"\")]/descendant::span[text()=\""+diaVuelta+"\"]");
        WebElement dayR = driver.findElement(localizadorDayR);
        dayR.click();
        WebElement aplicarFechas = driver.findElement(botonAplicarFechas);
        aplicarFechas.click();

        //añadir habitaciones y personas

        WebElement Habitaciones = driver.findElement(btnHabitaciones);
        Habitaciones.click();
        espera.until(ExpectedConditions.elementToBeClickable(añadirHabitacion));
        WebElement habitacion = driver.findElement(añadirHabitacion);
        habitacion.click();
        espera.until(ExpectedConditions.elementToBeClickable(añadirAdulto));
        WebElement sumarAdulto = driver.findElement(añadirAdulto);
        sumarAdulto.click();
        WebElement aplicarAñadidos = driver.findElement(btnAplicarAñadidos);
        aplicarAñadidos.click();

        WebElement btnBuscar = driver.findElement(botonBuscar);
        btnBuscar.click();
        espera.until(ExpectedConditions.elementToBeClickable(checkboxDesayuno));
        WebElement desayuno = driver.findElement(checkboxDesayuno);
        desayuno.click();
        espera.until(ExpectedConditions.elementToBeClickable(checkboxCuatroEstrellas));
        WebElement cuatroEstrellas = driver.findElement(checkboxCuatroEstrellas);
        cuatroEstrellas.click();
        WebElement hilton = driver.findElement(hiltonVerDetalles);
        hilton.click();
        espera.until(ExpectedConditions.elementToBeClickable(verHabitaciones));
        WebElement todosLosServicios = driver.findElement(verHabitaciones);
        todosLosServicios.click();


    }


    /*
    @After
    public void close(){
        if (driver != null){
            driver.close();
        }
    }

     */
}
