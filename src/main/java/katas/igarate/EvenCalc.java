package katas.igarate;
//septimo kata
public class EvenCalc {
    public static boolean isVeryEvenNumber(int num) {

       int[] dig = Integer.toString(num).chars().map(c -> c-'0').toArray();
       boolean even = false;
       int newNum;
       while(dig.length >= 1){
           newNum = 0;
           if(dig.length == 1){
               even =  dig[0] % 2 == 0? true : false;
               break;
           }
           else{
               for (int i = 0; i <dig.length ; i++) {
                   newNum += dig[i];
               }
               dig = Integer.toString(newNum).chars().map(c -> c-'0').toArray();
           }
       }
        return even;
    }

}
