package katas.jvegas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class UnluckyDays {
    public static int DiasMalaSuerte(int year){
        int countDays = 0;

        for (int i = 1; i < 13; i++){
            LocalDate localDate
                    = LocalDate.of(year, i, 13);

            DayOfWeek day
                    = DayOfWeek.from(localDate);

            if (day.name() == "FRIDAY"){
                countDays++;
            }
        }
        return countDays;
    }
}
