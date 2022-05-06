package pom.equipo3.test;
import org.junit.Test;
import pom.equipo3.base.JunitBaseTest;
import pom.equipo3.pages.VuelosFalabellaHomePage;

import java.io.IOException;


public class VuelosFalabellaTest extends JunitBaseTest{

  VuelosFalabellaHomePage vuelosFalabellaHomePage;

  @Test
    public  void vuelos() throws IOException {
      vuelosFalabellaHomePage = new VuelosFalabellaHomePage(driver)
      vuelosFalabellaHomePage.irAHomepage();
      vuelosFalabellaHomePage.btnCookies();
      vuelosFalabellaHomePage.ingresarDestino("París, Ile de France, Francia");
      vuelosFalabellaHomePage.ingresarFechaIda(27, 2022, 5))
      vuelosFalabellaHomePage.ingresarFechaVuelta(22,2022,6,2022,5)
      vuelosFalabellaHomePage.aplicarFecha();
      vuelosFalabellaHomePage.btnBuscar();

  }

}
