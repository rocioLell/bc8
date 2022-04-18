package katas.poggioem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Kata8PlayingWithDigitsTest {

    @Test
    public void Test1() {
        assertEquals(1, Kata8PlayingWithDigits.playingWithDigits(89, 1));
    }
    @Test
    public void Test2() {
        assertEquals(-1, Kata8PlayingWithDigits.playingWithDigits(92, 1));
    }
    @Test
    public void Test3() {
        assertEquals(51, Kata8PlayingWithDigits.playingWithDigits(46288, 3));
    }
}