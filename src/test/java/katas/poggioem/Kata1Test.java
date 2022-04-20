package katas.poggioem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Kata1Test {

    @Test
    public void reverseWordstest1() {
        String resultado = Kata1.reverseWords("The quick brown fox jumps over the lazy dog");
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal god", resultado);
    }

    @Test
    public void reverseWordtest2() {
        String resultado = Kata1.reverseWords("apple");
        assertEquals("elppa", resultado);
    }

    @Test
    public void reverseWordtest3() {
        String resultado = Kata1.reverseWords("a b c d");
        assertEquals("a b c d", resultado);
    }

    @Test
    public void reverseWordtest4() {
        String resultado = Kata1.reverseWords("double  spaced  words");
        assertEquals("elbuod  decaps  sdrow", resultado);
    }
    @Test
    public void reverseWordtest5() {
        String resultado = Kata1.reverseWords("   ");
        assertEquals("   ", resultado);
    }
}



