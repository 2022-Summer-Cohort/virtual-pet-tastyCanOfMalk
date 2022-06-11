package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetShelterTest {

    @Test
    public void addPetShouldAddPet() throws InterruptedException {
        VirtualPet testPet = new OrganicDog("test", 12);
        VirtualPetShelter testShelter = new VirtualPetShelter();
        testShelter.addPet(testPet);
        assertEquals(1, testShelter.getNamesArray().size());
    }

    @Test
    public void removePetShouldRemovePet() throws InterruptedException {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet = new OrganicDog("test", 12);
        VirtualPet testPet2 = new OrganicDog("test2", 12);
        testShelter.addPet(testPet);
        testShelter.addPet(testPet2);
        testShelter.removePet("test2");
        assertEquals(1, testShelter.getNamesArray().size());
    }

    @Test
    public void playShouldDecreaseBoredom() throws InterruptedException {
        VirtualPetShelter testShelter = new VirtualPetShelter();
        VirtualPet testPet = new OrganicDog("test", 12);
        testShelter.addPet(testPet);
        int initial = Integer.parseInt(testPet.getBoredomLevel());
        testShelter.playPet();
        int after = Integer.parseInt(testPet.getBoredomLevel());
        assertTrue(initial > after);
    }



}
