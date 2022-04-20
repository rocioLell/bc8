package junit.fmallea.pacevedo;



import junit.pacevedo.Calculadora;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestParametrizados.class,ParametrosAnotaciones.class, Calculadora.class,Asserts.class})
public class TestRunner {
}
