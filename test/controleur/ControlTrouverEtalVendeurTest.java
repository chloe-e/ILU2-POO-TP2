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
	void testTrouverEtalVendeurAbsent() {
		ControlTrouverEtalVendeur controlTEV = new ControlTrouverEtalVendeur(village);
		assertTrue(controlTEV.trouverEtalVendeur("Bob") == null);
	}
	@Test
	void testTrouverEtalVendeurPresent() {
		ControlTrouverEtalVendeur controlTEV = new ControlTrouverEtalVendeur(village);
		ControlPrendreEtal controlPE = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
		village.ajouterHabitant(new Gaulois("Bob",2));
		controlPE.prendreEtal("Bob", "fleurs", 10);
		
		assertNotNull(controlTEV.trouverEtalVendeur("Bob"));
		assertTrue(controlTEV.trouverEtalVendeur("Bob").getProduit() == "fleurs");
		assertTrue(controlTEV.trouverEtalVendeur("Bob").getQuantite() == 10);
		assertTrue(controlTEV.trouverEtalVendeur("Bob").getVendeur().getNom() == "Bob");
	}
}
