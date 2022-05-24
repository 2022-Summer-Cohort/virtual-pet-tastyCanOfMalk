package virtual_pet;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        VirtualPet spot = new VirtualPet("Spot", 1, 1, 8);

        System.out.println("Type 'q' to quit");
        System.out.println("Type '?' for commands");
        System.out.println("Commands: (f)eed, (p)lay, (w)ater, (s)tatus");
        System.out.println("---");
    while(true){

        String input = reader.nextLine().toLowerCase();

        if(spot.getRunAwayStatus()){
            break;
        }
        if(input.equals("q")){
            break;
        } else if (input.equals("?")) {
            System.out.println("Commands: (f)eed, (p)lay, (w)ater, (s)tatus");
        } else if (input.equals("f")) {
            spot.feed();
            spot.tick();
        } else if (input.equals("p")) {
            spot.play();
            spot.tick();
        } else if (input.equals("w")) {
            spot.water();
            spot.tick();
        } else if (input.equals("s")) {
            spot.status();
        } else {
            System.out.println("Invalid command");
        }

    }


    }

}


