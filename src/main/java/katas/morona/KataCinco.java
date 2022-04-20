package katas.morona;

public class KataCinco {
    public String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        if(firstAttacker.equals(fighter1.name)) {
            while(true) {
                fighter2.health -= fighter1.damagePerAttack;
                if(fighter2.health < 1)
                    return fighter1.name;
                fighter1.health -= fighter2.damagePerAttack;
                if(fighter1.health < 1)
                    return fighter2.name;
            }
        }
        else {
            return declareWinner(fighter2, fighter1, firstAttacker);
        }
    }
}



