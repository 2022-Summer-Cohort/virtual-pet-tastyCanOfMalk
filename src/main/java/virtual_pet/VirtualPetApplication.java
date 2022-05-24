package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        VirtualPet Paco  = new VirtualPet("Paco", 1, "Alpaca", "Pacapaca", 5);
        VirtualPet Teddy = new VirtualPet("Teddy", 1, "Bear", "Roaaar!", 3);
        VirtualPet Sonic = new VirtualPet("Sonic", 1, "Hedgehog", "Meow?", 10);

        String selection;

        Paco.introduce();

        while(true){
            Paco.petStatus();

            System.out.println("What do you want to do (pet, play, clean, wait, or quit)?");
            selection = reader.nextLine().toLowerCase();

            if(selection.equals("pet")){
                Paco.pet();
            } else if (selection.equals("play")){
                Paco.play();
            } else if (selection.equals("wait")){
                Paco.tick();
            } else if (selection.equals("clean")){
                Paco.cleanPoop();
            } else if (selection.equals("quit")){
                break;
            } else {
                System.out.println("Invalid, try again");
            }
        }



        }



}

