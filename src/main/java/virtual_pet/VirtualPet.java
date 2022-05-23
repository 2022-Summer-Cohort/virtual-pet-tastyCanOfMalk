package virtual_pet;

public class VirtualPet {
    private String name;
    private int age;
    private String type;

    public VirtualPet(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public void tick(){
        this.age++;
    }

    public String introduce(){
        return("Say hello to " + this.name + " who is a " + this.age + " year old " + this.type);
    }
}
