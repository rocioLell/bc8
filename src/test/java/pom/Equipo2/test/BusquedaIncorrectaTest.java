package pom.Equipo2.test;

import org.junit.Test;
import pom.Equipo2.Base.JUnitBaseTest;
import pom.Equipo2.Pages.Alojamientos;
import pom.Equipo2.Pages.Home;

public class BusquedaIncorrectaTest extends JUnitBaseTest {
    Home falabellaHome;
    Alojamientos alojamientos;
    @Test
    public void ATC01AL(){
        falabellaHome = new Home(driver);
        alojamientos = new Alojamientos(driver);
        falabellaHome.irAHome();
        falabellaHome.irAAlojamientos();
        alojamientos.seleccionarCheckbox();
        alojamientos.seleccionBarraBusqueda();
        alojamientos.clickBuscar();

    }
}
