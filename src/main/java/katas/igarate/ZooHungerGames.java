package katas.igarate;

import java.util.ArrayList;
import java.util.List;

// ultimo kata

public class ZooHungerGames {
    private static final List<Object[]> animalData = new ArrayList<>();

    static {
        animalData.add(new Object[]{"antelope", "grass"});
        animalData.add(new Object[]{"big-fish", "little-fish"});
        animalData.add(new Object[]{"bug", "leaves"});
        animalData.add(new Object[]{"bear", "big-fish", "bug", "chicken", "cow", "leaves", "sheep"});
        animalData.add(new Object[]{"chicken", "bug"});
        animalData.add(new Object[]{"cow", "grass"});
        animalData.add(new Object[]{"fox", "chicken", "sheep"});
        animalData.add(new Object[]{"giraffe", "leaves"});
        animalData.add(new Object[]{"lion", "antelope","cow"});
        animalData.add(new Object[]{"panda", "leaves"});
        animalData.add(new Object[]{"sheep", "grass"});
    }

    public static String[] whoEatsWho(final String zoo) {
        ArrayList<String> zooList = new ArrayList<>();
        String toEat = "";
        boolean eat = false;
        String animalEat = "";
        String findToEat = "";
        String animalToFind = "";
        String animalFind = "";
        ArrayList<String> newZoo = new ArrayList<String>();
        newZoo.add(zoo);
        for (String z : zoo.split(",")) {
            zooList.add(z);
        }
        boolean exit = false;
        while (zooList.size() > 1 && !exit) {
            eat = false;
            for (int i = 0; i < zooList.size(); i++) {
                if (i == 0) { // first animal
                    toEat = zooList.get(i + 1);
                    // find animal
                    animalToFind = zooList.get(i);
                    for (Object[] animal : animalData) {
                        animalFind = (String) animal[0];
                        if (animalFind.equals(animalToFind)) {
                            for (int j = 1; j < animal.length; j++) {
                                findToEat = (String) animal[j];
                                if (findToEat.equals(toEat)) {
                                    zooList.remove(i + 1);
                                    animalEat = animalToFind + " eats " + toEat;
                                    newZoo.add(animalEat);
                                    eat = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                else if (i == zooList.size() - 1) {// last animal
                    toEat = zooList.get(i - 1);
                    // find animal
                    animalToFind = zooList.get(i);
                    for (Object[] animal : animalData) {
                        animalFind = (String) animal[0];
                        if (animalFind.equals(animalToFind)) {
                            for (int j = 1; j < animal.length; j++) {
                                findToEat = (String) animal[j];
                                if (findToEat.equals(toEat)) {
                                    zooList.remove(i - 1);
                                    animalEat = animalToFind + " eats " + toEat;
                                    newZoo.add(animalEat);
                                    eat = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                else {
                    for (int j = 0; j < 2; j++) {
                        if (eat){
                            break;
                        }
                        // eat to left
                        if (j == 0) {
                            toEat = zooList.get(i - 1);
                            // find animal
                            animalToFind = zooList.get(i);
                            for (Object[] animal : animalData) {
                                animalFind = (String) animal[0];
                                if (animalFind.equals(animalToFind)) {
                                    for (int k = 1; k < animal.length; k++) {
                                        findToEat = (String) animal[k];
                                        if (findToEat.equals(toEat)) {
                                            zooList.remove(i - 1);
                                            animalEat = animalToFind + " eats " + toEat;
                                            newZoo.add(animalEat);
                                            eat = true;
                                            break;
                                        }
                                    }
                                }

                            }
                        }
                        // eat to right
                        else {
                            toEat = zooList.get(i + 1);
                            // find animal
                            animalToFind = zooList.get(i);
                            for (Object[] animal : animalData) {
                                animalFind = (String) animal[0];
                                if (animalFind.equals(animalToFind)) {
                                    for (int k = 1; k < animal.length; k++) {
                                        findToEat = (String) animal[k];
                                        if (findToEat.equals(toEat)) {
                                            zooList.remove(i + 1);
                                            animalEat = animalToFind + " eats " + toEat;
                                            newZoo.add(animalEat);
                                            eat = true;
                                            break;
                                        }
                                    }
                                }

                            }
                        }

                    }
                }
                if (eat) {
                    break;
                }
                if (i == zooList.size()-1) {
                    exit = true;
                }
            }

        }
        if (zooList.size() == 1) {
            newZoo.add(zooList.get(0));
        }
        if (zooList.size() > 1 ) {
            StringBuilder zooReturn = new StringBuilder();
            for (int i = 0; i < zooList.size(); i++) {

                if (i == zooList.size() - 1) {
                    zooReturn.append(zooList.get(i));
                } else {
                    zooReturn.append(zooList.get(i)).append(",");
                }

            }
            newZoo.add(String.valueOf(zooReturn));
        }
        String[] newZooArray = new String[newZoo.size()];
        for (int i = 0; i < newZoo.size(); i++) {
            newZooArray[i] = newZoo.get(i);
        }
        return newZooArray;
    }
}
