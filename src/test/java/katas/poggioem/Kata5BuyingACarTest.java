package katas.poggioem;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Kata5BuyingACarTest {
        @Test
        public void test1() {
            int[] r = new int[] { 6, 766 };
            assertArrayEquals(r, Kata5BuyingACar.BCMonths(2000, 8000, 1000, 1.5));
        }
        @Test
        public void test2() {
            int[] r = new int[] { 0, 4000 };
            assertArrayEquals(r, Kata5BuyingACar.BCMonths(12000, 8000, 1000, 1.5));
        }
    }

