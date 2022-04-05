package junit.epoggio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

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
       // assertEquals(s1,s2);
        assertNotEquals(s1,s2);
        // para strings
    }
    @Test
    public void arrays (){
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>(); //declaramos los array como objetos.

        for (int i = 0; i < 10 ; i++) { //llenamos el array
            String elementoArray = "" +(i+1);
            arrayList1.add(elementoArray);
            arrayList2.add(elementoArray);
        }

        //Convertimos el arraylist en array primitivo.
        String [] primitivearray1 = arrayList1.toArray(new String[arrayList1.size()]);
        String [] primitivearray2 = arrayList1.toArray(new String[arrayList1.size()]);
        System.out.println(primitivearray1);
        System.out.println(primitivearray2);

        assertEquals(arrayList1,arrayList2);
    }
    @Test
    public void objetos() throws InterruptedException {
        Date objetoFecha1= new Date();
        System.out.println(objetoFecha1.toString());
        Date objetoFecha2= new Date();
        System.out.println(objetoFecha2.toString());
        //assertEquals(objetoFecha1.toString(),objetoFecha2.toString());
        assertNotSame(objetoFecha1,objetoFecha2); //para objetos es con assertSame o NotSame


    }
}
