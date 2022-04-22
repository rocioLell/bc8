package katas.jvegas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReverseWordsTeast {
    @Test
    public void fraseLarga() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ReverseWords.palabrasInversas("The quick brown fox jumps over the lazy dog."));
    }

    @Test
    public void fraseCorta() {
        assertEquals("elppa", ReverseWords.palabrasInversas("apple"));
    }

    @Test
    public void Letras() {
        assertEquals("a b c d", ReverseWords.palabrasInversas("a b c d"));
    }

    @Test
    public void dobleEspacios() {
        assertEquals("elbuod  decaps  sdrow", ReverseWords.palabrasInversas("double  spaced  words"));
    }

    @Test
    public void Espacios() {
        assertEquals(" ", ReverseWords.palabrasInversas("      "));
    }
}
