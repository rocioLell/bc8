package katas.pacevedo;

import java.util.Calendar;

public class Kata4 {
    public static int unluckyDays(int year) {
        int result = 0;
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 12; i++) {
            cal.set(year, i, 13, 0, 0);
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                result++;
            }

        }
        return result;
    }
}
