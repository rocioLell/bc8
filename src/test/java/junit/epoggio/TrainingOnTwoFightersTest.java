package junit.epoggio;
import org.junit.*;
import static org.junit.Assert.*;

public class TrainingOnTwoFightersTest {

        @Test
        public void Kata5TrainingOnTwoFightersTest() {
            assertEquals("Lew", TrainingOnTwoFighters.declareAWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
            assertEquals("Harry", TrainingOnTwoFighters.declareAWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
            assertEquals("Harald", TrainingOnTwoFighters.declareAWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
            assertEquals("Harald", TrainingOnTwoFighters.declareAWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
            assertEquals("Harald", TrainingOnTwoFighters.declareAWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
            assertEquals("Harald", TrainingOnTwoFighters.declareAWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
        }
    }




