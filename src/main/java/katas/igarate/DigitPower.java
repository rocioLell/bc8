package katas.igarate;
//octavo kata
public class DigitPower {
    public static long digPow(int n, int p) {
        int[] dig = Integer.toString(n).chars().map(c -> c-'0').toArray();
        long pow = 0;
        for (int i = 0; i <dig.length ; i++) {
            pow += Math.pow((dig[i]), (p + i));
        }
        return pow % n == 0 ? pow / n : -1;
    }
}
