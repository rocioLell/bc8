package pom.Equipo2.test;

import static org.junit.Assert.*;
import org.junit.Test;
import pom.Equipo2.Base.JUnitBaseTest;
import pom.Equipo2.Pages.Alojamientos;
import pom.Equipo2.Pages.Home;
import pom.Equipo2.Pages.HotelesFallabela;

public class AlojamientosTest extends JUnitBaseTest {
    Home falabellaHome;
    Alojamientos alojamientos;
    HotelesFallabela hotelesFallabela;
    @Test
    public void BusquedaIncorrectaTest(){
        falabellaHome = new Home(driver);
        alojamientos = new Alojamientos(driver);
        falabellaHome.irAHome();
        falabellaHome.irAAlojamientos();
        alojamientos.seleccionarCheckbox();
        alojamientos.seleccionBarraBusqueda();
        alojamientos.ecribirEnBarraBusqueda();
        alojamientos.clickBuscar();

    }
    @Test
    public void alojamientoMasActividad() {
        falabellaHome = new Home(driver);
        alojamientos = new Alojamientos(driver);
        hotelesFallabela = new HotelesFallabela(driver);
        falabellaHome.irAHome();
        falabellaHome.irAAlojamientos();
        alojamientos.seleccionBarraBusqueda();
        alojamientos.escribirEnBarraBusqueda2();
        alojamientos.cerrarMensajeCookies();
        alojamientos.seleccionarCalendario();
        alojamientos.seleccionarFecha2();
        alojamientos.cantidadDeHabitaciones();
        alojamientos.cantidadDeAdultos();
        alojamientos.clickBuscar();
        alojamientos.seleccionarHotel();
        alojamientos.cambioDePestaña();
        hotelesFallabela.seleccionarHabitaciones();
        hotelesFallabela.reservarHabitacion();
        hotelesFallabela.seleccionarActividad();
        hotelesFallabela.clickBtnSiguiente();

        //assertEquals("593.493",);

    }
}
