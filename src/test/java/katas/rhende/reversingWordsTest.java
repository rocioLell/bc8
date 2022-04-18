package katas.rhende;

import katas.igarate.reversingWords;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class reversingWordsTest {

    @Test
    public void fraseLarga() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", reversingWords.reverseWords("The quick brown fox jumps over the lazy dog."));

    }

    @Test
    public void fraseCorta() {
        assertEquals("elppa", reversingWords.reverseWords("apple"));
    }

    @Test
    public void Letras() {
        assertEquals("a b c d", reversingWords.reverseWords("a b c d"));
    }

    @Test
    public void dobleEspacios() {
        assertEquals("elbuod  decaps  sdrow", reversingWords.reverseWords("double  spaced  words"));
    }

    @Test
    public void Espacios() {
        assertEquals(" ", reversingWords.reverseWords("      "));
    }

}
