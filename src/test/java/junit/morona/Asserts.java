package junit.morona;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class Asserts {
    @Test
    public void numeros(){
        //enteros
        //assertEquals(4,4);
        //assertNotEquals(4,3);
        //float - decimales
        assertEquals(2.56,2.55,0.02);

    }
    @Test
    public void cadena(){
        String s1 = "Bootcamp";
        String s2 = "Tsoft";
        assertEquals(s1,s1);
        assertNotEquals(s2,s1);
    }
    @Test
    public void arrays(){
        //String array1 [];
        //array1= new String[10];
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String elementoArray=""+(i+1);
            arrayList1.add(elementoArray);
            arrayList2.add(elementoArray);
        }
        //convertir arraylist a array
        String[] arrayPrimitivo = arrayList1.toArray(new String[arrayList1.size()]);
        String[] arrayPrimitivo2 = arrayList2.toArray(new String[arrayList1.size()]);
        System.out.println(arrayPrimitivo);
        System.out.println(arrayPrimitivo2);

        assertArrayEquals(arrayPrimitivo,arrayPrimitivo2);
        assertEquals(arrayList1,arrayList2);



    }
    @Test
    public void objetos(){
        Date objetoFecha1 = new Date();
        System.out.println(objetoFecha1.toString());
        Date objetoFecha2 = new Date();
        System.out.println(objetoFecha2.toString());
        //assertEquals(); compara estructura
        assertNotSame(objetoFecha1,objetoFecha2);//compara posiciones de memoria
    }

}
