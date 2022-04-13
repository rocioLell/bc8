package katas.Ecorrea;
import org.junit.Test;

import static org.junit.Assert.*;

public class CasoAlternativoTest {

    @Test
    public void fixedTests() {
        assertEquals("HELLO WORLD", CasoAlternativo. casoAlternado("hello world"));
        assertEquals("hello world", CasoAlternativo. casoAlternado("HELLO WORLD"));
        assertEquals("HELLO world", CasoAlternativo.casoAlternado("hello WORLD"));
        assertEquals("hEllO wOrld", CasoAlternativo. casoAlternado("HeLLo WoRLD"));
        assertEquals("Hello World", CasoAlternativo. casoAlternado(CasoAlternativo. casoAlternado("Hello World")));
        assertEquals("12345", CasoAlternativo. casoAlternado("12345"));
        assertEquals("1A2B3C4D5E", CasoAlternativo. casoAlternado("1a2b3c4d5e"));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", CasoAlternativo. casoAlternado("StringUtils.toAlternatingCase"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", CasoAlternativo. casoAlternado("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", CasoAlternativo. casoAlternado("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", CasoAlternativo. casoAlternado("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", CasoAlternativo. casoAlternado("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}