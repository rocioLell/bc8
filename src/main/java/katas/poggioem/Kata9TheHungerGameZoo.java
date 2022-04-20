package katas.poggioem;

public class Kata9TheHungerGameZoo extends Kata9TheHungerGameZooAnimals {
    public static String[] whoEatsWho(final String zoo){
        String[] antelope = {"Grass"};
        String[] bigfish = {"little fish"};
        String[] bug = {"leaves"};
        String[] bear = {"big-fish", "bug","chicken","cow","leaves","sheep"};
        String[] chicken = {"bug"};
        String[] cow = {"Grass"};
        String[] fox = {"chicken","sheep"};
        String[] giraffe = {"leaves"};
        String[] lion = {"antelope", "cow"};
        String[] panda = {"leaves"};
        String[] sheep = {"Grass"};



        return new String[]{zoo, zoo};
    }

}
