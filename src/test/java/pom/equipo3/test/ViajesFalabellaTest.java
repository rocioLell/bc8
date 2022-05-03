package pom.equipo3.test;

import org.junit.Test;
import pom.equipo3.base.JunitBaseTest;
import pom.equipo3.pages.ViajesFalabellaHomePage;

public class ViajesFalabellaTest extends JunitBaseTest {

    ViajesFalabellaHomePage viajesFalabellaHomePage;

    @Test
    public void busquedaAlojamiento(){
        viajesFalabellaHomePage = new ViajesFalabellaHomePage(driver);
        viajesFalabellaHomePage.irAHomePage();
        viajesFalabellaHomePage.btnCookies();
        viajesFalabellaHomePage.btnAlojamiento();
        viajesFalabellaHomePage.buscarDestino("Rio de");
        viajesFalabellaHomePage.autoCompletado();
        viajesFalabellaHomePage.sinFechasDefinidas();
        viajesFalabellaHomePage.btnBuscar();
    }
}
