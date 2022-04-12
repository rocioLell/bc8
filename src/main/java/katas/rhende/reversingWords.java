package katas.rhende;

public class reversingWords
{
    public static String reversingWords(String original)
    {
        char [] textoIngresado = original.toCharArray();
        String palabraInvertida ="";
        for (int i = 0; i < original.length(); i--) {
            palabraInvertida = palabraInvertida + textoIngresado[i];

        }return original;
    }
}