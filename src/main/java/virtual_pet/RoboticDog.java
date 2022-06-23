package virtual_pet;

public class RoboticDog extends RoboticPet implements Walkable{

    String noise = "Bow-wow-wow-wow";
    String type = "Robotic Dog";

    public RoboticDog(String name, int age) {
        super(name, age);
    }

    // HELPERS
    public boolean isDog(){ return true; }

    // GETTERS
    public String getType(){ return type; }

    // ACTIONS
    public void makeNoise(){
        System.out.println(noise);
    }
    @Override
    public void walkPet() {
        boredomLevel -= rand.nextInt(20) + 1;
        minMaxLevels();
    }

    @Override
    public String toString() {
        return name + ", " + age + " year old " + type + " goes: " + noise + "\n " + getLevels();
    }
}
