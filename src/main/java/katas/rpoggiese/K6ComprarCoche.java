
/* Let us begin with an example:

A man has a rather old car being worth $2000. He saw a secondhand car being worth $8000.
He wants to keep his old car until he can buy the secondhand one.
He thinks he can save $1000 each month but the prices of his old car and of the new one decrease of 1.5 percent per month.
Furthermore this percent of loss increases of 0.5 percent at the end of every two months.
Our man finds it difficult to make all these calculations.
Can you help him?
How many months will it take him to save up enough money to buy the car he wants,
and how much money will he have left over? */

package katas.rpoggiese;

public class K6ComprarCoche {

    public static int[] nbMeses(int precioInicialViejo, int precioInicialNuevo, int guardaPorMes, double porcentajePorMes) {
        int contadorMes= 0;
        double guardadoTotal = 0;
        double porcen = porcentajePorMes;
        double diferenc = precioInicialViejo - precioInicialNuevo;
        int[] guardar;
        if (diferenc >= 0){
            guardar = new int[]{contadorMes, (precioInicialViejo - precioInicialNuevo)};
            return guardar;
        }
        else{
            while (guardadoTotal <= 0 ){
                contadorMes++;
                if (contadorMes % 2 == 0){
                    porcen +=0.5;
                }
                diferenc *= (1 - porcen /   100);
                guardadoTotal = contadorMes * guardaPorMes + diferenc;
            }}
        guardar = new int[]{contadorMes, (int) Math.round(guardadoTotal)};
        return guardar;
    }
}
