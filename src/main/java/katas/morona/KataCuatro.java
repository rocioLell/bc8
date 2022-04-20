package katas.morona;

import java.util.Calendar;
public class KataCuatro {
        public int unluckyDays(int anio) {
            int resultado = 0;
            Calendar calendario = Calendar.getInstance();

            for (int i = 0; i < 12; i++) {
                calendario.set(anio, i, 13, 0, 0);
                if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                    resultado++;
                }
            }
            return resultado;
        }
    }


