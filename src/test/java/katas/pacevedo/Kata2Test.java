package katas.pacevedo;
import static  org.junit.Assert.*;

import org.junit.Test;

public class Kata2Test {


    @Test
    public void stringAlternative() {
        String resultado = Kata2.toAlternativeString("hello world");
        assertEquals("HELLO WORLD", resultado);
    }

    @Test
    public void stringAlternative1() {
        String resultado = Kata2.toAlternativeString("HELLO WORLD");
        assertEquals("hello world", resultado);
    }

    @Test
    public void stringAlternative2() {
        String resultado = Kata2.toAlternativeString("hello WORLD");
        assertEquals("HELLO world", resultado);
    }

    @Test
    public void stringAlternative3() {
        String resultado = Kata2.toAlternativeString("HeLLo WoRLD");
        assertEquals("hEllO wOrld", resultado);
    }
}

