package katas.rhende;

/*
cuatro siete
Kata simple, reglas simples: su función debe aceptar
las entradas 4y 7. Si 4 se ingresa, la función debe devolver
 7. Si 7 se ingresa, la función debe devolver 4. Cualquier otra
  cosa ingresada como entrada debería devolver 0.
  Solo hay una n   trampa, su función no puede incluir declaraciones if,
   declaraciones de switch o el operador ternario.
Hay algunas formas muy sencillas de responder a este problema,
 pero te animo a que intentes ser lo más creativo posible.
 */
public class switchFourSeven {
    public static int fourSeven(int n) {
        int resultado = 0;

        while (n == 7 || n == 4) {

            while (n == 4) {
                resultado = 7;
                break;
            }
            while (n == 7) {
                resultado = 4;
                break;
            }
            resultado = 0;
            break;
            //return 0;
        }
        resultado = 0;
        return 0;
    }

}
