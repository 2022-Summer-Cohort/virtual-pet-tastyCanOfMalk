package virtual_pet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class VirtualPet {
    Random rand = new Random();
    String name, type;
    int age, maxAge, hungerLevel, thirstLevel, boredomLevel;
    boolean isBored, isHungry, isThirsty, justPlayed, wantsToEscape = false;
    boolean isAlive = true;
    int hungerCounter, thirstCounter, boredomCounter = 0;
    //        https://cutekaomoji.com/animals/
    ArrayList<String> petFacesNeutral = new ArrayList<>(Arrays.asList("-_-", "(-_-)", "(￣__￣)", "(¯_¯)"));
    ArrayList<String> petFacesTired = new ArrayList<>(Arrays.asList("(¯﹃¯)", " ( v¯﹃¯v  )", " (¯﹃¯  )"));
    ArrayList<String> petFacesNeedy = new ArrayList<>(Arrays.asList("(-‸-)", "(⇀‸↼‶)", " (‾̀ _ ‾̀ )", "╥_╥", "ㄒ_ㄒ", " ┰_┰" ));
    ArrayList<String> petFacesHappy = new ArrayList<>(Arrays.asList("(o ╹‿ ╹ o)", "(o ╹ ᴗ ╹ o)", "(o ╹ᵕ ╹ o)", "(。╹‿ ╹ 。)", "(。╹ ᴗ ╹。)", "(o l ‿ l o)"));

    public VirtualPet(String name, String type, int age, int hungerLevel, int thirstLevel, int boredomLevel) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
        this.maxAge = this.age + 20;
    }

    // GETTERS
    public String getName() { return this.name; }
    public String getType() { return this.type; }
    public int getAge() { return this.age; }
    public int getMaxAge() { return this.maxAge; }
    public boolean getAlive(){ return this.isAlive; }
    public boolean getWantsToEscape() {return this.wantsToEscape; }
    public int getHungerLevel()  { return this.hungerLevel; }
    public int getThirstLevel()  { return this.thirstLevel; }
    public int getBoredomLevel() { return this.boredomLevel; }

    // INCREASE/DECREASE VALUES
    public void increaseBoredomLevel(int n) { this.boredomLevel += n; }
    public void increaseThirstLevel(int n)  { this.thirstLevel  += n; }
    public void increaseHungerLevel(int n)  { this.hungerLevel  += n; }
    public void decreaseBoredomLevel(int n) { this.boredomLevel -= n; }
    public void decreaseThirstLevel(int n)  { this.thirstLevel  -= n; }
    public void decreaseHungerLevel(int n)  { this.hungerLevel  -= n; }

    public void petStatus(){
        System.out.println("<" + this.name + " the " + this.age + " year-old " + this.type + ">");
        System.out.println(" ------- ");
        System.out.println(" Hunger: " + this.getHungerLevel());
        System.out.println(" Thirst: " + this.getThirstLevel());
        System.out.println("Boredom: " + this.getBoredomLevel());
    }

    public void tick(int n){
        // increase levels by rand(n)
        increaseBoredomLevel(rand.nextInt(n)+5);
        increaseHungerLevel (rand.nextInt(n)+2);
        increaseThirstLevel (rand.nextInt(n)+2);
    }
    public void feedPet() throws InterruptedException {
        // decrease hunger, increase thirst
        if(this.hungerLevel >  0){
            this.decreaseHungerLevel(rand.nextInt(10)+3);
            this.increaseThirstLevel(rand.nextInt(3));
        } else {
            System.out.println(" << " + this.name + " isn't hungry! >> ");
            TimeUnit.SECONDS.sleep(1);
        }
    }
    public void waterPet() throws InterruptedException {
        // decrease thirst, increase boredom
        if(this.thirstLevel > 0){
            this.decreaseThirstLevel(rand.nextInt(10)+3);
            this.increaseBoredomLevel(rand.nextInt(3));
        } else {
            System.out.println(" << " + this.name + " isn't thirsty! >> ");
            TimeUnit.SECONDS.sleep(1);
        }
    }
    public void playPet() throws InterruptedException {
        if(isThirsty || isHungry){
            System.out.println(" << " + this.name + " doesn't want to play! >> ");
            TimeUnit.SECONDS.sleep(1);
        } else {
            this.decreaseBoredomLevel(rand.nextInt(10)+5);
            this.increaseThirstLevel(rand.nextInt(8)+1);
            this.increaseHungerLevel(rand.nextInt(5)+1);
            this.justPlayed = true;
        }

    }
    public void checkLevels(){
        if(boredomLevel >= 100){
            boredomLevel = 100;
            isBored = true;
            boredomCounter++;
        } else if (boredomLevel <= 0){
            boredomLevel = 0;
            isBored = false;
        } else {
            isBored = false;
        }
        if(thirstLevel >= 100){
            thirstLevel = 100;
            isThirsty = true;
            thirstCounter++;
        } else if (thirstLevel <= 0){
            thirstLevel = 0;
            isThirsty = false;
        } else {
            isThirsty = false;
        }
        if(hungerLevel >= 100){
            hungerLevel = 100;
            isHungry = true;
            hungerCounter++;
        } else if (hungerLevel <= 0){
            hungerLevel = 0;
            isHungry = false;
        } else {
            isHungry = false;
        }
    }
    public void checkNeeds(){
        if( (!isHungry && !isThirsty && !isBored) && (thirstLevel >= 90 || hungerLevel >= 90 || boredomLevel >= 90) ){
            System.out.println(" -- << " + this.name + " needs attention! > -- ");
            System.out.println(petFacesNeedy.get(rand.nextInt(petFacesNeedy.size())));
        } else if(isHungry) {
            System.out.println(" << " + this.name + " is hungry.. Feed them! >> ");
            System.out.println(petFacesNeedy.get(rand.nextInt(petFacesNeedy.size())));
        } else if(isThirsty){
            System.out.println(" << " + this.name + " is thirsty.. Water them! >> ");
            System.out.println(petFacesNeedy.get(rand.nextInt(petFacesNeedy.size())));
        } else if(isBored)  {
            System.out.println(" << " + this.name + " is bored.. Play with them! >> ");
            System.out.println(petFacesNeedy.get(rand.nextInt(petFacesNeedy.size())));
        } else if(justPlayed) {
            System.out.println(" -- ");
            System.out.println(petFacesTired.get(rand.nextInt(petFacesTired.size())));
            this.justPlayed = false;
        } else if(thirstLevel <= 50 && hungerLevel <= 50 && boredomLevel <= 50){
            System.out.println(" -- ");
            System.out.println(petFacesHappy.get(rand.nextInt(petFacesHappy.size())));
        } else {
            System.out.print(" -- ");
            System.out.println(petFacesNeutral.get(rand.nextInt(petFacesNeutral.size())));
        }
        System.out.println("");
    }

    public void checkEndGame() {
        if (thirstCounter + hungerCounter > 10 || age > maxAge) {
            isAlive = false;
        }
        if (boredomCounter > 10){
            wantsToEscape = true;
        }
    }

    public void increaseAge(){
        // increase age by zero or 1;
        int n = rand.nextInt(10);
        if(n <= 3){ this.age++;}

    }



}
