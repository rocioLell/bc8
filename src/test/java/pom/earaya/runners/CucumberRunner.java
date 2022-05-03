package pom.earaya.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/pom/earaya/features"}, //Ruta
        glue = {"pom.earaya.steps", "pom.earaya.base"}, //package
        plugin = {"pretty"},
        tags ="@Regresion"
)
public class CucumberRunner {
}
