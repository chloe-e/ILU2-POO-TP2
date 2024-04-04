package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef chef;
	private ControlTrouverEtalVendeur controlTEV;
	
	@BeforeEach
	public void init() {
		village = new Village("Village",10,5);
		chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
		controlTEV = new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLE = new ControlLibererEtal(controlTEV);
		assertNotNull(controlLE);
	}
	
	@Test
	void testIsVendeurTrue() {
		ControlLibererEtal controlLE = new ControlLibererEtal(controlTEV);
		Gaulois gaulois = new Gaulois("Bob",2);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "f", 10);
		assertTrue(controlLE.isVendeur("Bob"));
		assertFalse(controlLE.isVendeur("Bobi"));
	}
	@Test
	void testIsVendeurFalse() {
		ControlLibererEtal controlLE = new ControlLibererEtal(controlTEV);
		assertFalse(controlLE.isVendeur("Bobi"));
	}
	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLE = new ControlLibererEtal(controlTEV);
		Gaulois gaulois = new Gaulois("Bob",2);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "f", 10);
		String[] sortie = {"true","Bob","f","10","0"};
		String[] res = controlLE.libererEtal("Bob");
		
		assertTrue(res[0].equals(sortie[0]));
		for (int i = 1; i < sortie.length; i++) {
			System.out.println(res[i]);
			assertTrue(res[i].equals(sortie[i]));
		}
	}

}
