package Application;

import java.util.Random;

public class Devinette {
    private static Integer target = 0;
    private static Integer input = 5;
    private static String reponse = "Bonne chance!";

    public Devinette() {
        setTarget(randInt(0,20));
        System.out.println("target "+target);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


    public static void comparer(){

        if (input<target){
            System.out.println(plusPetit());
            reponse = plusPetit();
        }
        else if (input > target){
            System.out.println(plusGrand());
            reponse = plusGrand();
        }
        else {System.out.println(bonneReponse());
        reponse = bonneReponse();
        }
    }

// return réponse plus grand plus petit bonne reponse
    protected static String plusPetit(){
            return "Votre choix "+input+" est plus petit que target";
    }

    protected static String plusGrand(){
        return "Votre choix "+input+" est input plus grand que target";
    }

    protected static String bonneReponse(){
        return "Votre choix "+input+" est la Bonne réponse !! Félicitation";
    }



    // getters setters
    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}
