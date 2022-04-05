package junit.igarate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class Asserts {

    @Test
    public void numeros(){

        //enteros
        assertEquals(4,4);
        assertNotEquals(4,3); //negativa
        //float - decimales
        assertEquals(2.56,2.55,0.02);

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

        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            String elementoArray = ""+(i+1);
            arrayList1.add(elementoArray);
            arrayList2.add(elementoArray);
        }

        //Convertir ArrayList en Array
        String[] arrayPrimitivo1 = arrayList1.toArray(new String[arrayList1.size()]);
        String[] arrayPrimitivo2 = arrayList2.toArray(new String[arrayList2.size()]);
        System.out.println(arrayPrimitivo1);
        System.out.println(arrayPrimitivo2);

        assertEquals(arrayList1,arrayList2);


    }

    @Test
    public void objetos() throws InterruptedException {
        Date objetoFecha1= new Date();
        System.out.println(objetoFecha1.toString());
        Date objetoFecha2= new Date();
        System.out.println(objetoFecha2.toString());
        //assertEquals(objetoFecha1.toString(),objetoFecha2.toString());
        assertNotSame(objetoFecha1,objetoFecha2);
    }

}
