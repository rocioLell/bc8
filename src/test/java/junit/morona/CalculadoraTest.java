package junit.morona;

import junit.mentoria.Calculadora;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraTest {
    junit.mentoria.Calculadora objetoPrueba;
    @BeforeClass
    public void beforeclass(){
        System.out.println("beforeClass");
    }

    @Before
    public void before(){
        System.out.println("before");
        objetoPrueba = new Calculadora();//Precondicion

    }
    @Test
    public void testSuma(){
        System.out.println("testSuma");
        int resultado = objetoPrueba.add(3,2);
        int resulado_esperado = 5;
        assertEquals(resulado_esperado,resultado);
    }
    @Test
    public void testAnsSuma(){
        System.out.println("testAnsSuma");
        objetoPrueba.add(3,2);
        int resultado = objetoPrueba.ans();
        int resultado_esperado= 5;
        assertEquals(resultado_esperado,resultado);


    }
    @After
    public void after(){
        System.out.println("after");

    }

}
