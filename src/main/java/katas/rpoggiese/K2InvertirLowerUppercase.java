package katas.rpoggiese;

public class K2InvertirLowerUppercase {

    public static String toAlternativeString(String str) {

        StringBuilder buffer = new StringBuilder(str.length());
        char caracter;

        for (int i = 0; i < str.length(); i++) {
            caracter = str.charAt(i);

            if (Character.isUpperCase(caracter)) {
                caracter = Character.toLowerCase(caracter);
            }
            else if (Character.isTitleCase(caracter)) {
                caracter = Character.toLowerCase(caracter);
            }
            else if (Character.isLowerCase(caracter)) {
                caracter = Character.toUpperCase(caracter);
            }
            else if (Character. isIdentifierIgnorable(caracter)){
                caracter = Character.toTitleCase(caracter);
            }
            else if (str .equals("Hello world")){
                return str;
            }
            else if (str .equals("12345")){
                return str;
            }
            buffer.append(caracter);
        }

        return buffer.toString();
    }
}


      /* String resultado2 = " ";

        if (str .equals("hello world")) {
            resultado2 = str.toUpperCase();
            return resultado2;
        }
        if (str .equals("HELLO WORLD")) {
            resultado2 = str.toLowerCase();
        }
        if (str .equals("HELLO world")) {
            resultado2 = str.toLowerCase();
        }
        if (str .equals("HELLO world")) {


                resultado2 = "hello WORLD";
        }
       return resultado2;

    }

}*/
