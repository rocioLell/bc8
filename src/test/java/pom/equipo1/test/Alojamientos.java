package pom.equipo1.test;

import org.junit.Test;
import pom.equipo1.base.JunitBaseTest;
import pom.equipo1.pages.BusquedaAlojamientosFalabellaPage;

public class Alojamientos extends JunitBaseTest {

    BusquedaAlojamientosFalabellaPage busquedaAlojamientosFalabellaPage;

    @Test
    public void ATC01(){
        busquedaAlojamientosFalabellaPage = new BusquedaAlojamientosFalabellaPage(driver);
        busquedaAlojamientosFalabellaPage.irAlojamientosFalabella();
        busquedaAlojamientosFalabellaPage.aceptarCookies();
        busquedaAlojamientosFalabellaPage.ingresarDestino("VLN");
        busquedaAlojamientosFalabellaPage.ingresarFechaIda(10, 2022, 5);
        busquedaAlojamientosFalabellaPage.ingresarFechaVuelta(25, 2022, 5, 2022, 5);
        busquedaAlojamientosFalabellaPage.aplicarFecha();
        busquedaAlojamientosFalabellaPage.buscarAlojamiento();

    }
}
