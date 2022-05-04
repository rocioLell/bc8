package katas.jvegas;

public class ReverseWords {
    public static String palabrasInversas(final String original){
        String word[] = original.split("\\s");
        String reverse = "";

        for (String w:word){
            StringBuilder wSplit = new StringBuilder(w);
            wSplit.reverse();
            reverse += wSplit.toString()+ " ";
        }
        if (word.length == 0){
            return reverse;
        }
        return reverse.trim();
    }
}
