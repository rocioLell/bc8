package katas.morona;

public class KataSeis {
        public static boolean isVeryEvenNumber(int number) {
            if (number == 0) return true;
            number = number%9;
            if (number == 0) return false;
            return (number%9)%2 == 0;
        }
    }

