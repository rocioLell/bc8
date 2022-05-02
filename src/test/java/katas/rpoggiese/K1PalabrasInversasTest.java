package katas.rpoggiese;/*
* Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.

Examples
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"
*
* */

import katas.rpoggiese.K1PalabrasInversas;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

    public class K1PalabrasInversasTest {
        @Test
        public void reverseWords1() {
            String resultado = K1PalabrasInversas.reverseWords("The quick brown fox jumps over the lazy dog.");
            assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", resultado);
        }

        @Test
        public void reverseWords2(){
             String resultado = K1PalabrasInversas.reverseWords("apple");
            assertEquals("elppa", resultado);
        }

        @Test
        public void reverseWords3(){
            String resultado = K1PalabrasInversas.reverseWords("a b c d");
            assertEquals("a b c d", resultado);
        }

        @Test
        public void reverseWords4(){
        String resultado = K1PalabrasInversas.reverseWords("double  spaced  words");
            assertEquals("elbuod  decaps  sdrow", resultado);
        }
    }
