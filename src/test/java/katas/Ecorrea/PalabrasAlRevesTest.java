package katas.Ecorrea;

import katas.Ecorrea.PalabrasAlReves;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class PalabrasAlRevesTest {
    @Test
    public void exampleCases() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", PalabrasAlReves.pinvertida("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", PalabrasAlReves.pinvertida("apple"));
        assertEquals("a b c d", PalabrasAlReves.pinvertida("a b c d"));
        assertEquals("elbuod  decaps  sdrow", PalabrasAlReves.pinvertida("double  spaced  words"));
    }
}

