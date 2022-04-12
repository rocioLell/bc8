package katas.morona;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilsTest {
    StringUtils objectTest = new StringUtils();
    @Test
    public void fixedMayusculasTest(){
        assertEquals("HELLO WORLD", objectTest.toAlternativeString("hello world"));
    }
    @Test
    public void fixedMinusculasTest(){
        assertEquals("hello world", objectTest.toAlternativeString("HELLO WORLD"));
    }
    @Test
    public void fixedAlfanumericoTest(){
        assertEquals("1A2B3C4D5E", objectTest.toAlternativeString("1a2b3c4d5e"));
    }
    @Test
    public void fixedNumericoTest(){
        assertEquals("12345", objectTest.toAlternativeString("12345"));
    }
    @Test
    public void kataTitleTest(){
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", objectTest.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
    }
}
