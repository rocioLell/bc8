package katas.rpoggiese;/* Contar el número de duplicados

        Escriba la función duplicateCount, que devuelva
        el numero (entero) de letras duplicadas.

        Reglas para ingreso de datos:
        1. distinct case-insensitive
        2. Acepta solo Alfanumericos

        Ejemplos de retornos de la funcion

        "abcde" -> 0 # ningún carácter se repite más de una vez
        "aabbcde" -> 2 # 'a' y 'b'
        "aabBcde" -> 2 # 'a' aparece dos veces y 'b' dos veces (`b` y` B`)
        "indivisibility" -> 1 # 'i' aparece seis veces
        "aA11" -> 2 # 'a' y '1'
        "ABBA" -> 2 # 'A' y 'B' ocurren dos veces
 */

public class CountingDuplicates {

    public static int duplicateCount(String text) {

        //1. guardar String array de caracteres
        char[] stringIngresado = text.toLowerCase().toCharArray();
        int contadorDeCaracteresDuplicados = 0;
        StringBuilder caracteresEncontrados = new StringBuilder();

        //2. comparar los valores del string
        for (int i = 0; i <stringIngresado.length ; i++) { //string 1
            for (int j = i+1; j <stringIngresado.length ; j++) {

                // si los caracteres son iguales lo agregamos
                if(stringIngresado[i]==stringIngresado[j] && !caracteresEncontrados.toString().contains(String.valueOf(stringIngresado[i]))){
                    caracteresEncontrados.append(stringIngresado[i]);
                    contadorDeCaracteresDuplicados++;
                    break;
                }
            }
        }
        return contadorDeCaracteresDuplicados;
    }

}