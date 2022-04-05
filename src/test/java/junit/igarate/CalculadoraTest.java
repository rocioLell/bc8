package junit.igarate;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculadoraTest {
    Calculadora calculadoraTest;
    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass");
    }
    @Before
    public void inicialState(){
        calculadoraTest = new Calculadora();
        System.out.println("Before");
    }

    @Test
    public void testSuma(){
        int res = calculadoraTest.add(3,2);
        int resExp = 5;
        assertEquals(resExp, res);
    }
    @Test
    public void testAnsSuma(){
        calculadoraTest.add(3,2);
        int res = calculadoraTest.ans();
        int resExp = 5;
        assertEquals(resExp, res);
    }
    @Test
    public void testResta(){
        int res = calculadoraTest.sub(3,2);
        int resExp = 1;
        assertEquals(resExp, res);
    }
    @Test
    public void testAnsResta(){
        calculadoraTest.sub(3,2);
        int res = calculadoraTest.ans();
        int resExp = 1;
        assertEquals(resExp, res);
    }
    @Test
    public void testMultiplicar(){
        int res = calculadoraTest.multiplicar(3,2);
        int resExp = 6;
        assertEquals(resExp, res);
    }
    @Test
    public void testAnsMultiplicar(){
        calculadoraTest.multiplicar(3,2);
        int res = calculadoraTest.ans();
        int resExp = 6;
        assertEquals(resExp, res);
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass");
    }
    @After
    public void after(){
        System.out.println("After");
    }

}
