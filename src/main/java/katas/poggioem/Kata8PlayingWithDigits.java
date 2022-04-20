package katas.poggioem;

public class Kata8PlayingWithDigits {
    public static int playingWithDigits (int num, int p){
        int counter = 0;
        int square = 0;
        String number = String.valueOf(num);
        char[] characters = number.toCharArray();

        for (int i = 0; i < characters.length ; i++) {
            square = Character.getNumericValue(characters[i]);
            counter = (int) (counter + Math.pow(square, p));
            p++;
            }
        if (counter % num == 0){
            return (counter/num);
        }
        else{
            return(-1);
        }
    }

}
