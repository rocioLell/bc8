package katas.gneyra;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReverseWordsTest {

    @Test
    public void fraseLarga(){

        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", ReverseWords.reverseWords("The quick brown fox jumps over the lazy dog."));

    }

    @Test
    public void fraseCorta(){

        assertEquals("elppa", ReverseWords.reverseWords("apple"));

    }

    @Test
    public void Letras(){

        assertEquals("a b c d", ReverseWords.reverseWords("a b c d"));

    }

    @Test
    public void dobleEspacios(){

        assertEquals("elbuod decaps sdrow", ReverseWords.reverseWords("double spaced words"));

    }

    @Test
    public void Espacios(){

        assertEquals(" ", ReverseWords.reverseWords("     "));

    }

}
