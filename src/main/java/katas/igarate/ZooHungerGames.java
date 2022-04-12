package katas.igarate;

import java.util.ArrayList;
import java.util.List;

// ultimo kata

public class ZooHungerGames {
    private static final List<Object[]> animalData = new ArrayList<>();

    static {
        animalData.add(new Object[] {"antelope", "grass"});
        animalData.add(new Object[] {"big-fish", "little-fish"});
        animalData.add(new Object[] {"bug", "leaves"});
        animalData.add(new Object[] {"bear", "big-fish", "bug", "chicken", "cow", "leaves", "sheep" });
        animalData.add(new Object[] {"chicken", "bug"});
        animalData.add(new Object[] {"cow", "grass"});
        animalData.add(new Object[] {"fox", "chicken", "sheep"});
        animalData.add(new Object[] {"giraffe", "leaves"});
        animalData.add(new Object[] {"lion", "antelope", });
        animalData.add(new Object[] {"panda", "leaves"});
        animalData.add(new Object[] {"sheep", "grass"});
    }

    public static String[] whoEatsWho(final String zoo) {
        List<Object[]> a = animalData;
        ArrayList<String> zooData = new ArrayList<String>();
        String[] zooList = zoo.split(",");
        boolean animalFind = false;
        boolean animalAte = false;
        String lastAnimal = "";
        for (String z:zooList) {
            zooData.add(z);
        }
        zoo.split(",");
        String animalEat= "";
        ArrayList<String> newZoo = new ArrayList<String>();
        newZoo.add(zoo);
        while(zooData.size()>1){
        for (int i = 0; i <zooData.size() ; i++) {
            for (int j = 0; j < a.size(); j++) {
                Object animal = a.get(j)[0];
                if(animal.equals(zooData.get(i))){
                    animalFind = true;
                    lastAnimal = (String) animal;
                    for (int k = 1; k < a.get(j).length ; k++) {
                        Object eat = a.get(j)[k];
                        if(i-1 != -1){
                            if (zooData.get(i - 1).equals(eat)){
                                animalEat += animal + " eats " + eat;
                                newZoo.add(animalEat);
                                zooData.remove(eat);
                                animalEat = "";
                                animalAte = true;
                            }
                        }
                        else if(zooData.size()>1) {
                           if (zooData.get(i + 1).equals(eat)) {
                            animalEat += animal + " eats " + eat;
                            newZoo.add(animalEat);
                            zooData.remove(eat);
                            animalEat = "";
                            animalAte = true;
                           }
                        }
                        /*else {
                            //newZoo.add((String) animal);
                        }*/
                    }
                }
                else if (animalFind){
                    animalFind =false;
                    if (animalAte){
                        i = -1;
                        animalAte = false;
                    }
                    break;
                    }
                }
            }
        }
        newZoo.add(lastAnimal);





        String[] newZooArray = new String[newZoo.size()];
        for (int i = 0; i < newZoo.size(); i++) {
            newZooArray[i] = newZoo.get(i);
        }

        return newZooArray;
    }

}
