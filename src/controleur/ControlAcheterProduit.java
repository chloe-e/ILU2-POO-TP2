package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	
	public String[] vendeursProduit(String produit) {
		Gaulois[] vendeursProduit = village.rechercherVendeursProduit(produit);
		if(vendeursProduit != null) {
			String [] listeVendeurs = new String[vendeursProduit.length];
			for (int i = 0; i < vendeursProduit.length; i++) {
				listeVendeurs[i] = vendeursProduit[i].getNom();
			}
			return listeVendeurs;
		}
		return null;
	}
	
	public int getQuantiteProduit(String nomVendeur) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		Etal etal = village.rechercherEtal(vendeur);
		return etal.getQuantite();
	}
	
	public void acheterProduit(String nomVendeur, int quantite) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur);
		Etal etal = village.rechercherEtal(vendeur);
		etal.acheterProduit(quantite);
	}
}
