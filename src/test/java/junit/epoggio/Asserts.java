package junit.epoggio;

import org.junit.Test;

import static org.junit.Assert.*;

public class Asserts {
    @Test
    public void numero (){
        //enteros
        //assertEquals(4,4);
        assertNotEquals(4,3); //negativa

        //float
        assertEquals(2.56,2.55,0.1);

    }
    @Test
    public void cadenas(){
        String s1 = "Bootcamp";
        String s2 = "TSoft";
        assertEquals(s1,s2);
        assertNotEquals(s1,s2);
    }
    @Test
    public void arrays (){
        String[] array = {"a","b","c"};

    }
}
