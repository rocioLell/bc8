package katas.igarate;
//sexto kata
public class BuyCar {
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int monthCount= 0;
        double totalSave = 0;
        double percentDep = percentLossByMonth;
        double diff = startPriceOld - startPriceNew;
        int[] save;
        if (diff >= 0){
            save = new int[]{monthCount, (startPriceOld - startPriceNew)};
            return save;
        }
        else{
        while (totalSave <= 0 ){
            monthCount++;
            if (monthCount % 2 == 0){
                percentDep +=0.5;
            }
            diff *= (1 - percentDep /   100);
            totalSave = monthCount * savingperMonth + diff;
        }}
        save = new int[]{monthCount, (int) Math.round(totalSave)};
        return save;
    }
}