package katas.rpoggiese;

import katas.rpoggiese.K4MalaSuerte;
import org.junit.Assert;
import org.junit.Test;


public class K4MalaSuerteTest {
    @Test
    public void testSomething() {
        Assert.assertEquals(3, K4MalaSuerte.unluckyDays(2015));
        Assert.assertEquals(1, K4MalaSuerte.unluckyDays(1986));
    }
}
