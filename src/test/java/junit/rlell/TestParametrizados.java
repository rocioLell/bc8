package junit.rlell;

import  static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class TestParametrizados {


    /* Pruebas a realizar para metodo Multiplicacion
            +*+ = + -> 5,5,25 -> num1, num2, resultado esperado
            +*- =  - -> 5,-5,-25
            -*+ = -> -5,5,-25
            -*- = -> -5,-5-25
     */

    private final int num1;
    private  final  int num2;
    private final int resultado_esperado;

    //Constructor de Clase
    public TestParametrizados(int num1, int num2, int resultado_esperado){
        this.num1 =num1;
        this.num2 =num2;
        this.resultado_esperado = resultado_esperado;

}

// funcion para obtener los datos

    @Parameterized.Parameters
    public static Iterable<Object[]>getData(){
        List<Object[]> datosParametrizados = new ArrayList<>();
        datosParametrizados.add(new Object[] {5,5,25} );
        datosParametrizados.add(new Object[] {5,-5,-25} );
        datosParametrizados.add(new Object[] {-5,5,-25} );
        datosParametrizados.add(new Object[] {-5,-5,25} );
        return datosParametrizados;
    }


    @Test
    public void validacionSignosMultiplicacion(){
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicar(num1,num2);
        assertEquals(resultado_esperado,resultado);
    }


}
