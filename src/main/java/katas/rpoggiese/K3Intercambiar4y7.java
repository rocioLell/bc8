package katas.rpoggiese;

/* Cuatro Siete
      Kata simple, reglas simples:
      su función debe aceptar las entradas y .
      Si se introduce 7, la función debe devolver 4.
      Si se introduce 4, la función debe devolver 7.
      Cualquier otra cosa introducida como entrada debe devolver .
      Solo hay una captura, su función no puede incluir instrucciones if, instrucciones switch u operador ternario.
      4747740

      Simple kata, simple rules:
       your function should accept the inputs and .
       If is entered, the function should return .
       If is entered, the function should return .
       Anything else entered as input should return .
       There's only one catch, your function cannot include if statements, switch statements, or the ternary operator.
       4747740

*/
public class K3Intercambiar4y7 {
   public static int fourSeven(int n) {

       int nuevoResultado;

           while(n == 7) {
                System.out.println("n es 7");  // No se ejecuta.
                n = 4;
                System.out.println("n ahora es 4");
                break;
           }
           while (n == 4) {
                System.out.println("n es 4");  // No se ejecuta.
                n = 7;
                System.out.println("n ahora es 7");
                break;
           }
           while (n != 7){
                System.out.println("Devuelve Cero");
                n = 0;
                break;
           }
            nuevoResultado = n;
           return nuevoResultado;
   }
}

