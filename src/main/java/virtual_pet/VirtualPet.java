package virtual_pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class VirtualPet {

    Random rand = new Random();
    String name;
    int age, boredomLevel;
    ArrayList<String> petFacesNeutral   = new ArrayList<>(Arrays.asList("-_-", "(-_-)", "(￣__￣)", "(¯_¯)", "(´･_･`)", "(・_・ヾ", "(¯﹃¯)", " ( v¯﹃¯v  )", " (¯﹃¯  )"));
    ArrayList<String> petFacesNeedy     = new ArrayList<>(Arrays.asList("(-‸-)", "(⇀‸↼‶)", " (‾̀ _ ‾̀ )", "╥_╥", "ㄒ_ㄒ", " ┰_┰", "(¯﹃¯)", " ( v¯﹃¯v  )", " (¯﹃¯  )" ));
    ArrayList<String> petFacesHappy     = new ArrayList<>(Arrays.asList("(o ╹‿ ╹ o)", "(o ╹ ᴗ ╹ o)", "(o ╹ᵕ ╹ o)", "(。╹‿ ╹ 。)", "(。╹ ᴗ ╹。)", "(o l ‿ l o)", "ヽ(•‿•)ノ", "(¯﹃¯)", " ( v¯﹃¯v  )", " (¯﹃¯  )"));
    ArrayList<String> robotFacesNeutral = new ArrayList<>(Arrays.asList("└[∵┌]", "└[ ∵ ]┘", "[|∵]┘","~(o_o)~","└|▽▽||"));
    ArrayList<String> robotFacesNeedy  = new ArrayList<>(Arrays.asList("Yヾ（゜□゜@）", "ヾ(ﾟ△ﾟ＠)", "ヾ(ﾟ□ﾟ＠)", "(•ˋ _ ˊ•)","(　｀_ '´)"));


    public VirtualPet(String name, int age) {
        this.age = age;
        this.name = name;
        this.boredomLevel = rand.nextInt(50);
    }

    // GETTERS
    public String getName(){ return name; }
    public int getAge(){ return age; }
    public String getType(){ return null; };
    public String getHungerLevel(){ return "."; }
    public String getThirstLevel(){ return "."; }
    public String getBoredomLevel(){  return String.valueOf(boredomLevel); }
    public String getSoiledEnclosure(){ return "Pristine"; }
    public String getOilLevel(){ return "."; }
    public String getMaintenanceLevel(){ return "."; }
    public String getStatus(){ return "." ;};

    // HELPERS
    public void minMaxLevels(){}
    public boolean isRobot(){ return false; }
    public boolean isDog(){ return false; }

    // TICK
    public void tick(int n){}

    // ORGANIC
    public void feedPet() throws InterruptedException {}
    public void waterPet() throws InterruptedException {}

    public void cleanEnclosure() throws InterruptedException {}
    // ROBOTIC
    public void maintainPet(){}

    public void oilPet(){}
    // DOG

    public void walkPet() throws InterruptedException {}

    // ALL PETS
    public void playPet(){}
    public void makeNoise(){}


}
