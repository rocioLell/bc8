package pom.equipo1.test;


import pom.equipo1.pages.AlojamientosFalabellaPage;
import org.junit.Assert;
import org.junit.Test;
import pom.equipo1.base.JunitBaseTest;
import pom.equipo1.pages.AlojamientosFalabellaPage;


public class Alojamientos extends JunitBaseTest {
    AlojamientosFalabellaPage AlojamientosFalabellaPage;

    @Test
    public void EncontrarAlojamientoDesdeBuscador() {
        AlojamientosFalabellaPage = new AlojamientosFalabellaPage(driver);
        AlojamientosFalabellaPage.irAlojamientosFalabella();
        AlojamientosFalabellaPage.aceptarCookies();
        AlojamientosFalabellaPage.ingresarDestino("VLN");
        AlojamientosFalabellaPage.ingresarFechaIda(10, 2022, 5);
        AlojamientosFalabellaPage.ingresarFechaVuelta(25, 2022, 5, 2022, 5);
        AlojamientosFalabellaPage.aplicarFecha();
        AlojamientosFalabellaPage.buscarAlojamiento();
        Assert.assertEquals("Nueva ciudad, nuevas experiencias.\n" +
                "Alojamientos cerca de Valencia ¡te están esperando!", AlojamientosFalabellaPage.resultadoAlojamiento());

    }

    @Test
    public void noHayDisponibilidad() {
        AlojamientosFalabellaPage = new AlojamientosFalabellaPage(driver);
        AlojamientosFalabellaPage.irAlojamientosFalabella();
        AlojamientosFalabellaPage.aceptarCookies();
        AlojamientosFalabellaPage.ingresarDestino("kiev");
        AlojamientosFalabellaPage.ingresarFechaIda(1, 2022, 6);
        AlojamientosFalabellaPage.ingresarFechaVuelta(16, 2022, 6, 2022, 6);
        AlojamientosFalabellaPage.aplicarFecha();
        AlojamientosFalabellaPage.selecionarPasajerosAdultos(2);
        AlojamientosFalabellaPage.buscarAlojamiento();
        Assert.assertEquals("Todos los alojamientos en Kiev están reservados.", AlojamientosFalabellaPage.resultadoError());
    }
}

