package katas.igarate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
//septimo kata
@RunWith(value = Parameterized.class)
public class EvenCalcTest {

    private final int num;
    private final boolean expc;


    public EvenCalcTest(int num, boolean expc){
        this.num = num;
        this.expc = expc;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> evenData = new ArrayList<>();
        evenData.add(new Object[] {0, true});
        evenData.add(new Object[] {4,true});
        evenData.add(new Object[] {12, false});
        evenData.add(new Object[] {222, true});
        evenData.add(new Object[] {5, false});
        evenData.add(new Object[] {45,false});
        evenData.add(new Object[] {4554, false});
        evenData.add(new Object[] {1234, false});
        evenData.add(new Object[] {88, false});
        evenData.add(new Object[] {24,  true});
        evenData.add(new Object[] {400000220,  true});
        evenData.add(new Object[] {1, false});
        return evenData;
    }

    EvenCalc objectTest = new EvenCalc();
    @Test
    public void veryEvenValidation(){
        assertEquals(num +" is " + (expc ? "" : "not ") + "'Very Even'", expc, objectTest.isVeryEvenNumber(num));
    }

}
