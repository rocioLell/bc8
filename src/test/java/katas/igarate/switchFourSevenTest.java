package katas.igarate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//tercer kata
public class switchFourSevenTest {
    @Test
    public void Input7Return4() {
        assertEquals(switchFourSeven.fourSeven(7), 4);

    }
    @Test
    public void Input4Return7() {
        assertEquals(switchFourSeven.fourSeven(4), 7);
    }
    @Test
    public void Input6Return0() {
        assertEquals(switchFourSeven.fourSeven(6), 0);
    }


}

