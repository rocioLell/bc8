package katas.poggioem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Kata2Test {
    @Test
    public void kata2Test1() {
        String resultadokata2 = Kata2.alternativeCase("hello world");
        assertEquals("HELLO WORLD", resultadokata2);
    }

    @Test
    public void kata2Test2() {
        String resultadokata2 = Kata2.alternativeCase("HELLO WORLD");
        assertEquals("hello world", resultadokata2);
    }

    @Test
    public void kata2Test3() {
        String resultadokata2 = Kata2.alternativeCase("hello WORLD");
        assertEquals("HELLO world", resultadokata2);
    }

    @Test
    public void kata2Test4() {
        String resultadokata2 = Kata2.alternativeCase("HeLLo WoRLD");
        assertEquals("hEllO wOrld", resultadokata2);
    }

    @Test
    public void kata2Test5() {
        String resultadokata2 = Kata2.alternativeCase("12345");
        assertEquals("12345", resultadokata2);
    }

    @Test
    public void kata2Test6() {
        String resultadokata2 = Kata2.alternativeCase("1a2b3c4d5e");
        assertEquals("1A2B3C4D5E", resultadokata2);
    }

    @Test
    public void kata2Test7() {
        String resultadokata2 = Kata2.alternativeCase("String.prototype.toAlternatingCase");
        assertEquals("sTRING.PROTOTYPE.TOaLTERNATINGcASE", resultadokata2);

    }
    @Test
    public void kata2Test8() {
        String resultadokata2 = Kata2.alternativeCase("Hello World");
        assertEquals("Hello World", resultadokata2);

    }

}
