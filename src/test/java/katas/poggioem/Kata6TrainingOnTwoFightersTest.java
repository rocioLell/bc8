package katas.poggioem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Kata6TrainingOnTwoFightersTest {

        @Test
        public void Kata5TrainingOnTwoFightersTest() {
            assertEquals("Lew", Kata6TrainingOnTwoFighters.declareAWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
            assertEquals("Harry", Kata6TrainingOnTwoFighters.declareAWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
            assertEquals("Harald", Kata6TrainingOnTwoFighters.declareAWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
            assertEquals("Harald", Kata6TrainingOnTwoFighters.declareAWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
            assertEquals("Harald", Kata6TrainingOnTwoFighters.declareAWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
            assertEquals("Harald", Kata6TrainingOnTwoFighters.declareAWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
        }
    }




