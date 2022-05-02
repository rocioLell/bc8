package pom.earaya.runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pom.earaya.test.SearchGoogleTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(SearchGoogleTest.class)
public class JunitRunner {
}
