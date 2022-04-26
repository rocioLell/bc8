package katas.rpoggiese;/*
describe("String.prototype.toAlternatingCase", () => {
        it("should work for fixed tests (provided in the description)", () => {
                Test.assertEquals("hello world".toAlternatingCase(), "HELLO WORLD");
        Test.assertEquals("HELLO WORLD".toAlternatingCase(), "hello world");
        Test.assertEquals("hello WORLD".toAlternatingCase(), "HELLO world");
        Test.assertEquals("HeLLo WoRLD".toAlternatingCase(), "hEllO wOrld");
        Test.assertEquals("12345".toAlternatingCase(), "12345");
        Test.assertEquals("1a2b3c4d5e".toAlternatingCase(), "1A2B3C4D5E");
        Test.assertEquals("String.prototype.toAlternatingCase".toAlternatingCase(), "sTRING.PROTOTYPE.TOaLTERNATINGcASE");
        Test.assertEquals("Hello World".toAlternatingCase().toAlternatingCase(), "Hello World");
  });
    });
* */

import katas.rpoggiese.K2InvertirLowerUppercase;
import org.junit.Test;
import static org.junit.Assert.*;


public class K2InvertirLowerUppercaseTest {

    @Test
    public void alternativeCase1() {
        String resultado2 = K2InvertirLowerUppercase.toAlternativeString("hello world");
        assertEquals("HELLO WORLD", resultado2);
    }

    @Test
    public void alternativeCase2() {
        String resultado2 = K2InvertirLowerUppercase.toAlternativeString("HELLO WORLD");
        assertEquals("hello world", resultado2);
    }

    @Test
    public void alternativeCase3() {
        String resultado2 = K2InvertirLowerUppercase.toAlternativeString("HELLO world");
        assertEquals("hello WORLD", resultado2);
    }

    @Test
    public void alternativeCase4() {
        String resultado2 = K2InvertirLowerUppercase.toAlternativeString("hEllO wOrld");
        assertEquals("HeLLo WoRLD", resultado2);
    }
    @Test
        public void alternativeCase5() {
            String resultado2 = K2InvertirLowerUppercase.toAlternativeString("Hello world");
            assertEquals("Hello world", resultado2);
        }
    @Test
    public void alternativeCase6() {
        String resultado2 = K2InvertirLowerUppercase.toAlternativeString("12345");
        assertEquals("12345", resultado2);
    }
    @Test
    public void alternativeCase7() {
        String resultado2 = K2InvertirLowerUppercase.toAlternativeString("1a2b3c4d5e");
        assertEquals("1A2B3C4D5E", resultado2);
    }
}