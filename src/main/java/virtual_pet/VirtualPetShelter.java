package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {
    ArrayList<VirtualPet> pets = new ArrayList<>();

    public VirtualPetShelter() {
    }

    // MODIFY PETS
    public void addPet(VirtualPet pet){
        this.pets.add(pet);
    }
    public void adoptPet(String petName){ pets.removeIf(n -> (n.getName().equals(petName))); }

    // GET PET DETAILS
    public String getName(VirtualPet pet) { return pet.getName(); }
    public String getType(VirtualPet pet){
        return pet.getType();
    }
    public Integer getAge(VirtualPet pet){
        return pet.getAge();
    }
    public String getName() {
        String toReturn = "";
        if(this.pets.size() > 0){
            toReturn += "Names of pets in the shelter: ";
            for (VirtualPet pet : this.pets) {
                toReturn += pet.getName() + ", ";
            }
            return toReturn.substring(0, toReturn.length() - 2);
        } else {
            toReturn += "No pets here!";
        }
        return toReturn;
    }
    public String getType() {
        String toReturn = "";
        if(this.pets.size() > 0){
            toReturn += "Types of pets in the shelter: ";
            for (VirtualPet pet : this.pets) {
                toReturn += pet.getType() + ", ";
            }
            return toReturn.substring(0, toReturn.length() - 2);
        } else {
            toReturn += "No pets here!";
        }
        return toReturn;
    }
    public String getAge() {
        String toReturn = "";
        if(this.pets.size() > 0){
            toReturn += "Ages of pets in the shelter: ";
            for (VirtualPet pet : this.pets) {
                toReturn += pet.getAge() + ", ";
            }
            return toReturn.substring(0, toReturn.length() - 2);
        } else {
            toReturn += "No pets here!";
        }
        return toReturn;
    }

    // GET PET STATS
    public void getStatus(VirtualPet pet){ pet.printPetStatus(); }
    public void getBoredomLevel(VirtualPet pet){ System.out.println("Boredom: " + pet.getBoredomLevel()); }
    public void getThirstLevel(VirtualPet pet){  System.out.println(" Thirst: " + pet.getThirstLevel()); }
    public void getHungerLevel(VirtualPet pet){  System.out.println(" Hunger: " + pet.getHungerLevel()); }
    public void getStatus(){
        System.out.println(" ................................ ");
        System.out.println(" .....    Shelter status    ..... ");
        if(pets.size() == 1){
            for(VirtualPet pet : pets){
                pet.printPetStatus();
            }
        } else {
            // get max name length of pet names for spacing
            int maxNameLength = 0;
            for(VirtualPet pet : pets){
                String placeHolder = pet.getName() + " the " + pet.getAge() + " year-old " + pet.getType();
                if(placeHolder.length() > maxNameLength){ maxNameLength = placeHolder.length() ;}
//                if( pet.getName().length() > maxNameLength) { maxNameLength = pet.getName().length(); }
            }

            // create top legend (8 char spaces total)
            String topLegend = "";
            for(int i = 0; i < maxNameLength; i++){
                topLegend += " ";
            }
            topLegend += "| Hunger | Thirst | Boredom | Status ";
            System.out.println(topLegend);

            // Construct name with padded spaces for each pet
            for(VirtualPet pet : pets){
                // pad the names
//                String paddedString = pet.getName();
                String placeHolder = pet.getName() + " the " + pet.getAge() + " year-old " + pet.getType();
                String paddedString = pet.getName() + " the " + pet.getAge() + " year-old " + pet.getType();
                if(pet.getName().length() < maxNameLength){
                    for(int i = 0; i < maxNameLength - placeHolder.length(); i++){
                        paddedString += " ";
                    }
                }
                // add status values and padding for each pet
                paddedString += "| " + pet.getHungerLevel();
                while(paddedString.length() < maxNameLength + 9){ paddedString += " " ;}
                paddedString += "| " + pet.getThirstLevel();
                while(paddedString.length() < maxNameLength + 18){ paddedString += " " ;}
                paddedString += "| " + pet.getBoredomLevel();
                while(paddedString.length() < maxNameLength + 28){ paddedString += " " ;}
                paddedString += "| " + pet.getStatusEmoji();
                System.out.println(paddedString);

            }
            // line break after all status
            System.out.println(" ------------ ");
        }
    }
    public void getStatus(String pet){
        for(VirtualPet p : pets){
            if(p.getName().equals(pet)){
                p.printPetStatus();
            }
        }
    }
    public void getHungerLevel(){
        if(this.pets.size() > 0 ) {
            System.out.println("Hunger ");
            for(VirtualPet pet : pets){
                System.out.println(pet.getName() + ": " + pet.getHungerLevel());
            }
        } else {
            System.out.println("Not pets!");
        }
    }
    public void getThirstLevel(){
        if(this.pets.size() > 0 ){
            System.out.println("Thirst: ");
            for(VirtualPet pet : pets){
                System.out.println(pet.getName() + ": " + pet.getThirstLevel());
            }
        } else {
            System.out.println("Not pets!");
        }    }
    public void getBoredomLevel(){
        if(this.pets.size() > 0 ) {
            System.out.println("Boredom: ");
            for(VirtualPet pet : pets){
                System.out.println(pet.getName() + ": " + pet.getBoredomLevel());
            }
        } else {
            System.out.println("Not pets!");
        }    }

    // GIVE PET ATTENTION
    public void feedPet() throws InterruptedException {
        for(VirtualPet pet : pets){
            pet.feedPet();
        }
    }
    public void waterPet() throws InterruptedException {
        for(VirtualPet pet : pets){
            pet.waterPet();
        }
    }
    public void playPet() throws InterruptedException {
        for(VirtualPet pet : pets){
            pet.playPet();
        }
    }
    public void feedPet(String pet) throws InterruptedException {
        for(VirtualPet p : pets){
            if(p.getName().equals(pet)){
                p.feedPet();
            }
        }
    }
    public void waterPet(VirtualPet pet) throws InterruptedException { pet.waterPet(); }
    public void playPet(VirtualPet pet) throws InterruptedException { pet.playPet(); }

    // TICKS
    public void tick(){
        for(VirtualPet pet : pets){
            pet.tick();
        }
    }
    public void tick(int n){
        for(VirtualPet pet : pets){
            pet.tick(n);
        }
    }

    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
        String toReturn = "Pets in the shelter: " + newLine;
        for(VirtualPet pet : pets){
            toReturn += pet.getName() + ", the " + pet.getAge() + " year-old " + pet.getType() + newLine;
        }
        return toReturn;
    }
}
