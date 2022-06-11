package virtual_pet;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class VirtualPetApplication {
    public static void main(String[] args) throws InterruptedException {
        VirtualPetApplication myGame = new VirtualPetApplication();
        myGame.gameLoop();
    }

    public void gameLoop() throws InterruptedException {
        Scanner reader = new Scanner(System.in);

        // INITIALIZE STARTING SHELTER
        VirtualPetShelter myShelter = new VirtualPetShelter();
        OrganicCat petA = new OrganicCat("Squirt", 5);
        OrganicDog petB = new OrganicDog("Bert", 3);
        RoboticCat petC = new RoboticCat("AlphaCat", 302);
        RoboticDog petD = new RoboticDog("BetaDog", 35);
        myShelter.addPet(petA);
        myShelter.addPet(petB);
        myShelter.addPet(petC);
        myShelter.addPet(petD);
        // end

        int shelterLoopInput = 10;
        while(shelterLoopInput != 12){
            myShelter.getStatus();
            shelterMenu();
            shelterLoopInput = processInput(myShelter);

            switch(shelterLoopInput){
                case 1: myShelter.feedPet();        myShelter.tick(10); break;
                case 2: myShelter.waterPet();       myShelter.tick(10); break;
                case 3: myShelter.cleanEnclosure(); myShelter.tick(5); break;
                case 4: myShelter.maintainPet();    myShelter.tick(10); break;
                case 5: myShelter.oilPet();         myShelter.tick(10); break;
                case 6: myShelter.walkPet();        myShelter.tick(10); break;
                case 7: myShelter.playPet();        myShelter.tick(5); break;
                case 8:
                    System.out.println("Who do you want to adopt? ");
                    System.out.println(myShelter.printNames());
                    System.out.print("Input: ");
                    String petToAdopt = reader.nextLine();
                    myShelter.removePet(petToAdopt);
                    break;
                case 9:
                    myShelter.addPet(createPet());
                    System.out.println("Thanks for dropping them off...");
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case 10: myShelter.tick(100); break;
                case 11:
                    System.out.print("Who do you want to select? ");
                    System.out.println(myShelter.printNames());
                    String petSelected = reader.nextLine();

                    if(myShelter.getNamesArray().contains(petSelected.toLowerCase())) {
                        System.out.println(petSelected + "... Okay!"); TimeUnit.SECONDS.sleep(1);

                        int petLoopInput = 0;
                        while(petLoopInput != 8){
                            myShelter.getStatus(petSelected);
                            petMenu();
                            petLoopInput = processInput(myShelter);

                            switch(petLoopInput){
                                case 1: myShelter.feedPet(petSelected);         myShelter.tick(petSelected, 15); break;
                                case 2: myShelter.waterPet(petSelected);        myShelter.tick(petSelected, 15); break;
                                case 3: myShelter.cleanEnclosure(petSelected);  myShelter.tick(petSelected, 5); break;
                                case 4: myShelter.maintainPet(petSelected);     myShelter.tick(petSelected, 10); break;
                                case 5: myShelter.oilPet(petSelected);          myShelter.tick(petSelected, 10); break;
                                case 6: myShelter.walkPet(petSelected);         myShelter.tick(petSelected, 15); break;
                                case 7: myShelter.playPet(petSelected);         myShelter.tick(petSelected, 15); break;
                                case 8: myShelter.makeNoise(petSelected);       break;
                                default: System.out.println("Invalid.. "); TimeUnit.SECONDS.sleep(1); break;
                            }
                        }
                        TimeUnit.SECONDS.sleep(1);
                    } else {
                        System.out.println("That pet doesn't exist..."); TimeUnit.SECONDS.sleep(1);
                    }
                    break;
                case 12: System.out.println("Bye!"); TimeUnit.SECONDS.sleep(1); break;
                default: System.out.println("Invalid..."); TimeUnit.SECONDS.sleep(1); break;
            }
        }
    }
    public void shelterMenu() {
        System.out.println(".................................");
        System.out.println(".. Select an action ..............................................................");
        System.out.println("| <<Organic pets>>     | <<Robotic pets>> | <<All pets>> |     8. Adopt a pet     ");
        System.out.println("|   1. Feed            |   4. Maintain    |   7. Play    |     9. Admit a pet     ");
        System.out.println("|   2. Water           |   5. Oil         |              |    10. Do nothing      ");
        System.out.println("|   3. Clean enclosure | <<Dogs>>                             11. Select one pet  ");
        System.out.println("                           6. Walk                            12. Quit            ");
        System.out.print("Input: ");
    }
    public void petMenu() {
        System.out.println(".................................");
        System.out.println(".. Select an action ..............................................................");
        System.out.println("1. Feed pet           5. Oil pet");
        System.out.println("2. Water pet          6. Walk pet");
        System.out.println("3. Clean enclosure    7. Play with pet");
        System.out.println("4. Maintain pet       8. Back to shelter..");
//        System.out.println("5. Oil pet");
//        System.out.println("6. Walk pet");
//        System.out.println("7. Play with pet");
//        System.out.println("8. Back to shelter..");
    }

    public VirtualPet createPet() throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        boolean robot, dog;
        String name;
        int age;
        String robotSelection = null;
        String dogSelection = null;

        System.out.print("What is the pets name? ");
        name = reader.nextLine();
        System.out.print("How old is it? ");
        age = Integer.parseInt(reader.nextLine());
        System.out.print("Is it a robot? (Y/N): ") ;
        robotSelection = reader.nextLine().toLowerCase();
        while(true) {
            if (!robotSelection.equals("y") && !robotSelection.equals("n")) {
                System.out.println("Invalid response...");
                TimeUnit.SECONDS.sleep(1);
                System.out.print("Is it a robot? (Y/N): ");
                robotSelection = reader.nextLine().toLowerCase();
            } else if (robotSelection.equals("y")) {
                robot = true;
                break;
            } else if (robotSelection.equals("n")) {
                robot = false;
                break;
            }
        }
        System.out.print("Is it a dog? (Y/N): ") ;
        dogSelection = reader.nextLine().toLowerCase();
        while(true) {
            if (!dogSelection.equals("y") && !dogSelection.equals("n")) {
                System.out.println("Invalid response...");
                TimeUnit.SECONDS.sleep(1);
                System.out.print("Is it a dog? (Y/N): ");
                dogSelection = reader.nextLine().toLowerCase();
            } else if (dogSelection.equals("y")) {
                dog = true;
                break;
            } else if (dogSelection.equals("n")) {
                dog = false;
                break;
            }
        }

        if(robot && dog){
            RoboticDog newPet = new RoboticDog(name, age);
            return newPet;
        } else if(!robot && dog){
            OrganicDog newPet = new OrganicDog(name, age);
            return newPet;
        } else if(!robot && !dog){
            OrganicCat newPet = new OrganicCat(name, age);
            return newPet;
        } else {
            RoboticCat newPet = new RoboticCat(name, age);
            return newPet;
        }
    }

    public int processInput(VirtualPetShelter myShelter) throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        String userSelection;
        while(true){
            userSelection = reader.nextLine();
            try{
                Integer.parseInt(userSelection);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Not a number!");
                TimeUnit.SECONDS.sleep(1);
                myShelter.getStatus();
                shelterMenu();
            }
        }
        return Integer.parseInt(userSelection);
    }
}
