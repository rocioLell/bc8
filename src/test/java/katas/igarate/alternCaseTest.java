package katas.igarate;

import org.junit.Test;
import static org.junit.Assert.*;
// segundo kata
public class alternCaseTest {

    @Test
    public void  toUpperCase(){
        assertEquals("HELLO WORLD", alternCase.toAlternativeString("hello world"));

    }
    @Test
    public void  toLowerCase(){
        assertEquals("hello world", alternCase.toAlternativeString("HELLO WORLD"));
    }

    @Test
    public void  toUtoL(){
        assertEquals("HELLO world", alternCase.toAlternativeString("hello WORLD"));

    }
    @Test
    public void  mixingCase(){
        assertEquals("hEllO wOrld", alternCase.toAlternativeString("HeLLo WoRLD"));
    }
    @Test
    public void  capitalizeAndNesting(){
        assertEquals("Hello World", alternCase.toAlternativeString(alternCase.toAlternativeString("Hello World")));
    }
    @Test
    public void  numbers(){
        assertEquals("12345", alternCase.toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", alternCase.toAlternativeString("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", alternCase.toAlternativeString("StringUtils.toAlternatingCase"));
    }
    @Test
    public void  numbersAndLettersToL(){
        assertEquals("1A2B3C4D5E", alternCase.toAlternativeString("1a2b3c4d5e"));
    }
    @Test
    public void  Large(){
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", alternCase.toAlternativeString("StringUtils.toAlternatingCase"));
    }
}
