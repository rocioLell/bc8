package katas.igarate;
//quinto kata
public class Fighters {

    public  String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        String winner = "";
        String turn = firstAttacker;
        while ((fighter1.health > 0 || fighter2.health > 0) && winner.equals("")) {

            if (turn.equals(fighter1.name)){
                fighter2.health -= fighter1.damagePerAttack;
                turn = fighter2.name;
                if(fighter2.health <= 0){
                    winner = fighter1.name;
                }
            }
            else if (turn.equals(fighter2.name)){
                fighter1.health -= fighter2.damagePerAttack;
                turn = fighter1.name;
                if(fighter1.health <= 0){
                    winner = fighter2.name;
                }
            }
        }
        return winner;
    }

}
