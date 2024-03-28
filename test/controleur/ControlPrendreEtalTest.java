package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef chef;
	private ControlVerifierIdentite controlVI;
	
	@BeforeEach
	public void init() {
		village = new Village("Village",10,5);
		chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
		controlVI = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVI,village);
		assertNotNull(controlPrendreEtal);
	}
	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVI,village);
		assertTrue(controlPrendreEtal.resteEtals());
		for (int i = 0; i < 5; i++) {
			controlPrendreEtal.prendreEtal("Vendeur", "fleurs", 10);
		}
		assertFalse(controlPrendreEtal.resteEtals());
	}
	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVI,village);
		controlPrendreEtal.prendreEtal("Vendeur","fleurs", 10);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertTrue(controlTrouverEtalVendeur.trouverEtalVendeur("Vendeur") == village.rechercherEtal(new Gaulois("Vendeur",2)));
	}
	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVI,village);
		assertTrue(controlPrendreEtal.verifierIdentite("Abraracourcix"));
		assertFalse(controlPrendreEtal.verifierIdentite("Bob"));

	}

}
