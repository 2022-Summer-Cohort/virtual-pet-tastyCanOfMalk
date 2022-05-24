package virtual_pet;

import java.util.Random;

public class VirtualPet {
    private String name;
    private int age;
    private String type;
    private int maxAge;
    private boolean pooped = false;
    private boolean dead = false;
    private String barkNoise;
    private boolean wantsToPlay = false;
    private boolean wantsPet = false;
    private boolean corpseHere = false;

    public VirtualPet(String name, int age, String type, String barkNoise, int maxAge) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.barkNoise = barkNoise;
        this.maxAge = maxAge;
    }

    public void introduce(){
        System.out.println("Meet " + this.name + ", a " + this.age + " year old " + this.type);
    }

    public void petStatus(){
        if(dead) {
            System.out.println(this.name + " is dead.");
        } else if(pooped){
            System.out.println("There is a mess to clean...");
        } else if(wantsPet) {
            System.out.println("Someone wants to be pet...");
        } else if(wantsToPlay) {
            System.out.println("Someone wants to play!");
        } else {
            System.out.println(this.name + " is happy!");
        }
    }
    public void bark(){
        if(!dead){
            System.out.println(barkNoise);
        } else {
            System.out.println("Dead animals can't talk :(");
        }
    }

    public void nap(){
        if(!dead){
            System.out.println(name + " is napping!");
        } else {
            System.out.println(this.name + " is napping (forever) :(");
        }
    }

    public void pet(){
        if(dead && corpseHere){
            System.out.println("You pet a corpse.");
        } else if (dead){
            System.out.println("Nothing to pet..");
        } else if (wantsPet){
            wantsPet = false;
            System.out.println("You pet " + this.name + ", they liked it!");
        } else if (pooped){
            System.out.println("You can't pet " + this.name + " right now,");
        } else {
            System.out.println("You try to pet " + this.name + ", but they bit you!");
            pooped = true;
        }
    }

    public void play(){
        if(dead && corpseHere){
            System.out.println("You play with a corpse!");
        } else if (dead){
            System.out.println("Nothing to play with :(");
        } else if(wantsToPlay && !pooped){
            wantsToPlay = false;
            System.out.println("You played with " + this.name + ", they liked it!");
        } else if (pooped){
            System.out.println("You can't play with " + this.name + " right now,");
        } else {
            System.out.println("You try to play with " + this.name + ", but they bit you!");
            pooped = true;
        }
    }
    public void cleanPoop(){
        if(corpseHere){
            System.out.println("You cleaned up a corpse!");
            corpseHere = false;
        } else if (pooped){
            System.out.println("You cleaned up the mess, good job!");
            pooped = false;

            Random rand = new Random();
            int n = rand.nextInt(10);
            if(n <= 3){
                wantsPet = true;
            } else if (n <= 6){
                wantsToPlay = true;
            } else {
                this.nap();
            }
        } else if (pooped){
            System.out.println("You can't do that right now.. ");
        } else {
            System.out.println("Nothing to clean!");
        }
    }
    public void tick(){
        if(pooped && !dead ){
            System.out.println(this.name + " needs you.");
        } else if(dead){
            System.out.println("Time goes on without " + this.name + " :(");
        } else if(wantsPet){
            System.out.println("You have to pet " + this.name + "!");
        } else if (wantsToPlay){
            System.out.println("You have to play with " + this.name + "!");
        } else {
            age++;
            Random rand = new Random();
            int n = rand.nextInt(10);

            if(age >= maxAge){
                System.out.println("Oh no! " + this.name + " has died of old age :(");
                corpseHere = true;
                dead = true;
            } else if (n <= 3){
                System.out.println(this.name + " is now " + this.age + " years old now...");
                System.out.println(barkNoise + " " + barkNoise + " " + barkNoise);
//                System.out.println(this.name + " wants to play, you better play with him!");
                wantsToPlay = true;
                if(n <=2){
                    pooped = true;
                }
            } else if (n <= 6){
                System.out.println(this.name + " is now " + this.age + " years old now...");
                System.out.printf(barkNoise + " ");
//                System.out.println(this.name + " wants you to pet them!");
                wantsPet = true;
                if(n <= 4){
                    pooped = true;
                }
            } else if (n <= 10){
                System.out.println(this.name + " is now " + this.age + " years old now...");
                this.nap();
                pooped = true;
            } else {
                System.out.println("Error");
            }



        }

    }


}
