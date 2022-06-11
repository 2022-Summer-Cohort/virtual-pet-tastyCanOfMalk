package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetTest {

    @Test
    public void getAgeShouldReturnAge() throws InterruptedException {
        VirtualPet underTest = new OrganicDog("test", 12);
        assertEquals(12, underTest.getAge());
    }

    @Test
    public void getNameShouldReturnName() throws InterruptedException {
        VirtualPet underTest = new OrganicDog("test", 12);
        assertEquals("test", underTest.getName());
    }

    @Test
    public void getBoredomLevelShouldReturnValue() throws InterruptedException {
        VirtualPet underTest = new OrganicDog("test", 12);
        assertTrue(Integer.valueOf(underTest.getBoredomLevel()) < 100);
    }

}
