package esempi;

import java.io.File;

public class EsempioFileSystem {

	public static void main(String[] args) {
		// tramite la JVM, chiedo al sistema operativo di darmi informazioni su di un file
		// uso una classe del java.io che implementa una comunicazione tra processi in cui
		// il mio interlocutore è, appunto, il sistema operativo ed in particolare, il file system
		File f = new File("C:\\Users\\andre\\Desktop\\Temp\\Corsi\\"
				+ "CyberSecurity-Accenture\\gitrepo\\workspace\\"
				+ "UsoDelSistemaOperativo\\src\\dffsfsaffsdf.txt");
		
		if (f.exists()) {
			System.out.println("il file esiste!!");
		} else {
			System.out.println("il file non esiste...");
		}
	}

}
