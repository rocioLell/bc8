package katas.poggioem;

public class Kata7VeryEven {
    public static boolean VeryEven (int num){

        int res1=0;
        int res2=0;
        boolean even = false;

        String number = String.valueOf(num);
        char[] characters = number.toCharArray();
        for(int i = 0; i < characters.length; i++) {
            res1 =  res1 + Character.getNumericValue(characters[i]);
        }
        String number2 = String.valueOf(res1);
        char[] characters2 = number2.toCharArray();
        for(int i = 0; i < characters2.length; i++) {
            res2 =  res2 + Character.getNumericValue(characters2[i]);
        }
        if (res2 % 2 == 0){
            even = true;
        }
        return even;
    }
}