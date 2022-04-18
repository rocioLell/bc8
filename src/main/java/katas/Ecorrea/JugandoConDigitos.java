package katas.Ecorrea;

public class JugandoConDigitos {
    public static long digPow(int n, int p) {
        long temp = 0;
        String[] value = String.valueOf(n).split("");
        for (int i = 0; i < value.length; i++) {
            temp += Math.pow(Double.parseDouble(value[i]), (p + i));
        }
        return temp % n == 0 ? temp / n : -1;
    }

    // g964's solution
    public static long otherDigPow1(int n, int p) {
        long s = 0;
        String nstr = String.valueOf(n);
        for (int i = 0; i < nstr.length(); i++) {
            s += (long)Math.pow(nstr.charAt(i) -'0', p+i);
        }
        if (s % n == 0)
            return s / n;
        else return -1;
    }

    // teff's solution
    public static long otherDigPow2(int n, int p) {
        String intString = String.valueOf(n);
        long sum = 0;
        for (int i = 0; i < intString.length(); ++i, ++p)
            sum += Math.pow(Character.getNumericValue(intString.charAt(i)), p);
        return (sum % n == 0) ? sum / n : -1;
    }
}