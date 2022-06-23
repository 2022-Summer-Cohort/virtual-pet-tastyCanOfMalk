package virtual_pet;

import java.util.concurrent.TimeUnit;

public abstract class RoboticPet extends VirtualPet {

    int oilLevel, maintenanceLevel;
    int brokenCounter = 0, maxBroken = 10;
    boolean isRusty = false, requiresMaintenance = false, isBroken = false, isBored = false, isAlmostBroken = false;

    public RoboticPet(String name, int age) {
        super(name, age);
        this.oilLevel = 90 + rand.nextInt(10);
        this.maintenanceLevel = 90 + rand.nextInt(10);
        this.boredomLevel = rand.nextInt(10);
    }

    public boolean isRobot(){ return true; }

    // TICKER
    public void tick(int n){
        // robots have smaller ticks
        double robotFactor = 0.5;
        maintenanceLevel  -= (rand.nextInt(n) + 1) * robotFactor;
        oilLevel          -= (rand.nextInt(n) + 1) * robotFactor;
        boredomLevel      += (rand.nextInt(n) + 1) * robotFactor;
        minMaxLevels();
        if(isBroken){zeroLevels();}
    }

    // GETTERS
    public String getOilLevel(){ return String.valueOf(oilLevel); }
    public String getMaintenanceLevel(){ return String.valueOf(maintenanceLevel); }
    public String getLevels(){
        return "| Maintenance: " + maintenanceLevel + ", Oil: " + oilLevel + ", Boredom: " + boredomLevel + "\n | Status: " + getStatus();
    }

    // HELPERS
    public void minMaxLevels(){
        if(maintenanceLevel <= 0){ maintenanceLevel = 0; }
        else if(maintenanceLevel >= 100){ maintenanceLevel = 100; }
        if(oilLevel <= 0){ oilLevel = 0; }
        else if(oilLevel >= 100){ oilLevel = 100; }
        if(boredomLevel <= 0){ boredomLevel = 0; }
        else if(boredomLevel >= 100){ boredomLevel = 100; }
    }
    public void zeroLevels(){
        oilLevel = 0;
        maintenanceLevel = 0;
        boredomLevel = 0;
    }

    // ROBOTIC ACTIONS
    public void maintainPet(){
        maintenanceLevel  += rand.nextInt(10) + 1;
        minMaxLevels();
    }
    public void oilPet(){
        oilLevel  += rand.nextInt(10) + 1;
        minMaxLevels();
    }
    public void playPet() {
        boredomLevel -= rand.nextInt(25) + 1;
        minMaxLevels();
    }

    // PET STATUS
    public String getStatus(){
        String toReturn = "";

        checkBroken();
        if(isBroken){ return getStatusEmoji(); }

        if(!isBroken){ checkOil(); checkBoredom(); }
        if(isRusty){ toReturn += getStatusEmoji() + " " + name + " is making some weird noises.. "; }
        if(requiresMaintenance){ toReturn += " maintenance required.. "; }
        if(isBored){
            if(!isRusty && !requiresMaintenance){
                toReturn += getStatusEmoji();
            }
            toReturn += " can robots be bored? ";
        }
        if(isAlmostBroken){
            isBroken = true;
            return name + " broke down! ";
        }

        if(!isBored && !isRusty){ return getStatusEmoji(); }
        return toReturn;

    }

    public void checkBroken(){
        if(brokenCounter >= maxBroken) { isAlmostBroken = true; }
        else if(requiresMaintenance){ brokenCounter += rand.nextInt(2); }
        if(maintenanceLevel <= 0){ requiresMaintenance = true; }
        if(maintenanceLevel > 0){ requiresMaintenance = false; }
    };
    public void checkOil(){
        if(isRusty){ tick(10); }
        if(oilLevel <= 0){ isRusty = true; }
        if(oilLevel > 0){ isRusty = false; }
    }
    public void checkBoredom(){
        if(isBored){ tick(5);}
        if(boredomLevel >= 100){ isBored = true;  }
        if(boredomLevel < 100){  isBored = false; }
    }

    public String getStatusEmoji(){
        if(isBroken){return "(✖╭╮✖)"; }
        if (isRusty || isBored){return robotFacesNeedy.get(rand.nextInt(robotFacesNeedy.size())); }
        return robotFacesNeutral.get(rand.nextInt(robotFacesNeutral.size()));
    }

    // --- ORGANIC PLACEHOLDERS
    public void feedPet() throws InterruptedException {
//        System.out.println("Can't feed robots...");
//        TimeUnit.SECONDS.sleep(1);
    }
    public void waterPet() throws InterruptedException {
//        System.out.println("Can't water robots...");
//        TimeUnit.SECONDS.sleep(1);
    }
    public void cleanEnclosure() throws InterruptedException {
//        System.out.println("Nothing to clean...");
//        TimeUnit.SECONDS.sleep(1);
    }
    public void walkPet() throws InterruptedException {
//        System.out.println("They don't want to walk.. ");
//        TimeUnit.SECONDS.sleep(1);
    }


}
