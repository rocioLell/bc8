package pom.Equipo2.Base;

import org.openqa.selenium.*;

import java.util.List;
import java.util.Set;

public class SeleniumBasePage {
    /*en esta clase inicializaremos los metodos de selenium que usaremos en nuestra automatizacion*/

    protected WebDriver driver;

    public SeleniumBasePage(WebDriver driver){
        this.driver =driver;
    }
    //Wrappers Selenium
    /**
     * funcion wrapper para obtener un WebElement
     * @param locator: Objeto By de la Page
     * @return WebElement
     */
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    /**
     * funcion wrapper para obtener una Lista de WebElement
     * @param locator: Objeto By de la Page
     * @return Lista de WebElement
     */
    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    /**
     * funcion que obtiene el texto de un objeto WebElement
     * @param locator: Objeto By del repositorio
     * @return String     *
     */
    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    /**
     * funcion que escribe un texto enviado a un objeto WebElement
     * @param inputText : texto a escribir
     * @param locator : Objeto By del repositorio
     */
    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void submit(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    /**
     * funcion que hace 1 click en un WebElement
     * @param locator : Objeto By del repositorio
     */
    public void click(By locator){
        driver.findElement(locator).click();
    }

    /**
     * funcion que cierra el Objeto WebDriver
     */
    public void closeDriver(){
        driver.close();
    }

    /**
     * funcion para saber si un WebElement esta desplegado en pantalla
     * @param locator : Objeto By del repositorio
     * @return : verdadero o falso
     */
    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    /**
     * funcion para Navegar a un URL
     * @param url : String con URL
     */
    public void goToUrl(String url){
        driver.get(url);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void scrollear (By locator){
        WebElement scroll = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", scroll);
    }




}
