package katas.poggioem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

 public class Kata4UnluckyDaysTest {
     @Test
     public void Kata4Test1() {
         assertEquals(3, Kata4UnluckyDays.unluckyDay(2015));
         assertEquals(1, Kata4UnluckyDays.unluckyDay(1986));


     }
}