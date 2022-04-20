package katas.pacevedo;
import static org.junit.Assert.*;

import org.junit.Test;
public class Kata4Test {
    @Test
    public void diaDelaMalaSuerte(){
        int resultado= Kata4.unluckyDays(2015);
        assertEquals(3,resultado);

    }
    @Test
    public void diaDelaMalaSuerte2(){
        int resultado= Kata4.unluckyDays(1986);
        assertEquals(1,resultado);

    }

}
