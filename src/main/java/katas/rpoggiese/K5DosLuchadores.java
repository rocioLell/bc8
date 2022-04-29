package katas.rpoggiese;/*
* Crea una función que devuelva el nombre del ganador en una pelea entre dos luchadores.

         Cada luchador se turna para atacar al otro y el que mata al otro primero sale victorioso.
         La muerte se define como tener salud <= 0.

         Cada luchador será un objeto/instancia de luchador.
         Vea la clase Fighter a continuación en su idioma elegido.

         Tanto la salud como el daño por ataque (damage_per_attack para python) serán números enteros mayores que 0.
         Puedes mutar los objetos Fighter.
* */

public class K5DosLuchadores {

    public static String declareWinner(Luchador luchador1, Luchador luchador2, String firstAttacker) {

        if (firstAttacker.equals(luchador2.name)) {

            while (luchador1.health > 0 && luchador2.health > 0) {
                luchador1.health = luchador1.health - luchador2.damagePerAttack;
                if (luchador1.health <= 0) return luchador2.name;
                luchador2.health = luchador2.health - luchador1.damagePerAttack;
                if (luchador2.health <= 0) return luchador1.name;
            }
        } else {
            while (luchador1.health > 0 && luchador2.health > 0) {
                luchador2.health = luchador2.health - luchador1.damagePerAttack;
                if (luchador2.health <= 0) return luchador1.name;
                luchador1.health = luchador1.health - luchador2.damagePerAttack;
                if (luchador1.health <= 0) return luchador2.name;
            }
        }
        return "";
    }

  /*  public static void main(String[] args) {
        Luchador hombre1 = new Luchador("Lew", 10, 2);
        Luchador hombre2 = new Luchador("Harry", 5, 4);

        System.out.println(declareWinner(hombre1, hombre2));

    }*/
}