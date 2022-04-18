package katas.Ecorrea;
import static org.junit.Assert.*;
import org.junit.Test;


public class JugandoConDigitosTest {

    @Test
    public void Test1() {
        assertEquals(1, JugandoConDigitos.digPow(89, 1));
    }
    @Test
    public void Test2() {
        assertEquals(-1, JugandoConDigitos.digPow(92, 1));
    }
    @Test
    public void Test3() {
        assertEquals(51, JugandoConDigitos.digPow(46288, 3));
    }
}