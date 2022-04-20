package katas.pacevedo;
/**
 *
 @Test
 assertEquals("HELLO WORLD", StringUtils.toAlternativeString("hello world"));
 assertEquals("hello world", StringUtils.toAlternativeString("HELLO WORLD"));
 assertEquals("HELLO world", StringUtils.toAlternativeString("hello WORLD"));
 assertEquals("hEllO wOrld", StringUtils.toAlternativeString("HeLLo WoRLD"));
 assertEquals("Hello World", StringUtils.toAlternativeString(StringUtils.toAlternativeString("Hello World")));
 assertEquals("12345", StringUtils.toAlternativeString("12345"));
 assertEquals("1A2B3C4D5E", StringUtils.toAlternativeString("1a2b3c4d5e"));
 assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", StringUtils.toAlternativeString("StringUtils.toAlternatingCase"));
 }

 @Test
 public void kataTitleTests() {
 assertEquals("ALTerNAtiNG CaSe", StringUtils.toAlternativeString("altERnaTIng cAsE"));
 assertEquals("altERnaTIng cAsE", StringUtils.toAlternativeString("ALTerNAtiNG CaSe"));
 assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", StringUtils.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
 assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", StringUtils.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
 }
 }
 */
public class Kata2 {
    public static String toAlternativeString(String string) {
        String result = "";
        for (int i =0; i < string.length(); i++) {
            String c = Character.toString(string.charAt(i));
            if (c.toUpperCase() == c) {
                result += c.toLowerCase();
            } else {
                result += c.toUpperCase();
            }
        }
        return result;

    }
}
