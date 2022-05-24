package virtual_pet;

import java.util.Random;

public class VirtualPet {
    private String name;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;
    private boolean hungry, thirsty, bored, poop = false;
    private boolean runAway = false;
    Random rand = new Random();

    public VirtualPet(String name, int hungerLevel, int thirstLevel, int boredomLevel) {
        this.name = name;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
    }
    public int getHungerLevel() {
        return hungerLevel;
    }
    public int getThirstLevel() {
        return thirstLevel;
    }
    public int getBoredomLevel() {
        return boredomLevel;
    }
    public boolean getRunAwayStatus(){
        return runAway;
    }
    public void feed(){
        if(hungerLevel >= 0 ) {
            int n = rand.nextInt(10);
            if (hungerLevel > 2 && (2 % n == 0)) {
                this.hungerLevel -= 2;
            } else {
                this.hungerLevel--;
            }
        } else  if(hungerLevel < 0){ this.hungerLevel = 0; }
        System.out.println("You fed " + this.name);
    }

    public void water(){
        if(thirstLevel >= 0 ) {
            int n = rand.nextInt(10);
            if (thirstLevel > 2 && (2 % n == 0)) {
                this.thirstLevel -= 2;
            } else {
                this.thirstLevel--;
            }
        } else  if(thirstLevel < 0){ this.thirstLevel = 0; }
        System.out.println("You watered " + this.name);
    }
    public void play(){
        if(boredomLevel >= 0 ) {
            int n = rand.nextInt(10);
            if (boredomLevel > 2 && (2 % n == 0)) {
                this.boredomLevel -= 2;
            } else {
                this.boredomLevel--;
            }
        } else  if(boredomLevel < 0){ this.boredomLevel = 0; }
        System.out.println("You played with " + this.name);
    }
    public void tick(){

        // increase needs
        this.thirstLevel++;
        this.hungerLevel++;
        this.boredomLevel++;

        // warning message if near max
        if(thirstLevel  >= 9){ System.out.println(name + " is thirsty..."); }
        if(hungerLevel  >= 9){ System.out.println(name + " is hungry..."); }
        if(boredomLevel >= 9){ System.out.println(name + " is bored..."); }
        if(poop){ System.out.println(name + " pooped on your shoe."); }

        // reset to max, express urgency
        if(this.thirstLevel  >= 10){ this.thirstLevel  = 10; thirsty = true; }
        if(this.hungerLevel  >= 10){ this.hungerLevel  = 10; hungry = true; }
        if(this.boredomLevel >= 10){ this.boredomLevel = 10; bored = true; }

        if(hungry || thirsty || bored){
            poop = true;
        }

        if(thirsty && bored){
            runAway = true;
            System.out.println(name + " ran away from home, better luck next time.");
        }
    }

    public void status(){
        String hungerBar = "";
        String thirstBar = "";
        String boredomBar = "";

        for(int i = 0; i < hungerLevel; i++){ hungerBar += "*";}
        for(int i = 0; i < thirstLevel; i++){ thirstBar += "*";}
        for(int i = 0; i < boredomLevel; i++){ boredomBar += "*";}

        System.out.println(this.name + "'s status:");
        System.out.println("Hunger  : " + hungerBar);
        System.out.println("Thirst  : " + thirstBar);
        System.out.println("Boredom : " + boredomBar);

        if(poop){
            System.out.println(name + " made a poop.. ");
            poop = false;
        }


    }
}
