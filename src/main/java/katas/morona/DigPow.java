package katas.morona;

class DigPow {

    public static long digPow(int n, int p) {
        long suma = 0;
        String newString = String.valueOf(n);
        for (int i = 0; i < newString.length(); i++) {
            suma += (long)Math.pow((int)(newString.charAt(i) -'0'), p+i);
        }
        if (suma % n == 0)
            return suma / n;
        else return -1;
    }

}