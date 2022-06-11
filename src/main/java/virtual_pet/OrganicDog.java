package virtual_pet;

public class OrganicDog extends OrganicPet implements Walkable{

    String noise = "Woof!";
    String type = "Dog";

    public OrganicDog(String name, int age) {
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
        boredomLevel -= rand.nextInt(10) + 1;
        minMaxLevels();
        soilMeter -= 2;
    }

    @Override
    public String toString() {
        return name + ", " + age + " year old " + type + " goes: " + noise + "\n " + getLevels();
    }
}
