package katas.rhende;

import static org.junit.Assert.*;

import katas.igarate.ZooHungerGames;
import org.junit.Test;


public class ZooHungerGamesTest {

    ZooHungerGames objectTest = new ZooHungerGames();

    @Test
    public void zooTest() {
        final String input = "fox,bug,chicken,grass,sheep";
        final String[] expected = 	{
                "fox,bug,chicken,grass,sheep",
                "chicken eats bug",
                "fox eats chicken",
                "sheep eats grass",
                "fox eats sheep",
                "fox"};
        assertArrayEquals(expected, objectTest.whoEatsWho(input));
    }


}
