package virtual_pet;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VirtualPetApplication {

    public static void main(String[] args) throws InterruptedException {
        VirtualPetApplication myGame = new VirtualPetApplication();
        myGame.gameLoop();

//        VirtualPet petA = new VirtualPet("Carrot", "Cat", 10, 0,0,10);
//        VirtualPet petB = new VirtualPet("Squirtle", "Dog", 1, 100,10,10);
//        VirtualPet petC = new VirtualPet("Pirate", "Bird", 100, 10,10,100);
//        VirtualPetShelter myShelter = new VirtualPetShelter();
//
//        myShelter.addPet(petA);
//        myShelter.addPet(petB);
//        myShelter.addPet(petC);
//
//        myShelter.getStatus();
//        myShelter.feedPet();
//        myShelter.getStatus();
//        myShelter.feedPet();
//        myShelter.getStatus();
//        myShelter.feedPet();
//        myShelter.getStatus();


//        System.out.println(myShelter);

    }

    public void gameLoop() throws InterruptedException {
        VirtualPetShelter myShelter = new VirtualPetShelter();
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        String userSelection, petToAdopt;

        // Testing
        VirtualPet petA = new VirtualPet("Carrot", "Cat", 10, 0,0,10);
        VirtualPet petB = new VirtualPet("Squirtle", "Dog", 1, 100,10,10);
        VirtualPet petC = new VirtualPet("Pirate", "Bird", 100, 10,10,100);
        myShelter.addPet(petA);
        myShelter.addPet(petB);
        myShelter.addPet(petC);
        // end testing

        System.out.println("------------------------------------------");
        System.out.println("////   Welcome to the pet shelter!    ////");
        System.out.println("------------------------------------------");

        shelterLoop: while(true){
            myShelter.getStatus();
            this.shelterMenu();

            // Prompt until get a number
            while(true){
                userSelection = reader.nextLine();
                try{
                    Integer.parseInt(userSelection);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Not a number!");
                    TimeUnit.SECONDS.sleep(1);
                    this.shelterMenu();
                }
            }

            switch(Integer.parseInt(userSelection)){
                case 1:
                    myShelter.feedPet();
                    myShelter.tick();
                    break;
                case 2:
                    myShelter.waterPet();
                    myShelter.tick();
                    break;
                case 3:
                    myShelter.playPet();
                    myShelter.tick();
                    break;
                case 4:
                    System.out.println("Who do you want to adopt? ");
                    System.out.println(myShelter.getName());
                    petToAdopt = reader.nextLine();
                    myShelter.adoptPet(petToAdopt);
                    break;
                case 5:
                    VirtualPet newPet = this.createPet();
                    myShelter.addPet(newPet);
                    break;
                case 6:
                    myShelter.tick(5);
                    break;
                case 7:
                    System.out.println("Bye!");
                    break shelterLoop;
                default:
                    System.out.println("Invalid selection!");
                    break;
            }

        }

    }

    public void userMenu() {
        System.out.println("1. Feed your pet");
        System.out.println("2. Water your pet");
        System.out.println("3. Play with your pet");
        System.out.println("4. Do nothing");
        System.out.println("5. Quit game");
    }

    public void shelterMenu() {
        System.out.println("1. Feed pets");
        System.out.println("2. Water pets");
        System.out.println("3. Play with pets");
        System.out.println("4. Adopt a pet");
        System.out.println("5. Admit a pet");
        System.out.println("6. Do nothing");
        System.out.println("7. Quit game");
    }

    public VirtualPet createPet(){
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        int randomHunger, randomThirst, randomBoredom;
        String petName, petType, petAge;

        System.out.println("Name your pet!");
        petName = reader.nextLine();
        System.out.println("What type of animal is it?");
        petType = reader.nextLine();
        while (true) {
            System.out.println("How old is it?");
            petAge = reader.nextLine();
            try {
                Integer.parseInt(petAge);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Not a number!");
            }
        }

        randomHunger = rand.nextInt(20);
        randomThirst = rand.nextInt(20);
        randomBoredom = rand.nextInt(50);
        VirtualPet newPet = new VirtualPet(petName, petType, Integer.parseInt(petAge), randomHunger, randomThirst, randomBoredom);
        return newPet;
    }

}
