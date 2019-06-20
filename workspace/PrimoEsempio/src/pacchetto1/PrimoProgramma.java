package pacchetto1;

public class PrimoProgramma {

	public static void main(String[] args) {
		// se definisco metodi con diversi "modificatori di visibilità", potrò richiamarli solo
		// dal contesto in cui questi metodi risulteranno visibili
		System.out.println("Ciao mondo!!");
		System.out.println("istruzione 2");
		
		metodo();
		metodoProtetto();
		metodoDefault();
	}
	// un metodo privato: si vede solo dall'interno di questa classe
	private static void metodo() {
		System.out.println("nel metodo privato...");
	}
	// un metodo protected: si vede da questa classe e da tutte le sue "sotto-classi"
	protected static void metodoProtetto() {
		System.out.println("nel metodo protetto...");
	}
	// un metodo "default" o "package": si vede da questa classe e da tutte le classi dello stesso package
	static void metodoDefault() {
		System.out.println("nel metodo default...");
	}

}
