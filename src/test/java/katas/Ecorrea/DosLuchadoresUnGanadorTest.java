package katas.Ecorrea;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class DosLuchadoresUnGanadorTest {
    @Test
    public void basicTests() {
        assertEquals("Lew", DosLuchadoresUnGanador.ganadorDeclarado(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", DosLuchadoresUnGanador.ganadorDeclarado(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", DosLuchadoresUnGanador.ganadorDeclarado(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", DosLuchadoresUnGanador.ganadorDeclarado(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", DosLuchadoresUnGanador.ganadorDeclarado(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", DosLuchadoresUnGanador.ganadorDeclarado(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }
}