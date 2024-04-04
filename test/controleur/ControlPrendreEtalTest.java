package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
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
	void testResteEtalsTrue() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVI,village);
		assertTrue(controlPrendreEtal.resteEtals());
		for (int i = 0; i < 5; i++) {
			controlPrendreEtal.prendreEtal("Vendeur", "fleurs", 10);
		}
		assertFalse(controlPrendreEtal.resteEtals());
	}
	@Test
	void testResteEtalsFalse() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVI,village);
		for (int i = 0; i < 5; i++) {
			controlPrendreEtal.prendreEtal("Vendeur", "fleurs", 10);
		}
		assertFalse(controlPrendreEtal.resteEtals());
	}
	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVI,village);
		Gaulois gaulois = new Gaulois("Bob",2);
		village.ajouterHabitant(gaulois);
		int res = controlPrendreEtal.prendreEtal("Bob","fleurs", 10);
		ControlTrouverEtalVendeur controlTEV = new ControlTrouverEtalVendeur(village);
		Etal etal = controlTEV.trouverEtalVendeur("Bob");
		assertTrue(etal.getVendeur().equals(gaulois));
		assertTrue(etal.getProduit().equals("fleurs"));
		assertTrue(etal.getQuantite() == 10);
	}
	@Test
	void testVerifierIdentiteTrue() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVI,village);
		assertTrue(controlPrendreEtal.verifierIdentite("Abraracourcix"));
	}
	@Test
	void testVerifierIdentiteFalse() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVI,village);
		assertFalse(controlPrendreEtal.verifierIdentite("Bob"));

	}

}
