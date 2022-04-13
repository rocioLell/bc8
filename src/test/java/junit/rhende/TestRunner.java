package junit.rhende;

import junit.earaya.Asserts;
import junit.earaya.CalculadoraTest;
import junit.earaya.ParametrosAnotaciones;
import junit.earaya.TestParametrizados;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestParametrizados.class, ParametrosAnotaciones.class, CalculadoraTest.class, Asserts.class})
public class TestRunner {
}
