package virtual_pet;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.*;

public class VirtualPetApplication {

    public static void main(String[] args) throws InterruptedException {
        VirtualPetApplication myGame = new VirtualPetApplication();
        myGame.gameLoop();
    }

    public void gameLoop() throws InterruptedException {
        Scanner reader = new Scanner(System.in);
        Random rand    = new Random();

        // PET CREATION
        String petName, petType, petAge;
        System.out.println("Welcome to VirtualPet!");
        System.out.println("");
        System.out.println("Name your pet!");
        petName = reader.nextLine();
        System.out.println("What type of animal is it?");
        petType = reader.nextLine();
        while(true){
            System.out.println("How old is it?");
            petAge = reader.nextLine();
            try{
                Integer.parseInt(petAge);
                break;
            } catch (NumberFormatException e){
                System.out.println("Not a number!");
            }
        }

        int randomHunger, randomThirst, randomBoredom;
        randomHunger  = rand.nextInt(20);
        randomThirst  = rand.nextInt(50);
        randomBoredom = rand.nextInt(80);

//        petName = "Paco";
//        petType = "Taco";
//        petAge = "22";

        VirtualPet userPet = new VirtualPet(petName, petType, Integer.parseInt(petAge), randomHunger, randomThirst, randomBoredom);

        // BEGIN PET LOOP
        petLoop: while(true){

            TimeUnit.SECONDS.sleep(0);

            userPet.checkLevels();
            userPet.petStatus();
            userPet.checkNeeds();
            userMenu();

            String userInput;

            // check if input is int
            while(true){
                userInput = reader.nextLine();
                try{
                    Integer.parseInt(userInput);
                    break;
                } catch (NumberFormatException e){
                    System.out.println("Not a number!");
                    TimeUnit.SECONDS.sleep(1);
                    userMenu();
                }
            }

            // process user input
            switch(Integer.parseInt(userInput)){
                case 1:
                    userPet.feedPet();
                    userPet.tick(1);
                    break;
                case 2:
                    userPet.waterPet();
                    userPet.tick(1);
                    break;
                case 3:
                    userPet.playPet();
                    userPet.tick(1);
                    break;
                case 4:
                    userPet.tick(10);
                    break;
                case 5:
                    System.out.println(petName + " says bye!");
                    TimeUnit.SECONDS.sleep(1);
                    break petLoop;
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
    }

    public void userMenu(){
        System.out.println("1. Feed your pet");
        System.out.println("2. Water your pet");
        System.out.println("3. Play with your pet");
        System.out.println("4. Do nothing");
        System.out.println("5. Quit game");
    }

}


