package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrganicPetTest {


    @Test
    public void petsShouldHaveThirstLevels() throws InterruptedException {
        OrganicCat underTest = new OrganicCat("underTest", 100);
        assertTrue(Integer.parseInt(underTest.getThirstLevel()) > -1);
    }
    @Test
    public void petsShouldHaveHungerLevels() throws InterruptedException {
        OrganicCat underTest = new OrganicCat("underTest", 100);
        assertTrue(Integer.parseInt(underTest.getHungerLevel()) > -1);
    }
    @Test
    public void playingShouldReduceBoredom() throws InterruptedException {
        OrganicCat underTest = new OrganicCat("underTest", 100);
        int initial = Integer.parseInt(underTest.getBoredomLevel());
        underTest.playPet();
        int after = Integer.parseInt(underTest.getBoredomLevel());
        assertTrue(initial > after);
    }
}
