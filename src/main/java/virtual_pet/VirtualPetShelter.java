package virtual_pet;

import virtual_pet.VirtualPet;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class VirtualPetShelter {

    ArrayList<VirtualPet> pets = new ArrayList<>();

    public VirtualPetShelter() {
    }

    // MODIFY SHELTER
    public void addPet(VirtualPet pet){ this.pets.add(pet); }
    public void removePet(String petName){ pets.removeIf(n -> (n.getName().equals(petName))); }

    // GETTERS
    public void getStatus() {
        System.out.println("--------------------------");
        System.out.println("///// Shelter status ///// ");
        System.out.println("--------------------------");

        // get max name length for initial spacing
        int maxNameLength = 0;
        for (VirtualPet pet : pets) {
            String placeHolder = pet.getName() + ", " + pet.getAge() + " year-old " + pet.getType();
//            System.out.println(placeHolder);
            if (placeHolder.length() > maxNameLength) {
                maxNameLength = placeHolder.length();
            }
        }

        // create top legend | 8 | 8 | 9 | 11 |  7  | 13 |
        String topLegend = "";
        for (int i = 0; i < maxNameLength; i++) {
            topLegend += " ";
        }
        topLegend += "| Hunger | Thirst | Boredom | Enclosure |  Oil  | Maintenance | Status ..";
        System.out.println(topLegend);


        // Construct name with padded spaces for each pet
        for (VirtualPet pet : pets) {
            // pad the names
//                String paddedString = pet.getName();
            String placeHolder  = pet.getName() + ", " + pet.getAge() + " year-old " + pet.getType();
            String paddedString = pet.getName() + ", " + pet.getAge() + " year-old " + pet.getType();
            if (pet.getName().length() < maxNameLength) {
                for (int i = 0; i < maxNameLength - placeHolder.length(); i++) {
                    paddedString += ".";
                }
            }
            // add status values and padding for each pet
            paddedString += "| " + pet.getHungerLevel();
            while(paddedString.length() < maxNameLength + 9){ paddedString += " " ;}
            paddedString += "| " + pet.getThirstLevel();
            while(paddedString.length() < maxNameLength + 18){ paddedString += " " ;}
            paddedString += "| " + pet.getBoredomLevel();
            while(paddedString.length() < maxNameLength + 28){ paddedString += " " ;}
            paddedString += "| " + pet.getSoiledEnclosure();
            while(paddedString.length() < maxNameLength + 40){ paddedString += " " ;}
            paddedString += "| " + pet.getOilLevel();
            while(paddedString.length() < maxNameLength + 48){ paddedString += " " ;}
            paddedString += "| " + pet.getMaintenanceLevel();
            while(paddedString.length() < maxNameLength + 62){ paddedString += " " ;}
            paddedString += "| " + pet.getStatus();

            System.out.println(paddedString);

        }
    }
    public void getStatus(String pet){
        System.out.println("----------------");
        System.out.println("|| Pet status ||");
        System.out.println("----------------");
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                System.out.println(p);
            }
        }

    }

    // HELPERS
    public String printNames(){
        String names = "";
        for(VirtualPet pet : pets){
            names += pet.getName() + ", ";
        }
        return names.substring(0, names.length()-2);
    }
    public ArrayList<String> getNamesArray(){
        ArrayList<String> names = new ArrayList<>();
        for(VirtualPet pet : pets){
            names.add(pet.getName().toLowerCase());
        }
        return names;
    }

    // TICK
    public void tick(int n){
        for(VirtualPet pet : pets){
            pet.tick(n);
        }
    }
    public void tick(String pet, int n){
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                p.tick(n);
            }
        }
    }


    // ORGANIC ACTIONS
    public void feedPet() throws InterruptedException {
        for(VirtualPet pet : pets){
            pet.feedPet();
        }
    }
    public void feedPet(String pet) throws InterruptedException {
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                p.feedPet();
                if(p.isRobot()){
                    System.out.println("Can't feed robots!");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        }
    }
    public void waterPet() throws InterruptedException {
        for(VirtualPet pet : pets){
            pet.waterPet();
        }
    }
    public void waterPet(String pet) throws InterruptedException {
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                p.waterPet();
                if(p.isRobot()){
                    System.out.println("Can't water robots!");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        }
    }
    public void cleanEnclosure() throws InterruptedException {
        for(VirtualPet pet : pets){
            pet.cleanEnclosure();
        }
    }
    public void cleanEnclosure(String pet) throws InterruptedException {
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                p.cleanEnclosure();
                if(p.isRobot()){
                    System.out.println("The enclosure is pristine..");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        }
    }

    // ROBOTIC ACTIONS
    public void maintainPet(){
        for(VirtualPet pet : pets){
            pet.maintainPet();
        }
    }
    public void maintainPet(String pet) throws InterruptedException {
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                p.maintainPet();
                if(!p.isRobot()){
                    System.out.println("Can't maintain animals!");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        }
    }
    public void oilPet(){
        for(VirtualPet pet : pets){
            pet.oilPet();
        }
    }
    public void oilPet(String pet) throws InterruptedException {
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                p.oilPet();
                if(!p.isRobot()){
                    System.out.println("Can't oil animals!");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        }
    }

    // DOG ACTIONS
    public void walkPet() throws InterruptedException {
        for(VirtualPet pet : pets){
            pet.walkPet();
        }
    }
    public void walkPet(String pet) throws InterruptedException {
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                p.walkPet();
                if(!p.isDog()){
                    System.out.println("They don't want to walk..");
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        }
    }

    // ALL PETS
    public void playPet(){
        for(VirtualPet pet : pets){
            pet.playPet();
        }
    }
    public void playPet(String pet){
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                p.playPet();
            }
        }
    }
    public void makeNoise(String pet) throws InterruptedException {
        for(VirtualPet p : pets){
            if(p.getName().toLowerCase().equals(pet.toLowerCase())){
                p.makeNoise();
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }



}
