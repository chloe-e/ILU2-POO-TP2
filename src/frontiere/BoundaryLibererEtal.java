package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0] == "true") {
				System.out.println("Vous avez vendu " + donneesEtal[4] + " " + donneesEtal[2] 
						+ " sur " + donneesEtal[3] + ".");
				System.out.println("Au revoir " + donneesEtal[1] + ", passez une bonne journée.");
			}
		}
	}

}
