package katas.poggioem;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class Kata4UnluckyDays {
    public static int unluckyDay (int year) {
        int counter = 0;
        for (int month = 1; month < 13; month++){
            LocalDate date = LocalDate.of(year, month, 13);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.FRIDAY){
                counter ++;
            }
        }
        return counter;
    }
}

