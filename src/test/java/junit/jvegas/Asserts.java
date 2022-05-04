package junit.jvegas;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class Asserts {

    @Test
    public void numeros(){

        //enteros
        assertEquals(4,4);  //prueba positiva
        assertNotEquals(4,3); //prueba negativa

        //float
        assertEquals(2.56, 2.55, 0.02);
    }

    @Test
    public void cadenas(){
        String s1 = "bootcamp";
        String s2 = "Tsoft";

        assertEquals(s1,s1);
        assertNotEquals(s1,s2);
    }

    @Test
    public void arrays(){


        ArrayList<String> arraylist1 = new ArrayList<>();
        ArrayList<String> arraylist2 = new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            String elementoArray = "" + (i + 1);
            arraylist1.add(elementoArray);
            arraylist2.add(elementoArray);

        }
            //convertir arraylist en array
            String[] arrayPrimitivo1 = arraylist1.toArray(new String[arraylist1.size()]);
            String[] arrayPrimitivo2 = arraylist2.toArray(new String[arraylist1.size()]);
            System.out.println(arrayPrimitivo1);
            System.out.println(arrayPrimitivo2);

            assertEquals(arrayPrimitivo1, arrayPrimitivo2);
        }

        @Test
        public void objetos() throws InterruptedException {
            Date objetoFecha1 = new Date();
            System.out.println(objetoFecha1.toString());
            Date objetoFecha2 = new Date();
            System.out.println(objetoFecha2.toString());

            assertEquals(objetoFecha1.toString(), objetoFecha2.toString());
            assertNotSame(objetoFecha1, objetoFecha2);
        }

}
