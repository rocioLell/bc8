package katas.poggioem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Kata3return7and4Test {
    @Test
    public void kata3test1() {
        int resultadokata3 = Kata3return7and4.return7And4(7);
        assertEquals(4, resultadokata3);
    }
    @Test
    public void kata3test2(){
        int resultadokata3 = Kata3return7and4.return7And4(4);
        assertEquals(7, resultadokata3);
    }
    @Test
    public void kata3test3(){
        int resultadokata3 = Kata3return7and4.return7And4(5);
        assertEquals(0, resultadokata3);
    }
}
