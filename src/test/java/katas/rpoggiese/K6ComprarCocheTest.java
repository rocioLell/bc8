/* Comencemos con un ejemplo:
        Un hombre tiene un auto bastante viejo que vale $ 2000.
        Vio que un automóvil de segunda mano valía $ 8000.
        Quiere conservar su viejo coche hasta que pueda comprar el de segunda mano.
        Cree que puede ahorrar $ 1000 cada mes, pero los precios de su automóvil viejo y del nuevo disminuyen un 1.5 por ciento por mes.
        Además, este porcentaje de pérdida aumenta del por ciento al final de cada dos meses.
        A nuestro hombre le resulta difícil hacer todos estos cálculos.0.5

        ¿Puedes ayudarlo?
        ¿Cuántos meses le llevará ahorrar suficiente dinero para comprar el automóvil que quiere
        y cuánto dinero le quedará?
*/
        package katas.rpoggiese;

import static  org.junit.Assert.*;

import katas.rpoggiese.K6ComprarCoche;
import org.junit.Test;

public class K6ComprarCocheTest {
        K6ComprarCoche objectTest = new K6ComprarCoche();

        @Test
        public void meses6Test(){
                int[] r = new int[] { 6, 766 };
                assertArrayEquals(r, objectTest.nbMeses(2000, 8000, 1000, 1.5));
        }
        @Test
        public void ceroMesesTest(){
                int[] r = new int[] { 0, 4000 };
                assertArrayEquals(r, objectTest.nbMeses(12000, 8000, 1000, 1.5));
        }
        @Test
        public void testFinal() {
                int[] r = new int[] { 0, 0 };
                assertArrayEquals(r, objectTest.nbMeses(8000, 8000, 1000, 1.5));
        }
}