package junit.morona;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
@RunWith(value = Parameterized.class)
public class TestParametrizados {
    //pruebas para realizar a la multiplicacion
    private int num1,num2,resultado_esperado;
    //construcctor
    public TestParametrizados(int num1,int num2, int resultado_esperado){
        this.num1 =num1;
        this.num2 = num2;
        this.resultado_esperado= resultado_esperado;

    }
    //funcion para obtener los datos
    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> datosParametrizados = new ArrayList<>();
        datosParametrizados.add(new Object[]{5,5,25});
        datosParametrizados.add(new Object[]{5,-5,-25});
        datosParametrizados.add(new Object[]{-5,5,-25});
        datosParametrizados.add(new Object[]{-5,-5,25});
        return datosParametrizados;
    }

    @Test
    public void validacionSignosMultiplicacion(){
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicar(num1,num2);
        assertEquals(resultado_esperado,resultado);
    }
}
