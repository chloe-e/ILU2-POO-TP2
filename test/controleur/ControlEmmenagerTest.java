package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void init() {
		village = new Village("Village",10,5);
		chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
	}
	
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager);
	}
	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Gaulois", 2);
		assertTrue(controlEmmenager.isHabitant("Gaulois"));
	}
	@Test
	void testAjouterDruide() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Druide", 2,1,4);
		assertTrue(controlEmmenager.isHabitant("Druide"));
	}
	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		//cas gaulois présent
		controlEmmenager.ajouterGaulois("Bob", 4);
		assertTrue(controlEmmenager.isHabitant("Bob"));
		//cas druide présent
		controlEmmenager.ajouterDruide("Druide", 2, 3, 4);
		assertTrue(controlEmmenager.isHabitant("Druide"));
		//cas gaulois absent
		assertFalse(controlEmmenager.isHabitant("Bob2"));
	}

}
