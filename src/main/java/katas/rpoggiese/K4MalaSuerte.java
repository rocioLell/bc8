package katas.rpoggiese;/*
Friday 13th or Black Friday is considered as unlucky day. Calculate how many unlucky days are in the given year.

Find the number of Friday 13th in the given year.

Input: Year in Gregorian calendar as integer.

Output: Number of Black Fridays in the year as an integer.

Examples:

unluckyDays(2015) == 3
unluckyDays(1986) == 1

*/

import java.time.*;
import java.time.DayOfWeek;

public class K4MalaSuerte {

        public static int unluckyDays(int year) {


            int countDays = 0;
            for (int i = 1; i < 13; i++) {
                LocalDate localDate
                        = LocalDate.of(year, i , 13 );
                DayOfWeek dia
                        = DayOfWeek.from(localDate);

                if (dia.name().equals("FRIDAY")){
                    countDays++;
                }
            }
            return countDays;
        }
}
