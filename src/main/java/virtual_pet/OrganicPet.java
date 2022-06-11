package virtual_pet;

import java.util.Random;

public abstract class OrganicPet extends VirtualPet {

    int hungerLevel, thirstLevel;

    int soilMeter = 0, maxSoilMeter = 4;
    boolean soiledEnclosure = false;
    int soiledInstances = 0, maxSoiledInstances = 3;
    boolean wantsToEscape = false, escaped = false;

    boolean isHungry, isThirsty;
    int hungerThirstCounter = 0, maxHungerThirst = 8;
    boolean isDead = false;

    boolean isBored = false;
    int boredomCounter = 0, maxBoredom = 8;

    public OrganicPet(String name, int age) {
        super(name, age);
        this.hungerLevel = rand.nextInt(30);
        this.thirstLevel = rand.nextInt(40);
    }

    // TICKER
    public void tick(int n){
        hungerLevel  += rand.nextInt(n) + 1;
        thirstLevel  += rand.nextInt(n) + 1;
        boredomLevel += rand.nextInt(n) + 1;
        minMaxLevels();
        if(escaped || isDead){ zeroLevels(); }
        updateSoilMeter();
    }

    // GETTERS
    public String getHungerLevel(){ return String.valueOf(hungerLevel); }
    public String getThirstLevel(){ return String.valueOf(thirstLevel); }
    public String getSoiledEnclosure(){
        if(escaped || isDead){ return "Empty"; }
        else if(soiledEnclosure){ return "Dirty"; }
        else{ return "Clean"; }
    }
    public String getLevels(){
        return "| Hunger:" + hungerLevel + ", Thirst: " + thirstLevel + ", Boredom: " + boredomLevel + "\n | Enclosure soiled? " + soiledEnclosure + "\n | Status: " + getStatus();
    }

    // HELPERS
    public void minMaxLevels(){
        if(hungerLevel <= 0){ hungerLevel = 0; }
        else if(hungerLevel >= 100){ hungerLevel = 100; }
        if(thirstLevel <= 0){ thirstLevel = 0; }
        else if(thirstLevel >= 100){ thirstLevel = 100; }
        if(boredomLevel <= 0){ boredomLevel = 0; }
        else if(boredomLevel >= 100){ boredomLevel = 100; }
    }
    public void zeroLevels(){
        hungerLevel = 0;
        thirstLevel = 0;
        boredomLevel = 0;
    }

    // ORGANIC ACTIONS
    public void feedPet() {
        hungerLevel  -= rand.nextInt(20) + 1;
        thirstLevel  += rand.nextInt(10) + 1;
        minMaxLevels();
    }
    public void waterPet(){
        thirstLevel  -= rand.nextInt(30) + 1;
        minMaxLevels();
    }
    public void cleanEnclosure(){
        soilMeter = 0;
        soiledEnclosure = false;
    }

    // SOIL METER
    public void updateSoilMeter(){
        if(soiledEnclosure){ soiledInstances++; }
        if(soiledInstances >= maxSoiledInstances){ wantsToEscape = true; }

        if(soilMeter >= maxSoilMeter){
            soiledEnclosure = true;
        } else if (soilMeter < 0) {
            soilMeter = 0;
        } else {
            // add 0 or 1
            soilMeter += rand.nextInt(2);
        }
    }

    // PET STATUS
    public String getStatus(){
        String toReturn = "";

        checkHungerThirst();
        if(!isDead){checkBoredom();}

        if(escaped || isDead){ return getStatusEmoji(); }
        else if(isHungry || isThirsty){ toReturn += getStatusEmoji() + "  " + name + "'s tummy growls.. "  ; }
        else if(isBored){ toReturn += getStatusEmoji() + " " + name + " is bored! " ; }
        else if(!isHungry && !isBored && !isThirsty){ return getStatusEmoji(); }
        if(wantsToEscape){
            escaped = true;
            if(isBored){return " ran away from boredom! " ;}
            else { return name + " ran away from poor living conditions! "; }
        }
        if(soiledEnclosure){ toReturn += "They messed the crate! "; }

        return toReturn;
    }
    public void checkHungerThirst(){
        if(hungerThirstCounter >= maxHungerThirst) { isDead = true; }
        else if(isHungry || isThirsty){ hungerThirstCounter++; }
        if(hungerLevel >= 100){ isHungry = true; }
        if(hungerLevel < 100) { isHungry = false; }
        if(thirstLevel >= 100){ isThirsty = true; }
        if(thirstLevel < 100) { isThirsty = false; }
    }
    public void checkBoredom(){
        if(boredomCounter >= maxBoredom) { wantsToEscape = true; }
        else if(isBored){boredomCounter++;}
        if(boredomLevel >= 100){ isBored = true;  }
        if(boredomLevel < 100){  isBored = false; }
    }

    // FETCH EMOJI
    public String getStatusEmoji (){
        if(isDead){ return "(X_×)" ;}
        else if(escaped){ return "┗( ＾0＾)┓"; }
        else if(isHungry || isThirsty){ return petFacesNeedy.get(rand.nextInt(petFacesNeedy.size()));}
        else if(isBored){ return petFacesNeutral.get(rand.nextInt(petFacesNeutral.size())) ;}
        else { return petFacesHappy.get(rand.nextInt(petFacesHappy.size())) ;}
    }

    // ALL PETS
    public void playPet() {
        boredomLevel -= rand.nextInt(10) + 1;
        minMaxLevels();
    }

    // --- ROBOTIC PLACEHOLDERS
    public void oilPet(){}
    public void maintainPet(){}
}
