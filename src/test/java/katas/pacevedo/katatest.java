package katas.pacevedo;

import static org.junit.Assert.*;

import org.junit.Test;

public class katatest {


    @Test
    public void palabrasalReves1(){
        String resultado= Kata.reversa("apple");
        assertEquals("elppa",resultado);

    }

    @Test
    public void palabrasalReves2(){
        String resultado= Kata.reversa("a b c d");
        assertEquals("a b c d",resultado);

    }
    @Test
    public void palabrasalReves3(){
        String resultado= Kata.reversa("double spaced words");
        assertEquals("elbuod decaps sdrow",resultado);

    }
    @Test
    public void palabrasalReves4(){
        String resultado= Kata.reversa("The quick brown fox jumps over the lazy dog.");
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god",resultado);

    }

}