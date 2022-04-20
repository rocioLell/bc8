package katas.morona;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution3Test {
    KataTres objetoTest = new KataTres();
    @Test
    public void exampleTests() {
        assertEquals(objetoTest.fourSeven(7), 4);
        assertEquals(objetoTest.fourSeven(4), 7);
    }
    @Test
    public void exampleTests2(){
        assertEquals(objetoTest.fourSeven(5), 0);
    }
}
