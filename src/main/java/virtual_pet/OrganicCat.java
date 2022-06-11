package virtual_pet;

public class OrganicCat extends OrganicPet {

    String noise = "Meow!";
    String type = "Cat";

    public OrganicCat(String name, int age) {
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
