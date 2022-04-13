package katas.rhende;

import katas.igarate.BuyCar;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
//sexto kata
public class BuyCarTest {
    BuyCar objectTest = new BuyCar();
    @Test
    public void test6Months(){
        int[] r = new int[] { 6, 766 };
        assertArrayEquals(r, objectTest.nbMonths(2000, 8000, 1000, 1.5));
    }
    @Test
    public void test0Months(){
        int[] r = new int[] { 0, 4000 };
        assertArrayEquals(r, objectTest.nbMonths(12000, 8000, 1000, 1.5));
    }
    @Test
    public void test3() {
        int[] r = new int[] { 0, 0 };
        assertArrayEquals(r, objectTest.nbMonths(8000, 8000, 1000, 1.5));
    }
}
