package katas.poggioem;

public class Kata6TrainingOnTwoFighters {
        public static String declareAWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
            boolean turn1 = fighter1.name == firstAttacker;
            while (true) {
                if (turn1) {
                    fighter2.health -= fighter1.damagePerAttack;
                    if (fighter2.health <= 0)
                        return fighter1.name;
                } else {
                    fighter1.health -= fighter2.damagePerAttack;
                    if (fighter1.health <= 0)
                        return fighter2.name;
                }
                turn1 = !turn1;
            }
        }
    }

