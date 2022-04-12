package katas.igarate;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class blackFridayTest {
//cuarto kata
    @Test
    public void Input2015Exp3() {
        assertEquals(3, blackFriday.unluckyDays(2015));
    }
    @Test
    public void Input1986Exp1() {
        assertEquals(1, blackFriday.unluckyDays(1986));
    }

}
