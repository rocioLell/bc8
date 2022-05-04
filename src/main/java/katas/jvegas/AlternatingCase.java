package katas.jvegas;

import java.util.ArrayList;

public class AlternatingCase {
    //   0- leer el string "hello world"
    //   1- distinguir si es mayuscula o minuscula
    //   2- entonces si es mayuscula -> minuscula, si es minuscula -> mayuscula
    //   3- retornar el resultado string

    public static String toAlternativeString(String palabraNueva) {
        // Convertir string a char
        char[] caracteres = palabraNueva.toCharArray(); // ["h", "o", "l","a"," ","M","U","N","D","O"]

        // Crear un nuevo array dinamico
        ArrayList<String> nuevaPalabraInvertida = new ArrayList<>();

        for(int i = 0; i < caracteres.length; i++){

            if(Character.isUpperCase(caracteres[i])){
                nuevaPalabraInvertida.add(Character.toString(caracteres[i]).toLowerCase());
            }else{
                nuevaPalabraInvertida.add(Character.toString(caracteres[i]).toUpperCase());
            };
        };

        String nuevoStringConvertido = String.join("", nuevaPalabraInvertida);
        return nuevoStringConvertido;
    }
}
