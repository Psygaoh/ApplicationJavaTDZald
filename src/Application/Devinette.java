package Application;

import java.util.Random;

public class Devinette {
    private Integer target = 0;
    private Integer input = 5;
    private String reponse = "Bonne chance!";

    public Devinette() {
        setTarget(randInt(0,20));
        System.out.println(target);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


    public void comparer(){

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
    protected String plusPetit(){
            return "input plus petit que target";
    }

    protected String plusGrand(){
        return "input plus grand que target";
    }

    protected String bonneReponse(){
        return "input = target, bonne réponse";
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
