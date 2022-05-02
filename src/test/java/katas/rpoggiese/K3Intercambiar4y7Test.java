package katas.rpoggiese;

import katas.rpoggiese.K3Intercambiar4y7;
import org.junit.Test;
import static org.junit.Assert.*;


public class K3Intercambiar4y7Test {

    @Test
        public void fourSeven1() {
        int nuevoResultado = K3Intercambiar4y7.fourSeven(7);
        assertEquals(4, nuevoResultado);
        }

    @Test
        public void fourSeven2() {
        int nuevoResultado = K3Intercambiar4y7.fourSeven(4);
        assertEquals(7, nuevoResultado);
    }
    @Test
    public void fourSeven3() {
        int nuevoResultado = K3Intercambiar4y7.fourSeven(5);
        assertEquals(0, nuevoResultado);
    }
}

