package junit.epoggio;
import org.junit.*;
import static org.junit.Assert.assertEquals;
public class CalculadoraTest {

    Calculadora objSuma;


    @BeforeClass


    @Before
    public void before(){
        objSuma = new Calculadora();
    System.out.println("Before");

    //Objetos o elementos de pre condicion para nuestros test.
    }



    @Test
    public void sumaTest(){
        assertEquals(5,objSuma.add(3,2));
    }
    @Test
    public void sumaAnsTest(){
         objSuma = new Calculadora();
        objSuma.add(3,2);
        assertEquals(5, objSuma.ans());
    }
    @After
    public void after(){
        System.out.println("After");

    }

}
