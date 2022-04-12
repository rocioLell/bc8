package katas.morona;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class SolutionTest {
    @Test
    public void exampleCases() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", Kata.reverseWords("The quick brown fox jumps over the lazy dog."));

    }
    @Test
    public void exampleCase2() {
        assertEquals("elppa", Kata.reverseWords("apple"));
    }
    @Test
    public void exampleCase3(){assertEquals("  ", Kata.reverseWords("  "));}
}