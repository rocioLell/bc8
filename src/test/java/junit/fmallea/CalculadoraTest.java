package junit.fmallea;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    //variables
    Calculadora calculadoraTest;

   @BeforeClass
   public static void beforeClass(){
       System.out.println("beforeClass");
   }
    @Before
    public void before() {
        System.out.println("Before");
        calculadoraTest = new Calculadora(); // pre condicion
    }


    @Test
    public void testSuma() {
        System.out.println("testSuma");
        int resultado = calculadoraTest.add(3, 2);
        int resultado_esperado = 5;
        assertEquals(resultado_esperado, resultado);
    }

    @Test
    public void testAnsSuma() {
        System.out.println("testAnsSuma");
        calculadoraTest.add(3, 2);
        int resultado = calculadoraTest.ans();
        int resultado_esperado = 5;
        assertEquals(resultado_esperado, resultado);
    }

    @After
    public void after (){
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }
}