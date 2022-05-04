package katas.jvegas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FourSevenTest {
    @Test
    public void kata3test1() {
        int resultadokata3 = FourSeven.fourSeven(7);
        assertEquals(4, resultadokata3);
    }
    @Test
    public void kata3test2(){
        int resultadokata3 = FourSeven.fourSeven(4);
        assertEquals(7, resultadokata3);
    }
    @Test
    public void kata3test3(){
        int resultadokata3 = FourSeven.fourSeven(5);
        assertEquals(0, resultadokata3);
    }
}
