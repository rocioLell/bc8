package katas.morona;

public class StringUtils {
     public static void main(String[] args) {

     }
     public String toAlternativeString(String text){
         String usuario = "";
         usuario = text;
         String auxiliar = "";
         for (int i = 0; i < usuario.length(); i++) {
             if (Character.isLowerCase(usuario.charAt(i))) {
                 auxiliar += Character.toUpperCase(usuario.charAt(i));
             } else {
                 auxiliar += Character.toLowerCase(usuario.charAt(i));
             }
         }
         return auxiliar;
     }
     }