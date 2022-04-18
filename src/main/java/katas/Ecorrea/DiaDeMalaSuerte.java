package katas.Ecorrea;

import java.time.*;

public class DiaDeMalaSuerte {



    public static int diademalasuerte(int anio){

            LocalDate date = LocalDate.of(anio,1,1);
            int month = date.getMonthValue();
            int count = 0;
            for (int currentMonth = month; currentMonth <= 12; currentMonth++) {
                date = date.withMonth(currentMonth);
                LocalDate firstDay = date.withDayOfMonth(13);
                if(firstDay.getDayOfWeek().toString().equals("FRIDAY")){
                    count++;
                }
            }
            return count;
        }

    }
