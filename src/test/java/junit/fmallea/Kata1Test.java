package junit.fmallea;
import katas.fmallea.Kata1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Kata1Test {

    @Test
    public void palabrasalReves1() {
        String resultado = Kata1.reversa("apple");
        assertEquals("elppa", resultado);
    }


    @Test
    public void palabrasalReves2() {
        String resultado = Kata1.reversa("a b c d");
        assertEquals("a b c d", resultado);
    }

    @Test
    public void palabrasalReves3() {
        String resultado = Kata1.reversa("double spaced words");
        assertEquals("elbuod decaps sdrow", resultado);
    }

    @Test
    public void palabrasalReves4() {
        String resultado=Kata1.reversa("The quick brown fox jumps over the lazy dog.");
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", resultado);
    }
}