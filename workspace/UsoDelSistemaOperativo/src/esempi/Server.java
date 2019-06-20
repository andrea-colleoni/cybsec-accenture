package esempi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// ServerSocket permette di iniziare ad ascoltare richieste di connessione su una porta TCP
		ServerSocket s = new ServerSocket(80);
		// quando arriva una richiesta di connessione, ServerSocket crea un nuovo socket
		// che è il vero e proprio elemento del programma che consente di comunicare in modo
		// bidirezionale (input e output)
		Socket sock = s.accept();
		// il socket mette a disposizione i due strem (inpu e output) per poter intercettare
		// i byte in arrivo e poter inviare (trasmettere sul socket) dei byte
		BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
		// il "reader" permette di leggere i byte in arrivo
		String str = br.readLine();
		// i byte in arrivo sono memorizzati in una stringa
		// a seconda di cosa è arrivato dal socket decido di rispondere in un modo o in un altro...
		// sto implementando un "protocollo" di "rete"!
		if (str.equals("GET")) {
			// con il writer invio una risposta al mio interlocutore sulla rete...
			pw.println("ciao ciao");
		} else if (str.equals("POST")) {
			pw.println("io non so camminare...");
		} else if (str.equals("corri")) {
			pw.println("non so nemmeno correre...");
		} else {
			pw.println("mmmhhh..... ??");
		}
		pw.flush();
	}

}
