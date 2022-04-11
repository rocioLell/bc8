package katas.igarate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
//octavo kata
@RunWith(value = Parameterized.class)
public class DigitPowerTest {

    private final int n;
    private final int p;
    private final int k;


    public DigitPowerTest(int n, int p, int k){
        this.n = n;
        this.p = p;
        this.k = k;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> digPowData = new ArrayList<>();
        digPowData.add(new Object[] {89, 1, 1});
        digPowData.add(new Object[] {92, 1, -1});
        digPowData.add(new Object[] {46288, 3, 51});
        digPowData.add(new Object[] {695, 2, 2});
        digPowData.add(new Object[] {695, 0, -1});
        digPowData.add(new Object[] {1000, 1, -1});
        digPowData.add(new Object[] {9, 2, 9});
        digPowData.add(new Object[] {10, 2, -1});
        return digPowData;
    }



    DigitPower objectTest = new DigitPower();
    @Test
    public void digPowValidation(){
        assertEquals(k, objectTest.digPow(n,p));
    }
}
