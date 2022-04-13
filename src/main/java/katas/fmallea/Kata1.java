package katas.fmallea;
/*
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

// TODO: Replace examples and use TDD development by writing your own tests

public class SolutionTest {
    @Test
    public void exampleCases() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", Kata.reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", Kata.reverseWords("apple"));
        assertEquals("a b c d", Kata.reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", Kata.reverseWords("double  spaced  words"));
    }
}
*/

public class Kata1 {
    public static String reversa(String text)
    {
        String textoIngresado [] = text.split("\\s");
        String reversa="";
        for (String C:textoIngresado) {
            StringBuilder sb= new StringBuilder(C);
            sb.reverse();
            reversa += sb.toString() + " ";
        }
        return reversa.trim();
    }
}
