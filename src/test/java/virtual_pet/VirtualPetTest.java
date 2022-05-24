package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {

    @Test
    public void feedShouldReduceHunger(){
        VirtualPet underTest = new VirtualPet("test", 5,5,5);
        underTest.feed();
        assertEquals(underTest.getHungerLevel(), 3);
    }
    @Test
    public void waterShouldReduceThirst(){
        VirtualPet underTest = new VirtualPet("test", 5,5,5);
        underTest.water();
        assertEquals(underTest.getThirstLevel(), 3);
    }
    @Test
    public void playShouldReduceBoredom(){
        VirtualPet underTest = new VirtualPet("test", 5,5,5);
        underTest.play();
        assertEquals(underTest.getBoredomLevel(), 3);
    }
    @Test
    public void tickShouldIncreaseAllLevels(){
        VirtualPet underTest = new VirtualPet("test", 5,5,5);
        underTest.tick();
        assertEquals(underTest.getBoredomLevel(), 6);
        assertEquals(underTest.getThirstLevel(), 6);
        assertEquals(underTest.getHungerLevel(), 6);
    }

}
