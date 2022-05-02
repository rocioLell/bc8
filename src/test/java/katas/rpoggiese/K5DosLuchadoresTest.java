package katas.rpoggiese;/*
Create a function that returns the name of the winner in a fight between two fighters.

        Each fighter takes turns attacking the other and whoever kills the other first is victorious.
        Death is defined as having health <= 0.

        Each fighter will be a Fighter object/instance.
        See the Fighter class below in your chosen language.

        Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0.
        You can mutate the Fighter objects.
*/


import katas.rpoggiese.K5DosLuchadores;
import katas.rpoggiese.Luchador;
import org.junit.Test;
import static org.junit.Assert.*;

public class K5DosLuchadoresTest {

    @Test
    public void Luchadores1() {
        String resultadoPelea = K5DosLuchadores.declareWinner( new Luchador("Lew", 10, 2),new Luchador("Harry", 5, 4),"Lew" );
        assertEquals("Lew", resultadoPelea);
    }
}
