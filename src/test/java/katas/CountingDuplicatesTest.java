package junit.jvegas.katas;

import static org.junit.Assert.*;

import katas.CountingDuplicates;
import org.junit.Test;

public class CountingDuplicatesTest {

    @Test
    public void stringIngresadoRetornaCero(){
        int resultado = CountingDuplicates.duplicateCount("abcde");
        assertEquals(0,resultado);
    }

    @Test
    public void stringIngresoRetorna2(){
        int resultado = CountingDuplicates.duplicateCount("aabbcde");
        assertEquals(2,resultado);

    }

    @Test
    public void stringIngresoRetorna2CaseSensitive(){
        int resultado = CountingDuplicates.duplicateCount("aabBcde");
        assertEquals(2,resultado);

    }

    @Test
    public void stringIngresoRetorna1(){
        int resultado = CountingDuplicates.duplicateCount("indivisibility");
        assertEquals(1,resultado);

    }
    @Test
    public void stringIngresoRetorna2Numeros(){
        int resultado = CountingDuplicates.duplicateCount("aA11");
        assertEquals(2,resultado);

    }
    @Test
    public void stringIngresoRetorna2Mayusculas(){
        int resultado = CountingDuplicates.duplicateCount("ABBA");
        assertEquals(2,resultado);

    }

}
