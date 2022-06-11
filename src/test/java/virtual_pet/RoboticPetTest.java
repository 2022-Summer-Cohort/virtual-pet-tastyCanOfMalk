package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoboticPetTest {

    @Test
    public void robotsShouldHaveOilLevels() throws InterruptedException {
        RoboticCat underTest = new RoboticCat("underTest", 100);
        assertTrue(Integer.parseInt(underTest.getOilLevel()) > 0);
    }
    @Test
    public void robotsShouldHaveMaintenanceLevels() throws InterruptedException {
        RoboticCat underTest = new RoboticCat("underTest", 100);
        assertTrue(Integer.parseInt(underTest.getMaintenanceLevel()) > 0);
    }
    @Test
    public void playingShouldReduceBoredom() throws InterruptedException {
        RoboticCat underTest = new RoboticCat("underTest", 100);
        int initial = Integer.parseInt(underTest.getBoredomLevel());
        underTest.playPet();
        int after = Integer.parseInt(underTest.getBoredomLevel());
        assertTrue(initial > after);
    }
}
