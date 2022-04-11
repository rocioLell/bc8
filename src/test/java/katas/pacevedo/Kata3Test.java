package katas.pacevedo;

import static org.junit.Assert.*;

import org.junit.Test;

public class Kata3Test {
    @Test
    public void valornumero(){
        int resultado= Kata3.fourSeven(4);
        assertEquals(7,resultado);
    }
    @Test
    public void valornumero2(){
        int resultado= Kata3.fourSeven(7);
        assertEquals(4,resultado);
    }
}
