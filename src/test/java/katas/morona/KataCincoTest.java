package katas.morona;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class KataCincoTest {
    KataCinco pruebasDePeleas = new KataCinco();
    @Test
    public void basicTests() {
        assertEquals("Lew", pruebasDePeleas.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", pruebasDePeleas.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", pruebasDePeleas.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", pruebasDePeleas.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", pruebasDePeleas.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", pruebasDePeleas.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }
    @Test
    public void randomTests() {
        String[] names = {"Willy", "Johnny", "Max", "Lui", "Marco", "Bostin", "Loyd", "Mark", "Cuban", "Lew", "Rocky", "Mario", "David", "Patrick", "Michael"};
        Random r = new Random();
        for (int i = 0; i < 200; i++) {
            String[] name = {names[r.nextInt(names.length)], names[r.nextInt(names.length)]};
            while (name[0].equals(name[1])) {
                name[1] = names[r.nextInt(names.length)];
            }
            int[] health = {r.nextInt(999) + 1, r.nextInt(999) + 1}, damagePerAttack = {r.nextInt(99) + 1, r.nextInt(99) + 1};
            String first = name[r.nextInt(1)];
            assertEquals(solution(new Fighter(name[0], health[0], damagePerAttack[0]), new Fighter(name[1], health[1], damagePerAttack[1]), first), pruebasDePeleas.declareWinner(new Fighter(name[0], health[0], damagePerAttack[0]), new Fighter(name[1], health[1], damagePerAttack[1]), first));
        }
    }
    private String solution(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        while (true) {
            if (fighter1.name.equals(firstAttacker)) {
                fighter2.health -= fighter1.damagePerAttack;
                if (fighter2.health <= 0) return fighter1.name;
                fighter1.health -= fighter2.damagePerAttack;
                if (fighter1.health <= 0) return fighter2.name;
            } else {
                fighter1.health -= fighter2.damagePerAttack;
                if (fighter1.health <= 0) return fighter2.name;
                fighter2.health -= fighter1.damagePerAttack;
                if (fighter2.health <= 0) return fighter1.name;
            }
        }
    }
}



