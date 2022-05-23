package virtual_pet;

public class VirtualPetApplication {

    public static void main(String[] args) {
        //Interact with a VirtualPet object in this method

        VirtualPet Paco = new VirtualPet("Paco", 2, "Alpaca");

        System.out.println(Paco.introduce());
        Paco.tick();
        System.out.println(Paco.introduce());





    }

}
