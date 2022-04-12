package junit.morona;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestParametrizados.class,ParametrosAnotaciones.class,CalculadoraTest.class,Asserts.class})
public class TestRunner {

}
