package virtual_pet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetShelterTest {

    @Test
    public void getTypeShouldReturnTypeOfPet() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        VirtualPetShelter petShelter = new VirtualPetShelter();
        petShelter.addPet(underTest);
        assertTrue(underTest.getType() == petShelter.getType(underTest));
    }
    @Test
    public void getTypeShouldReturnNameOfPet() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        VirtualPetShelter petShelter = new VirtualPetShelter();
        petShelter.addPet(underTest);
        assertTrue(underTest.getName() == petShelter.getName(underTest));
    }
    @Test
    public void getTypeShouldReturnAgeOfPet() {
        VirtualPet underTest = new VirtualPet("test", "test", 50, 50, 50, 50);
        VirtualPetShelter petShelter = new VirtualPetShelter();
        petShelter.addPet(underTest);
        assertTrue(underTest.getAge() == petShelter.getAge(underTest));
    }

}