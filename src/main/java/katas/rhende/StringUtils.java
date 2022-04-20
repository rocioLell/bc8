package katas.rhende;

/*
StringUtils.toAlternativeString("hello world") == "HELLO WORLD"
StringUtils.toAlternativeString("HELLO WORLD") == "hello world"
StringUtils.toAlternativeString("hello WORLD") == "HELLO world"
StringUtils.toAlternativeString("HeLLo WoRLD") == "hEllO wOrld"
StringUtils.toAlternativeString("12345") == "12345" // Non-alphabetical characters are unaffected
StringUtils.toAlternativeString("1a2b3c4d5e") == "1A2B3C4D5E"
StringUtils.toAlternativeString("StringUtils.toAlternatingCase") == "sTRINGuTILS.TOaLTERNATINGcASE"
 */

public class StringUtils {
    public static String toAlternativeString(String string) {
        char[] car = string.toCharArray();
        StringBuilder caracteresEncontrados = new StringBuilder();


        for(int i = 0; i<string.length(); i++){

            if(Character.isLowerCase(car[i])){
                caracteresEncontrados.append(Character.toUpperCase(car[i]));
            }
            else{
                caracteresEncontrados.append(Character.toLowerCase(car[i]));
            }
        }
        String res = caracteresEncontrados.toString();
        return res;
    }
}

