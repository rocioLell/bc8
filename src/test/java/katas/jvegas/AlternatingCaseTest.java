package katas.jvegas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AlternatingCaseTest {

    @Test
    public void  toUpperCase(){
        assertEquals("HELLO WORLD", AlternatingCase.toAlternativeString("hello world"));
    }
    @Test
    public void  toLowerCase(){
        assertEquals("hello world", AlternatingCase.toAlternativeString("HELLO WORLD"));
    }

    @Test
    public void  toUtoL(){
        assertEquals("HELLO world", AlternatingCase.toAlternativeString("hello WORLD"));
    }
    @Test

    public void  mixingCase(){
        assertEquals("hEllO wOrld", AlternatingCase.toAlternativeString("HeLLo WoRLD"));
    }
    @Test

    public void  capitalizeAndNesting(){
        assertEquals("Hello World", AlternatingCase.toAlternativeString(AlternatingCase.toAlternativeString("Hello World")));
    }

    @Test
    public void  numbers(){
        assertEquals("12345", AlternatingCase.toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", AlternatingCase.toAlternativeString("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", AlternatingCase.toAlternativeString("StringUtils.toAlternatingCase"));
    }

    @Test
    public void  numbersAndLettersToL(){
        assertEquals("1A2B3C4D5E", AlternatingCase.toAlternativeString("1a2b3c4d5e"));
    }

    @Test
    public void  Large(){
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", AlternatingCase.toAlternativeString("StringUtils.toAlternatingCase"));
    }
}
