package katas.poggioem;

public class Kata3return7and4 {
    public static int return7And4 (int str){
        int numero = 0;
while(str==7){
    numero=4;
    break;
}
while(str==4){
    numero=7;
    break;
}
while(str!=4 && str!=7){
    numero=0;
    break;
}
return numero;
    }
}
