package katas.igarate;/*
Friday 13th or Black Friday is considered as unlucky day. Calculate how many unlucky days are in the given year.

Find the number of Friday 13th in the given year.

Input: Year in Gregorian calendar as integer.

Output: Number of Black Fridays in the year as an integer.
 */

import java.time.*;
import java.time.DayOfWeek;
//cuarto kata
public class blackFriday {

    public static int unluckyDays(int year) {
       int count = 0;
        for (int i = 1; i <13 ; i++) {
            LocalDate localDate
                    = LocalDate.of(year,
                    i, 13);
            DayOfWeek
                    dia = DayOfWeek.from(localDate);

            if(dia.name() == "FRIDAY"){
                count++;
            }
        }
        return count;
    }

}
