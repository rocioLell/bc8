package katas.poggioem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Kata7VeryEvenTest {
    @Test
    public void Kata7(){
        assertEquals(true,Kata7VeryEven.VeryEven(0));
        assertEquals(true,Kata7VeryEven.VeryEven(4));
        assertEquals(true,Kata7VeryEven.VeryEven(222));
        assertEquals(true,Kata7VeryEven.VeryEven(24));
        assertEquals(true,Kata7VeryEven.VeryEven(400000220));
        assertEquals(false,Kata7VeryEven.VeryEven(12));
        assertEquals(false,Kata7VeryEven.VeryEven(5));
        assertEquals(false,Kata7VeryEven.VeryEven(45));
        assertEquals(false,Kata7VeryEven.VeryEven(4554));
        assertEquals(false,Kata7VeryEven.VeryEven(1234));
        assertEquals(false,Kata7VeryEven.VeryEven(88));
    }

}
