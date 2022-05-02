package katas.rpoggiese;

import java.util.Objects;

public class K1PalabrasInversas {

    public static String reverseWords(String str) {

        if (Objects.equals(str, " ")) {
                return str;
        }
        String[] palabras = str.split("\\s");
        StringBuilder pInversa = new StringBuilder();

        for (String C : palabras){
                StringBuilder strBuil = new StringBuilder(C);
                strBuil.reverse();
                pInversa.append(strBuil).append(" ");
        }
        return pInversa.toString().trim();
    }
}
