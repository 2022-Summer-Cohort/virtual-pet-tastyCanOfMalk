package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetTest {

    @Test
    public void increaseHungerShouldIncreaseHungerLevel() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initial = underTest.getHungerLevel();
        int n = 1;
        underTest.increaseHungerLevel(n);
        assertTrue(underTest.getHungerLevel() == initial + n);
    }

    @Test
    public void increaseThirstShouldIncreaseThirstLevel() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initial = underTest.getThirstLevel();
        int n = 1;
        underTest.increaseThirstLevel(n);
        assertTrue(underTest.getThirstLevel() == initial + n);
    }

    @Test
    public void increaseBoredomShouldIncreaseBoredomLevel() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initial = underTest.getBoredomLevel();
        int n = 1;
        underTest.increaseBoredomLevel(n);
        assertTrue(underTest.getBoredomLevel() == initial + n);
    }

    @Test
    public void decreaseHungerShouldDecreaseHungerLevel() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initial = underTest.getHungerLevel();
        int n = 1;
        underTest.decreaseHungerLevel(n);
        assertTrue(underTest.getHungerLevel() == initial - n);
    }

    @Test
    public void decreaseThirstShouldDecreaseThirstLevel() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initial = underTest.getThirstLevel();
        int n = 1;
        underTest.decreaseThirstLevel(n);
        assertTrue(underTest.getThirstLevel() == initial - n);
    }

    @Test
    public void decreaseBoredomShouldDecreaseBoredomLevel() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initial = underTest.getBoredomLevel();
        int n = 1;
        underTest.decreaseBoredomLevel(n);
        assertTrue(underTest.getBoredomLevel() == initial - n);
    }

    @Test
    public void tickShouldIncreaseAllLevels() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initialBoredom = underTest.getBoredomLevel();
        int initialThirst = underTest.getThirstLevel();
        int initialHunger = underTest.getHungerLevel();
        underTest.tick(1);
        assertTrue(underTest.getBoredomLevel() > initialBoredom);
        assertTrue(underTest.getThirstLevel() > initialThirst);
        assertTrue(underTest.getHungerLevel() > initialHunger);
    }

    @Test
    public void feedPetShouldDecreaseHunger() throws InterruptedException {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initial = underTest.getHungerLevel();
        underTest.feedPet();
        assertTrue(underTest.getHungerLevel() < initial);
    }

    @Test
    public void waterPetShouldDecreaseThirst() throws InterruptedException {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initial = underTest.getThirstLevel();
        underTest.waterPet();
        assertTrue(underTest.getThirstLevel() < initial);
    }

    @Test
    public void playPetShouldDecreaseBoredom() throws InterruptedException {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        int initial = underTest.getBoredomLevel();
        underTest.playPet();
        assertTrue(underTest.getBoredomLevel() < initial);
    }

    @Test
    public void levelsOver100AndUnder0ShouldBeAdjusted() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, -500, 500, 500);
        underTest.checkLevels();
        assertTrue(underTest.getHungerLevel() == 0);
        assertTrue(underTest.getThirstLevel() == 100);
        assertTrue(underTest.getBoredomLevel() == 100);

    }

}
