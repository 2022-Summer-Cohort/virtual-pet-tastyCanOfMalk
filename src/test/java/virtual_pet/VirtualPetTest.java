package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetTest {

    @Test
    public void feedShouldReduceHunger(){
        VirtualPet underTest = new VirtualPet("test", 5,5,5);
        int initial = underTest.getHungerLevel();
        underTest.feed();
        assertTrue(underTest.getHungerLevel() < initial);
    }
    @Test
    public void waterShouldReduceThirst(){
        VirtualPet underTest = new VirtualPet("test", 5,5,5);
        int initial = underTest.getThirstLevel();
        underTest.water();
        assertTrue(underTest.getThirstLevel() < initial);
    }
    @Test
    public void playShouldReduceBoredom(){
        VirtualPet underTest = new VirtualPet("test", 5,5,5);
        int initial = underTest.getBoredomLevel();
        underTest.play();
        assertTrue(underTest.getBoredomLevel() < initial);
    }
    @Test
    public void tickShouldIncreaseAllLevels(){
        VirtualPet underTest = new VirtualPet("test", 5,5,5);
        int initialBoredom = underTest.getBoredomLevel();
        int initialThirst = underTest.getThirstLevel();
        int initialHunger = underTest.getHungerLevel();
        underTest.tick();
        assertTrue(underTest.getBoredomLevel() > initialBoredom);
        assertTrue(underTest.getThirstLevel() > initialThirst);
        assertTrue(underTest.getHungerLevel() > initialHunger);


    }

}
