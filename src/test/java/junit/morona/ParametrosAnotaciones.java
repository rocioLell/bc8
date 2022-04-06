package junit.morona;
import org.junit.*;

public class ParametrosAnotaciones {
    @Test(expected = ArithmeticException.class)
    public void errorDivisionCeroTest(){
        int num1 = 20;
        int num2 =0;
        int divCero= num1/num2;
    }
    @Test(timeout = 1200)
    public void testDeTiempoLimite(){
        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
