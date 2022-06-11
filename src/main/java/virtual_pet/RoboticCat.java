package virtual_pet;

public class RoboticCat extends RoboticPet {

    String noise = "Me e e e-Oww ow ow";
    String type = "Robotic Cat";

    public RoboticCat(String name, int age) {
        super(name, age);
    }

    // GETTERS
    public String getType(){ return type; }

    // ACTIONS
    public void makeNoise(){
        System.out.println(noise);
    }

    @Override
    public String toString() {
        return name + ", " + age + " year old " + type + " goes: " + noise + "\n " + getLevels();
    }
}
