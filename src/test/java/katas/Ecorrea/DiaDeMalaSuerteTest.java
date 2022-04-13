package katas.Ecorrea;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class DiaDeMalaSuerteTest {
    @Test
    public void testSomething() {
        assertEquals(3, DiaDeMalaSuerte.diademalasuerte(2015));
        assertEquals(1, DiaDeMalaSuerte.diademalasuerte(1986));
    }
}