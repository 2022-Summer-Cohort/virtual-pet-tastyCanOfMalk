package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {
    ArrayList<VirtualPet> pets = new ArrayList<>();

    public VirtualPetShelter() {
    }

    public void addPet(VirtualPet pet){
        this.pets.add(pet);
    }

    public void listPetsInShelter(){
        System.out.println("There are a total of " + pets.size() + " pets in the shelter: ");
        for(VirtualPet pet : this.pets){
            System.out.println(pet);
        }
    }

    public String getName(VirtualPet pet){
        return pet.getName();
    }
    public String getName() {
        String petNames = "Names of pets in the shelter: ";
        for (VirtualPet pet : this.pets) {
            petNames += pet.getName() + ", ";
        }
        return petNames.substring(0, petNames.length() - 2);
    }

    public String getType(VirtualPet pet){
        return pet.getType();
    }
    public String getType() {
        String petTypes = "Types of pets in the shelter: ";
        for (VirtualPet pet : this.pets) {
            petTypes += pet.getType() + ", ";
        }
        return petTypes.substring(0, petTypes.length() - 2);
    }

    public Integer getAge(VirtualPet pet){
        return pet.getAge();
    }
    public String getAge() {
        String petAges = "Ages of pets in the shelter: ";
        for (VirtualPet pet : this.pets) {
            petAges += Integer.toString(pet.getAge()) + ", ";
        }
        return petAges.substring(0, petAges.length() - 2);
    }
    public void getHungerLevel(){
        System.out.println("Hunger: ");
        for(VirtualPet pet : pets){
            System.out.println(pet.getName() + ": " + pet.getHungerLevel());
        }
    }
    public void getThirstLevel(){
        System.out.println("Thirst: ");
        for(VirtualPet pet : pets){
            System.out.println(pet.getName() + ": " + pet.getThirstLevel());
        }
    }
    public void getBoredomLevel(){
        System.out.println("Boredom: ");
        for(VirtualPet pet : pets){
            System.out.println(pet.getName() + ": " + pet.getBoredomLevel());
        }
    }
    public void getBoredomLevel(VirtualPet pet){ System.out.println("Boredom: " + pet.getBoredomLevel()); }
    public void getThirstLevel(VirtualPet pet){ System.out.println("Thirst: " + pet.getThirstLevel()); }
    public void getHungerLevel(VirtualPet pet){ System.out.println("Hunger: " + pet.getHungerLevel()); }
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
    public void feedPet(VirtualPet pet) throws InterruptedException { pet.feedPet(); }
    public void waterPet(VirtualPet pet) throws InterruptedException { pet.waterPet(); }
    public void playPet(VirtualPet pet) throws InterruptedException { pet.playPet(); }

    public void printStatus(){
        for(VirtualPet pet : pets){
            pet.printPetStatus();
        }
    }

    public void printStatus(VirtualPet pet){
        pet.printPetStatus();
    }

    public void adoptPet(String petName){
        pets.removeIf(n -> (n.getName().equals(petName)));
    }

    public void tick(){
        for(VirtualPet pet : pets){
            pet.tick();
        }
    }

}
