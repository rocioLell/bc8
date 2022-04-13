package katas.morona;

import org.junit.Test;

import static org.junit.Assert.assertEquals;



    public class SolutionCuatroTest {
        KataCuatro objetoTest = new KataCuatro();
        @Test
        public void testSomething() {
            assertEquals(3, objetoTest.unluckyDays(2015));
            assertEquals(1, objetoTest.unluckyDays(1986));
        }
    }


