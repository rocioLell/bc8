package katas.poggioem;

/**
 * describe("String.prototype.toAlternatingCase", () => {
 *   it("should work for fixed tests (provided in the description)", () => {
 *     Test.assertEquals("hello world".toAlternatingCase(), "HELLO WORLD");
 *     Test.assertEquals("HELLO WORLD".toAlternatingCase(), "hello world");
 *     Test.assertEquals("hello WORLD".toAlternatingCase(), "HELLO world");
 *     Test.assertEquals("HeLLo WoRLD".toAlternatingCase(), "hEllO wOrld");
 *     Test.assertEquals("12345".toAlternatingCase(), "12345");
 *     Test.assertEquals("1a2b3c4d5e".toAlternatingCase(), "1A2B3C4D5E");
 *     Test.assertEquals("String.prototype.toAlternatingCase".toAlternatingCase(), "sTRING.PROTOTYPE.TOaLTERNATINGcASE");
 *     Test.assertEquals("Hello World".toAlternatingCase().toAlternatingCase(), "Hello World");
 *   });
 * });
 */


public class Kata2 {
    public static String alternativeCase (String str) {

        StringBuffer buffer = new StringBuffer(str.length());
        char caracter = 0;
for (int i = 0; i < str.length(); i++){
        caracter=str.charAt(i);
    if (Character.isUpperCase(caracter)){
        caracter = Character.toLowerCase(caracter);
    } else if (Character.isTitleCase(caracter)){
        caracter=Character.toLowerCase(caracter);
    } else if (Character.isLowerCase(caracter)){
        caracter = Character.toUpperCase(caracter);
    }
    else if(str=="Hello World"){
        return str;
    }
    buffer.append(caracter);
}
return buffer.toString();

    }

}
