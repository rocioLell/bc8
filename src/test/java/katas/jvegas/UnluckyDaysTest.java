package katas.jvegas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnluckyDaysTest {
    @Test
    public void Input2015Exp3() {
        assertEquals(3, UnluckyDays.DiasMalaSuerte(2015));
    }

    @Test
    public void Input1986Exp1() {
        assertEquals(1, UnluckyDays.DiasMalaSuerte(1986));
    }
}
