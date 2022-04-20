package katas.pacevedo;

public class Kata3 {
    public static int fourSeven(int n){
        do {
            while (n == 4) {
                return 7;
            }
            while (n == 7)
                return 4;
        } while ((n == 4) || (n == 7));
        return 0;
    }
}
