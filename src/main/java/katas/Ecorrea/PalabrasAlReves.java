
package katas.Ecorrea;



public class PalabrasAlReves {
    public static String pinvertida(String str){
        String words[]=str.split("\\s");
        String pinvertida="";
        for(String w:words){
            StringBuilder sb=new StringBuilder(w);
            sb.reverse();
            pinvertida+=sb.toString()+" ";
        }
        return pinvertida.trim();
    }
}

