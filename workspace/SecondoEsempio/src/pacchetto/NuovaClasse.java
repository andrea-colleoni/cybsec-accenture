package pacchetto;

import pacchetto1.SecondaClasse;
import pacchetto2.TerzaClasse;

public class NuovaClasse {

	public static void main(String[] args) {
		// da ogni classe posso vedere solo l'interfaccia pubblica delle classi che intendo chiamare
		SecondaClasse.main(null);
		
		TerzaClasse.main(null);
	}

}
