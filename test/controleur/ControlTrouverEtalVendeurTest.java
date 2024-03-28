package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void init() {
		village = new Village("Village",10,5);
		chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTEV = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTEV);
	}
	@Test
	void testtrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTEV = new ControlTrouverEtalVendeur(village);
		assertTrue(controlTEV.trouverEtalVendeur("Bob") == null);
		ControlPrendreEtal controlPE = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		controlPE.prendreEtal("Bob", "fleurs", 10);
		assertTrue(controlTEV.trouverEtalVendeur("Bob") == village.rechercherEtal(new Gaulois("Bob",2)));
	}
}
