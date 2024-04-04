package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void init() {
		village = new Village("Village",10,5);
		chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVI = new ControlVerifierIdentite(village);
		assertNotNull(controlVI);
	}
	@Test
	void testVerifierIdentiteFalse() {
		ControlVerifierIdentite controlVI = new ControlVerifierIdentite(village);
		assertFalse(controlVI.verifierIdentite("Bob"));
		assertTrue(controlVI.verifierIdentite("Abraracourcix"));
	}
	@Test
	void testVerifierIdentiteTrue() {
		ControlVerifierIdentite controlVI = new ControlVerifierIdentite(village);
		assertTrue(controlVI.verifierIdentite("Abraracourcix"));
	}

}
