package pom.earaya.test;

import org.junit.Test;
import pom.earaya.base.JunitBaseTest;
import pom.earaya.page.GoogleHomePage;

public class SearchGoogleTest extends JunitBaseTest {

    GoogleHomePage googleHomePage;

    @Test
    public void busquedaGoogle(){
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.irAHomePage();
        googleHomePage.buscarTexto("TSOFT");
    }
}
