package katas.poggioem;

public class Kata5BuyingACar {

    //public static final double LOSS_PERCENT_INCREASE = 0.5;

    public static int[] BCMonths(int startPriceOld, int startPriceNew, int savingPerMonth, double percentLossByMonth) {
        double lossPercentIncrease = 0.5;
        int months = 0;
        double moneyLeft = 0;
        double priceOld = startPriceOld;
        double priceNew = startPriceNew;
        double savings = 0;

        while ((priceOld + savings) < priceNew){
            months++;

            if (months % 2 == 0) {
                percentLossByMonth = percentLossByMonth + lossPercentIncrease;
            }

            priceOld = priceOld - priceOld * (percentLossByMonth / 100);
            priceNew = priceNew - priceNew * (percentLossByMonth / 100);
            savings = savings + savingPerMonth;
        }

        moneyLeft = (savings + priceOld) - priceNew;

        return new int[]{months, (int) Math.round(moneyLeft)};
    }

}

